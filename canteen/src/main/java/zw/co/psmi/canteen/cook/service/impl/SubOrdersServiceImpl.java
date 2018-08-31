package zw.co.psmi.canteen.cook.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zw.co.psmi.canteen.auth.entity.Login;
import zw.co.psmi.canteen.auth.entity.User;
import zw.co.psmi.canteen.auth.service.UserService;
import zw.co.psmi.canteen.cook.dao.SubOrdersDao;
import zw.co.psmi.canteen.cook.entity.SubOrders;
import zw.co.psmi.canteen.cook.service.SubOrdersService;

@Service
@Slf4j
public class SubOrdersServiceImpl implements SubOrdersService{
	
	  private SubOrdersDao subOrdersDao;
	  private UserService userService;
	    @Autowired
	    public SubOrdersServiceImpl(SubOrdersDao subOrdersDao, UserService userService) {
	        this.subOrdersDao = subOrdersDao;
	        this.userService = userService;
	    }

	    @Override
	    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	    public String save(SubOrders subOrders) {
	    	String username = getCurrentAuditor().getUsername();
	    	User user = userService.findByUsername(username);
			subOrders.setUser(user);
			subOrders.setDepartment(user.getDepartment());
	       this.subOrdersDao.save(subOrders);
	        return "Order successfully submitted";
	    }

	    
	    public Login getCurrentAuditor() {
	        try {
	            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	            if (authentication != null && authentication.isAuthenticated()) {
	                if (authentication.getPrincipal() instanceof Login) {
	                    return (Login) authentication.getPrincipal();
	                }
	            }
	        } catch (Exception e) {
	            LoggerFactory.getLogger(getClass()).error("Authentication:{}", e.getMessage());
	        }
	        return null;
	    }
	    
	    
	    
	    
	
	    @Override
	    public SubOrders getByID(Long subOrdersID) {
	    	SubOrders subOrders = this.subOrdersDao.findOne(subOrdersID);
	        if (subOrders == null) {
	        	subOrders = new SubOrders();
	        }
	        return subOrders;
	    }

		@Override
		public JpaRepository<SubOrders, Long> getDao() {
			// TODO Auto-generated method stub
			return subOrdersDao;
		}


		 @Override
		    public List<SubOrders> findAll() {
		        return subOrdersDao.findAll();
		    }

		@Override
		public List<SubOrders> findByDate() {
			// TODO Auto-generated method stub
			String creationDate;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			creationDate = dtf.format(LocalDateTime.now());
		
			return subOrdersDao.findByCreationDate(creationDate);
		}


}
