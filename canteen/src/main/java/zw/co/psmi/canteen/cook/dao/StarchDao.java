package zw.co.psmi.canteen.cook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zw.co.psmi.canteen.cook.entity.Starch;

@Repository
public interface StarchDao extends JpaRepository<Starch, Long>{
	public	Starch findByStarchName(String starchName);
}
