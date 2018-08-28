package zw.co.psmi.canteen.doctor.service;

import zw.co.psmi.canteen.basic.BasicService;
import zw.co.psmi.canteen.doctor.entity.ActiveStatus;

public interface ActiveStatusService extends BasicService<ActiveStatus>{
	public ActiveStatus findByName(String name);
}
