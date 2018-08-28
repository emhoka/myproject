package zw.co.psmi.canteen.cook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class cookviewController {
	
	 @RequestMapping(value = "/cook/cookview", method = RequestMethod.GET)
		public String cookview() {
			return "/cook/cookview";
		}
	 @RequestMapping(value = "/cook/userprofile", method = RequestMethod.GET)
		public String userprofile() {
			return "/cook/userprofile";
		}
	 @RequestMapping(value = "/cook/NewFile", method = RequestMethod.GET)
		public String NewFile() {
			return "/cook/NewFile";
		}
	 @RequestMapping(value = "/cook/login", method = RequestMethod.GET)
		public String login() {
			return "/cook/login";
		} 
	

}
