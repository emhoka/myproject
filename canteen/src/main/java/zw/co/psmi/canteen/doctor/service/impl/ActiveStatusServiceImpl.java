package zw.co.psmi.canteen.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.doctor.dao.ActiveStatusDao;
import zw.co.psmi.canteen.doctor.entity.ActiveStatus;
import zw.co.psmi.canteen.doctor.service.ActiveStatusService;


@Service
public class ActiveStatusServiceImpl  implements ActiveStatusService{
	 private ActiveStatusDao activeStatusDao;

	    @Autowired
	    public ActiveStatusServiceImpl(ActiveStatusDao activeStatusDao) {
	        this.activeStatusDao = activeStatusDao;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(ActiveStatus activeStatus) {
	        this.activeStatusDao.save(activeStatus);
	        return "Sucessfully saved activeStatus";
	    }

	    @Override
	    public ActiveStatus getByID(Long userID) {
	    	ActiveStatus activeStatus = this.activeStatusDao.findOne(userID);
	        if (activeStatus == null) {
	        	activeStatus = new ActiveStatus();
	        }
	        return activeStatus;
	    }


	    @Override
	    public ActiveStatus findByName(String name) {
	        // TODO Auto-generated method stub
	        return activeStatusDao.findByName(name);
	    }

	    @Override
	    public JpaRepository<ActiveStatus, Long> getDao() {
	        return activeStatusDao;
	    }
	    

		  @Override
		    public List<ActiveStatus> findAll() {
		        return activeStatusDao.findAll();
		    }


}
