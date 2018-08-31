package zw.co.psmi.canteen.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import zw.co.psmi.canteen.admin.service.RoleService;
import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.entity.Role;

import zw.co.psmi.canteen.auth.entity.Login;

@Controller
public class RoleController {
	
	
	private RoleService roleService;
    //Create user
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    } 
    
	@RequestMapping(value = "/admin/rolelist", method = RequestMethod.GET)
		public String rolelist(@AuthenticationPrincipal Login login, Model model) {
        model.addAttribute("roles", this.roleService.findAll());	
		return "/admin/rolelist";
	}
	
	   //Role
	 @RequestMapping(value = "/admin/role", method = RequestMethod.GET)
		public String role(@ModelAttribute Role role, Model model) {
		 model.addAttribute("roles", role);
		 return "/admin/role";
		}
	 
	 @RequestMapping(value = "/admin/deleterole/{Id}", method = RequestMethod.GET)
	   public String deleterole( @PathVariable("Id") Long Id,   @ModelAttribute Department department, @ModelAttribute Role role,  Model model, RedirectAttributes redirectAttributes) {
		 String msg = roleService.delete(Id);
		 redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
       return "redirect:/admin/rolelist";
	    }
	 
	 @RequestMapping(value = "/admin/roleform", method = RequestMethod.POST)
	    public String roleform( @ModelAttribute Role role, Model model, RedirectAttributes redirectAttributes) {
		String msg = this.roleService.save(role);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/admin/rolelist";
	    }


}
