package zw.co.psmi.canteen.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.admin.entity.Salutation;


public interface SalutationDao extends JpaRepository<Salutation, Long>{
	public	Salutation findByName(String name);

}
