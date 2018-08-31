package zw.co.psmi.canteen.cook.service;

import zw.co.psmi.canteen.basic.BasicService;
import zw.co.psmi.canteen.cook.entity.Starch;

public interface StarchService extends BasicService<Starch>{
	public	Starch findByStarchName(String starchName);
	String delete(long id);
}
