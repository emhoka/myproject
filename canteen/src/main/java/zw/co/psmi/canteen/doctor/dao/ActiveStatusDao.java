package zw.co.psmi.canteen.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.doctor.entity.ActiveStatus;



public interface ActiveStatusDao extends JpaRepository<ActiveStatus, Long>{
	public ActiveStatus findByName(String name);
}
