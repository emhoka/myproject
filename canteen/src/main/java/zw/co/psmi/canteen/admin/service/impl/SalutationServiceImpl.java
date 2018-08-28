package zw.co.psmi.canteen.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.admin.dao.SalutationDao;
import zw.co.psmi.canteen.admin.entity.Salutation;
import zw.co.psmi.canteen.admin.service.SalutationService;


@Service
public class SalutationServiceImpl implements SalutationService{

	 private SalutationDao salutationDao;

	    @Autowired
	    public SalutationServiceImpl(SalutationDao salutationDao) {
	        this.salutationDao = salutationDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(Salutation salutation) {
	       this.salutationDao.save(salutation);
	        return "Sucessfully saved salutation";
	    }

	    @Override
	    public Salutation getByID(Long salutationID) {
	    	Salutation salutation = this.salutationDao.findOne(salutationID);
	        if (salutation == null) {
	        	salutation = new Salutation();
	        }
	        return salutation;
	    }

		@Override
		public JpaRepository<Salutation, Long> getDao() {
			// TODO Auto-generated method stub
			return salutationDao;
		}


		@Override
		public Salutation findByName(String name) {
			// TODO Auto-generated method stub

	        return salutationDao.findByName(name);
		}
		
		 @Override
		    public List<Salutation> findAll() {
		        return salutationDao.findAll();
		    }

	
}
