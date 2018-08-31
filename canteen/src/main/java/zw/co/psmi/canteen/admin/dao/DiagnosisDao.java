package zw.co.psmi.canteen.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.admin.entity.Diagnosis;

public interface DiagnosisDao extends JpaRepository<Diagnosis, Long> {
	 public List<Diagnosis>  findTop100ByNameContainingOrNameContainingOrNameContaining(String string, String string0, String string1);

	    public List<Diagnosis>  findTop100ByNameContainingOrNameContaining(String string, String string0);

	    public List<Diagnosis> findTop100ByNameContaining(String string);

	    List<Diagnosis> findDiagnosesByName (String name);

	    List<Diagnosis> findDiagnosesByCode (String code);
	    
	    public Diagnosis findByCode (String code);

	    List<Diagnosis> findByNameAndIdNot (String name, Long id);

	    List<Diagnosis> findByCodeAndIdNot (String code, Long id);


}
