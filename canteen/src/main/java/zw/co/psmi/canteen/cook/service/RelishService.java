package zw.co.psmi.canteen.cook.service;

import zw.co.psmi.canteen.basic.BasicService;
import zw.co.psmi.canteen.cook.entity.Relish;

public interface RelishService extends BasicService<Relish>{
	public	Relish findByRelishName(String relishName);
}
