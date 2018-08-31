package zw.co.psmi.canteen.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zw.co.psmi.canteen.admin.dao.DepartmentDao;
import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public String save(Department department) {
    	this.departmentDao.save(department);
        return "Sucessfully saved Department";
    }
    
    @Override
    public String delete(long id) {
        this.departmentDao.delete(id);
        return "Sucessfully deleted department";
    }
     

    @Override
    public Department getByID(Long departmentID) {
    	Department department = this.departmentDao.findOne(departmentID);
        if (department == null) {
        	department = new Department();
        }
        return department;
    }

	@Override
	public JpaRepository<Department, Long> getDao() {
		 return departmentDao;
	}


	@Override
	public Department findByDepartmentName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentDao.findByDepartmentName(departmentName);
	}

	  @Override
	    public List<Department> findAll() {
	        return departmentDao.findAll();
	    }

	

}
