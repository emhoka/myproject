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

import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.entity.Role;
import zw.co.psmi.canteen.admin.service.DepartmentService;
import zw.co.psmi.canteen.auth.entity.Login;

@Controller
public class DepartmentController {
	
	private DepartmentService departmentService;
    //Create user
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    } 
    
	@RequestMapping(value = "/admin/departmentlist", method = RequestMethod.GET)
		public String departmentlist(@AuthenticationPrincipal Login login, Model model) {
        model.addAttribute("departments", this.departmentService.findAll());	
		return "/admin/departmentlist";
	}
	
	   //Department
	 @RequestMapping(value = "/admin/department", method = RequestMethod.GET)
		public String department(@ModelAttribute Department department, Model model) {
		 model.addAttribute("departments", department);
		 return "/admin/department";
		}
	 
	 @RequestMapping(value = "/admin/deletedepartment/{Id}", method = RequestMethod.GET)
	   public String deletedepartment( @PathVariable("Id") Long Id,   @ModelAttribute Department department, @ModelAttribute Role role,  Model model, RedirectAttributes redirectAttributes) {
		 String msg = departmentService.delete(Id);
		 redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
     return "redirect:/admin/departmentlist";
	    }
	 
	 @RequestMapping(value = "/admin/departmentform", method = RequestMethod.POST)
	    public String departmentform( @ModelAttribute Department department, Model model, RedirectAttributes redirectAttributes) {
		String msg = this.departmentService.save(department);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/admin/departmentlist";
	    }


}
