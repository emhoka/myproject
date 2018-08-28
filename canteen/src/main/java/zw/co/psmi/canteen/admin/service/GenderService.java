package zw.co.psmi.canteen.admin.service;

import zw.co.psmi.canteen.admin.entity.Gender;
import zw.co.psmi.canteen.basic.BasicService;

public interface GenderService  extends BasicService<Gender> {
	
	public	Gender findByName(String name);
}
