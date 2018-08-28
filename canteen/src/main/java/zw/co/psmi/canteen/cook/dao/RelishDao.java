package zw.co.psmi.canteen.cook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zw.co.psmi.canteen.cook.entity.Relish;

@Repository
public interface RelishDao extends JpaRepository<Relish, Long>{
	public	Relish findByRelishName(String relishName);

}
