package zw.co.psmi.canteen.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class adminiviewController {

	
	 
	 @RequestMapping(value = "/admin/adminiview", method = RequestMethod.GET)
		public String adminiview() {
			return "/admin/adminiview";
		}
	 @RequestMapping(value = "/admin/adminprofile", method = RequestMethod.GET)
		public String adminprofile() {
			return "/admin/adminprofile";
		}
}
