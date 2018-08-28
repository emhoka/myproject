package zw.co.psmi.canteen.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.admin.dao.NationalityDao;
import zw.co.psmi.canteen.admin.entity.Nationality;
import zw.co.psmi.canteen.admin.service.NationalityService;


@Service
public class NationalityServiceImpl implements NationalityService{
	
	 private NationalityDao nationalityDao;

	    @Autowired
	    public NationalityServiceImpl(NationalityDao nationalityDao) {
	        this.nationalityDao = nationalityDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(Nationality nationality) {
	       this.nationalityDao.save(nationality);
	        return "Sucessfully saved Nationality";
	    }

	    @Override
	    public Nationality getByID(Long nationalityID) {
	    	Nationality nationality = this.nationalityDao.findOne(nationalityID);
	        if (nationality == null) {
	        	nationality = new Nationality();
	        }
	        return nationality;
	    }

		@Override
		public JpaRepository<Nationality, Long> getDao() {
			// TODO Auto-generated method stub
			return nationalityDao;
		}


		@Override
		public Nationality findByName(String name) {
			// TODO Auto-generated method stub

	        return nationalityDao.findByName(name);
		}
		
		 @Override
		    public List<Nationality> findAll() {
		        return nationalityDao.findAll();
		    }

}
