package zw.co.psmi.canteen.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.admin.entity.Diagnosis;

public interface DiagnosisDao extends JpaRepository<Diagnosis, Long> {
	public	Diagnosis findByCode(String code);


}
