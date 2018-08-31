package zw.co.psmi.canteen.cook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.cook.entity.SubOrders;

public interface SubOrdersDao extends JpaRepository<SubOrders, Long> {
	public List<SubOrders> findAll();
	public List<SubOrders> findByCreationDate(String creationTime);
}