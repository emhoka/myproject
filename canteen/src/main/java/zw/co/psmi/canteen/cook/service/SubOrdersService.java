package zw.co.psmi.canteen.cook.service;


import java.util.List;

import zw.co.psmi.canteen.basic.BasicService;
import zw.co.psmi.canteen.cook.entity.SubOrders;

public interface SubOrdersService extends BasicService<SubOrders>{
	public List<SubOrders> findAll();

}