package zw.co.psmi.canteen.cook.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.auth.entity.User;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_subOrders")
public class SubOrders extends BaseEntity{
	
	    @ManyToOne
	    private User user;
	    @ManyToOne
	    private Department department;
	    @ManyToOne
	    private Starch starch;
	    @ManyToOne
	    private Relish relish;
	    @ManyToOne
	    private Salad salad;
	    
	    @Override
	    public String toString() {
	        return "subOrders{" + "id=" + id + "}";
	    }

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Starch getStarch() {
			return starch;
		}

		public void setStarch(Starch starch) {
			this.starch = starch;
		}

		public Relish getRelish() {
			return relish;
		}

		public void setRelish(Relish relish) {
			this.relish = relish;
		}

		public Salad getSalad() {
			return salad;
		}

		public void setSalad(Salad salad) {
			this.salad = salad;
		}

	    
	    
		
	    
}
