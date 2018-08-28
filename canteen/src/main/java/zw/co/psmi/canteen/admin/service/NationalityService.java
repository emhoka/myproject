package zw.co.psmi.canteen.admin.service;

import zw.co.psmi.canteen.admin.entity.Nationality;
import zw.co.psmi.canteen.basic.BasicService;

public interface NationalityService  extends BasicService<Nationality>{
	public	Nationality findByName(String name);
	
}
