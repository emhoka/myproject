package zw.co.psmi.canteen.cook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zw.co.psmi.canteen.cook.entity.Salad;


@Repository
public interface SaladDao extends JpaRepository<Salad, Long>{
	public	Salad findBySaladName(String saladName);
}
