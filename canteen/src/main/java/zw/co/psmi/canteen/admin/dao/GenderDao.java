package zw.co.psmi.canteen.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.admin.entity.Gender;


public interface GenderDao extends JpaRepository<Gender, Long>{
	public	Gender findByName(String name);
}
