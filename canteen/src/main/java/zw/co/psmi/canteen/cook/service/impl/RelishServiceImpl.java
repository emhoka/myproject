package zw.co.psmi.canteen.cook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.cook.dao.RelishDao;
import zw.co.psmi.canteen.cook.entity.Relish;
import zw.co.psmi.canteen.cook.service.RelishService;

@Service
public class RelishServiceImpl implements RelishService{

	  private RelishDao relishDao;

	    @Autowired
	    public RelishServiceImpl(RelishDao relishDao) {
	        this.relishDao = relishDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(Relish relish) {
	       this.relishDao.save(relish);
	        return "Sucessfully saved Relish";
	    }

	    @Override
	    public String delete(long id) {
	        this.relishDao.delete(id);
	        return "Sucessfully deleted protein";
	    }
	    @Override
	    public Relish getByID(Long relishID) {
	    	Relish relish = this.relishDao.findOne(relishID);
	        if (relish == null) {
	        	relish = new Relish();
	        }
	        return relish;
	    }

		@Override
		public JpaRepository<Relish, Long> getDao() {
			// TODO Auto-generated method stub
			return relishDao;
		}


		@Override
		public Relish findByRelishName(String relishName) {
			// TODO Auto-generated method stub

	        return relishDao.findByRelishName(relishName);
		}
		
		 @Override
		    public List<Relish> findAll() {
		        return relishDao.findAll();
		    }

}
