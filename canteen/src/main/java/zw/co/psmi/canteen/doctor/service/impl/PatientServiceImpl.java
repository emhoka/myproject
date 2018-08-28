package zw.co.psmi.canteen.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.doctor.dao.PatientDao;
import zw.co.psmi.canteen.doctor.entity.Patient;
import zw.co.psmi.canteen.doctor.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService{

	 private PatientDao patientDao;

	    @Autowired
	    public PatientServiceImpl(PatientDao patientDao) {
	        this.patientDao = patientDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(Patient patient) {
	        this.patientDao.save(patient);
	        return "Sucessfully saved patient";
	    }

	    @Override
	    public Patient getByID(Long userID) {
	    	Patient patient = this.patientDao.findOne(userID);
	        if (patient == null) {
	        	patient = new Patient();
	        }
	        return patient;
	    }


	    @Override
	    public Patient findByPhone(String phone) {
	        // TODO Auto-generated method stub
	        return patientDao.findByPhone(phone);
	    }

	    @Override
	    public JpaRepository<Patient, Long> getDao() {
	        return patientDao;
	    }
	    

		  @Override
		    public List<Patient> findAll() {
		        return patientDao.findAll();
		    }

	
	
}
