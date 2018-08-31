package zw.co.psmi.canteen.cook.service;

import zw.co.psmi.canteen.basic.BasicService;
import zw.co.psmi.canteen.cook.entity.Salad;

public interface SaladService extends BasicService<Salad>{
	public	Salad findBySaladName(String saladName);
	String delete(long id);
}
