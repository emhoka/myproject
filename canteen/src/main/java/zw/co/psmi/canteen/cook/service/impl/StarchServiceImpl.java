package zw.co.psmi.canteen.cook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.cook.dao.StarchDao;
import zw.co.psmi.canteen.cook.entity.Starch;
import zw.co.psmi.canteen.cook.service.StarchService;

@Service
public class StarchServiceImpl implements StarchService{

	 private StarchDao starchDao;

	    @Autowired
	    public StarchServiceImpl(StarchDao starchDao) {
	        this.starchDao = starchDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(Starch starch) {
	       this.starchDao.save(starch);
	        return "Sucessfully saved Starch";
	    }

	    @Override
	    public Starch getByID(Long starchID) {
	    	Starch starch = this.starchDao.findOne(starchID);
	        if (starch == null) {
	        	starch = new Starch();
	        }
	        return starch;
	    }

		@Override
		public JpaRepository<Starch, Long> getDao() {
			// TODO Auto-generated method stub
			return starchDao;
		}


		@Override
		public Starch findByStarchName(String starchName) {
			// TODO Auto-generated method stub

	        return starchDao.findByStarchName(starchName);
		}
		
		 @Override
		    public List<Starch> findAll() {
		        return starchDao.findAll();
		    }
	
	
}
