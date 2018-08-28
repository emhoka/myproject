package zw.co.psmi.canteen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import zw.co.psmi.canteen.admin.entity.Gender;
import zw.co.psmi.canteen.admin.entity.Nationality;
import zw.co.psmi.canteen.admin.entity.Salutation;
import zw.co.psmi.canteen.admin.service.GenderService;
import zw.co.psmi.canteen.admin.service.NationalityService;
import zw.co.psmi.canteen.admin.service.SalutationService;
import zw.co.psmi.canteen.auth.entity.Login;


@Controller
public class DocController {
	private NationalityService nationalityService;
	private SalutationService salutationService;
	private GenderService genderService;
 
    @Autowired
    public DocController(NationalityService nationalityService, SalutationService salutationService, GenderService genderService) {
        this.nationalityService = nationalityService;
        this.salutationService = salutationService;
        this.genderService = genderService;
    } 
	 
	 //Nationality
	 
	 @RequestMapping(value = "/admin/nationalitylist", method = RequestMethod.GET)
		public String nationalitylist(@AuthenticationPrincipal Login login, Model model) {
     model.addAttribute("nationalitys", this.nationalityService.findAll());	
		return "/admin/nationalitylist";
	}
	 
	 @RequestMapping(value = "/admin/nationality", method = RequestMethod.GET)
		public String nationality(@ModelAttribute Nationality nationality, Model model) {
		 model.addAttribute("nationalitys", nationality);
		 return "/admin/nationality";
		}
	 
	 @RequestMapping(value = "/admin/nationalityform", method = RequestMethod.POST)
	    public String nationalityform( @ModelAttribute Nationality nationality, Model model, RedirectAttributes redirectAttributes) {
		String msg = this.nationalityService.save(nationality);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/admin/nationalitylist";
	    }
	 
 //Salutation
	 
	 @RequestMapping(value = "/admin/salutationlist", method = RequestMethod.GET)
		public String salutationlist(@AuthenticationPrincipal Login login, Model model) {
     model.addAttribute("salutations", this.salutationService.findAll());	
		return "/admin/salutationlist";
	}
	 
	 @RequestMapping(value = "/admin/salutation", method = RequestMethod.GET)
		public String salutation(@ModelAttribute Salutation salutation, Model model) {
		 model.addAttribute("salutations", salutation);
		 return "/admin/salutation";
		}
	 
	 @RequestMapping(value = "/admin/salutationform", method = RequestMethod.POST)
	    public String salutationform( @ModelAttribute Salutation salutation, Model model, RedirectAttributes redirectAttributes) {
		String msg = this.salutationService.save(salutation);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/admin/salutationlist";
	    }
	 
 //Gender
	 
	 @RequestMapping(value = "/admin/genderlist", method = RequestMethod.GET)
		public String genderlist(@AuthenticationPrincipal Login login, Model model) {
     model.addAttribute("genders", this.genderService.findAll());	
		return "/admin/genderlist";
	}
	 
	 @RequestMapping(value = "/admin/gender", method = RequestMethod.GET)
		public String gender(@ModelAttribute Gender gender, Model model) {
		 model.addAttribute("genders", gender);
		 return "/admin/gender";
		}
	 
	 @RequestMapping(value = "/admin/genderform", method = RequestMethod.POST)
	    public String genderform( @ModelAttribute Gender gender, Model model, RedirectAttributes redirectAttributes) {
		String msg = this.genderService.save(gender);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/admin/genderlist";
	    }

	 

}
