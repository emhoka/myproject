package zw.co.psmi.canteen.cook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.entity.Role;
import zw.co.psmi.canteen.auth.entity.Login;
import zw.co.psmi.canteen.cook.entity.Relish;
import zw.co.psmi.canteen.cook.entity.Salad;
import zw.co.psmi.canteen.cook.entity.Starch;
import zw.co.psmi.canteen.cook.entity.SubOrders;
import zw.co.psmi.canteen.cook.service.RelishService;
import zw.co.psmi.canteen.cook.service.SaladService;
import zw.co.psmi.canteen.cook.service.StarchService;
import zw.co.psmi.canteen.cook.service.SubOrdersService;

@Controller
@Slf4j
public class MenuController {
	private SubOrdersService subOrdersService;
	private StarchService starchService;
	private RelishService relishService;
	private SaladService saladService;
   
    @Autowired
    public MenuController(StarchService starchService, RelishService relishService, SaladService saladService, SubOrdersService subOrdersService ) {
        this.starchService = starchService;
        this.relishService = relishService;
        this.saladService = saladService;
        this.subOrdersService = subOrdersService;
    } 
 
    //Relish
	 @RequestMapping(value = "/cook/relish", method = RequestMethod.GET)
		public String relish(@ModelAttribute Relish relish, Model model) {       
		 model.addAttribute("relishs", relish);
		 return "/cook/relish";
		}
	 @RequestMapping(value = "/cook/deleterelish//{Id}", method = RequestMethod.GET)
	   public String deleterelish( @PathVariable("Id") Long Id,   @ModelAttribute Department department, @ModelAttribute Role role,  Model model, RedirectAttributes redirectAttributes) {
		 String msg = relishService.delete(Id);
		 redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
return "redirect:/cook/order";
	    }
	 
	 
	 @RequestMapping(value = "/cook/relishform", method = RequestMethod.POST)
	    public String relishform(@ModelAttribute Relish relish, Model model, RedirectAttributes redirectAttributes) {
	     String msg = this.relishService.save(relish);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/cook/order";
	    }
	 
	//Starch
	 @RequestMapping(value = "/cook/starch", method = RequestMethod.GET)
		public String starch(@ModelAttribute Starch starch, Model model) {       
		 model.addAttribute("starchs", starch);
		 return "/cook/starch";
		}
	 @RequestMapping(value = "/cook/deletestarch//{Id}", method = RequestMethod.GET)
	   public String deletestarch( @PathVariable("Id") Long Id,  Model model, RedirectAttributes redirectAttributes) {
		 String msg = starchService.delete(Id);
		 redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
   return "redirect:/cook/order";
	    }
	 @RequestMapping(value = "/cook/starchform", method = RequestMethod.POST)
	    public String starchform(@ModelAttribute Starch starch, Model model, RedirectAttributes redirectAttributes) {
	     String msg = this.starchService.save(starch);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/cook/order";
	    }
	 
	 //Salad
	 @RequestMapping(value = "/cook/salad", method = RequestMethod.GET)
		public String salad(@ModelAttribute Salad salad, Model model) {       
		 model.addAttribute("salads", salad);
		 return "/cook/salad";
		}
	 
	 @RequestMapping(value = "/cook/deletesalad//{Id}", method = RequestMethod.GET)
	   public String deletesalad( @PathVariable("Id") Long Id,   @ModelAttribute Department department, @ModelAttribute Role role,  Model model, RedirectAttributes redirectAttributes) {
		 String msg = saladService.delete(Id);
		 redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
 return "redirect:/cook/order";
	    }
	 
	 @RequestMapping(value = "/cook/saladform", method = RequestMethod.POST)
	    public String saladform(@ModelAttribute Salad salad, Model model, RedirectAttributes redirectAttributes) {
	     String msg = this.saladService.save(salad);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/cook/order";
	    }
	
    
    
	//Uploaded Order
	 @RequestMapping(value = "/cook/order", method = RequestMethod.GET)
		public String order(@AuthenticationPrincipal Login login, Model model) {
		 model.addAttribute("relishs", this.relishService.findAll());
		 model.addAttribute("starchs", this.starchService.findAll());
		 model.addAttribute("salads", this.saladService.findAll());
		return "/cook/order";
	}
	
	 
	 
	 //Meal Ordering
	 @RequestMapping(value = "/users/ordering", method = RequestMethod.GET)
		public String ordering(@ModelAttribute SubOrders subOrders,  @ModelAttribute Relish relish, @ModelAttribute Salad salad, @ModelAttribute Starch starch, Model model) {
		 model.addAttribute("subOrderss", subOrders);
	     model.addAttribute("relishs", relishService.findAll());
	     model.addAttribute("salads", saladService.findAll());
	     model.addAttribute("starchs", starchService.findAll());
	   return "/users/ordering";
	}
	 
	 
	 @RequestMapping(value = "/users/orderingform", method = RequestMethod.POST)
	    public String orderingform( @ModelAttribute SubOrders subOrders, Model model, RedirectAttributes redirectAttributes) {
	     String msg = this.subOrdersService.save(subOrders);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/users/ordering";
	    }
	 
	 
	 //Submitted Orders
	 @RequestMapping(value = "/cook/subOrder", method = RequestMethod.GET)
	  	public String suborders(@AuthenticationPrincipal Login login, Model model) {
		 model.addAttribute("subOrderss", this.subOrdersService.findByDate());
	  		return "/cook/subOrder";
	  	}
	 
	 
	 @RequestMapping(value = "/users/userview", method = RequestMethod.GET)
		public String userview() {
			return "/users/userview";
		}
	 @RequestMapping(value = "/users/userprofile", method = RequestMethod.GET)
		public String userprofile() {
			return "/users/userprofile";
		}
 

}
