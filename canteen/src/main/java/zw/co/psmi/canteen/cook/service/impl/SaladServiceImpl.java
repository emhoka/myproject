package zw.co.psmi.canteen.cook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.cook.dao.SaladDao;
import zw.co.psmi.canteen.cook.entity.Salad;
import zw.co.psmi.canteen.cook.service.SaladService;

@Service
public class SaladServiceImpl implements SaladService{
	
	private SaladDao saladDao;

    @Autowired
    public SaladServiceImpl(SaladDao saladDao) {
        this.saladDao = saladDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public String save(Salad salad) {
       this.saladDao.save(salad);
        return "Sucessfully saved Salad";
    }

    @Override
    public Salad getByID(Long saladID) {
    	Salad salad = this.saladDao.findOne(saladID);
        if (salad == null) {
        	salad = new Salad();
        }
        return salad;
    }

	@Override
	public JpaRepository<Salad, Long> getDao() {
		// TODO Auto-generated method stub
		return saladDao;
	}


	@Override
	public Salad findBySaladName(String saladName) {
		// TODO Auto-generated method stub

        return saladDao.findBySaladName(saladName);
	}
	
	 @Override
	    public List<Salad> findAll() {
	        return saladDao.findAll();
	    }

}
