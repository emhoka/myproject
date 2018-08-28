package zw.co.psmi.canteen.cook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class dieticianController {
	
	 @RequestMapping(value = "/dietician/dieticianview", method = RequestMethod.GET)
		public String dieticianview() {
			return "/dietician/dieticianview";
		}
	 @RequestMapping(value = "/dietician/userprofile", method = RequestMethod.GET)
		public String userprofile() {
			return "/dietician/userprofile";
		}

}
