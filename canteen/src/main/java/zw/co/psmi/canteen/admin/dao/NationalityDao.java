package zw.co.psmi.canteen.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.admin.entity.Nationality;


public interface NationalityDao extends JpaRepository<Nationality, Long>{
	
	public	Nationality findByName(String name);
}
