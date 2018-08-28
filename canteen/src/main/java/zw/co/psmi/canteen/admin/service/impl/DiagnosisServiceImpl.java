package zw.co.psmi.canteen.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.admin.dao.DiagnosisDao;
import zw.co.psmi.canteen.admin.entity.Diagnosis;
import zw.co.psmi.canteen.admin.service.DiagnosisService;


@Service
public class DiagnosisServiceImpl implements DiagnosisService{


	  private DiagnosisDao diagnosisDao;

	    @Autowired
	    public DiagnosisServiceImpl(DiagnosisDao diagnosisDao) {
	        this.diagnosisDao = diagnosisDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(Diagnosis diagnosis) {
	       this.diagnosisDao.save(diagnosis);
	        return "Sucessfully saved Diagnosis";
	    }

	    @Override
	    public Diagnosis getByID(Long diagnosisID) {
	    	Diagnosis diagnosis = this.diagnosisDao.findOne(diagnosisID);
	        if (diagnosis == null) {
	        	diagnosis = new Diagnosis();
	        }
	        return diagnosis;
	    }

		@Override
		public JpaRepository<Diagnosis, Long> getDao() {
			// TODO Auto-generated method stub
			return diagnosisDao;
		}


		@Override
		public Diagnosis findByCode(String code) {
			// TODO Auto-generated method stub

	        return diagnosisDao.findByCode(code);
		}
		
		 @Override
		    public List<Diagnosis> findAll() {
		        return diagnosisDao.findAll();
		    }

	
	
}
