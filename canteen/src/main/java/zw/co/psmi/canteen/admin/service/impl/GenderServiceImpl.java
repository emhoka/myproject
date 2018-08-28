package zw.co.psmi.canteen.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.admin.dao.GenderDao;
import zw.co.psmi.canteen.admin.entity.Gender;
import zw.co.psmi.canteen.admin.service.GenderService;


@Service
public class GenderServiceImpl implements GenderService {

	private GenderDao genderDao;

    @Autowired
    public GenderServiceImpl(GenderDao genderDao) {
        this.genderDao = genderDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public String save(Gender gender) {
       this.genderDao.save(gender);
        return "Sucessfully saved gender";
    }

    @Override
    public Gender getByID(Long genderID) {
    	Gender gender = this.genderDao.findOne(genderID);
        if (gender == null) {
        	gender = new Gender();
        }
        return gender;
    }

	@Override
	public JpaRepository<Gender, Long> getDao() {
		// TODO Auto-generated method stub
		return genderDao;
	}


	@Override
	public Gender findByName(String name) {
		// TODO Auto-generated method stub

        return genderDao.findByName(name);
	}
	
	 @Override
	    public List<Gender> findAll() {
	        return genderDao.findAll();
	    }
}
