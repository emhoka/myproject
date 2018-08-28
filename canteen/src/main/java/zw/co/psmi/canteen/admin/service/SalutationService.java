package zw.co.psmi.canteen.admin.service;

import zw.co.psmi.canteen.admin.entity.Salutation;
import zw.co.psmi.canteen.basic.BasicService;

public interface SalutationService extends BasicService<Salutation>{
	public	Salutation findByName(String name);

}
