package zw.co.psmi.canteen.cook.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;

	@Entity
	@Data
	@Table(name="_salad")
	public class Salad extends BaseEntity{
		
		 private String saladName;
		  /*@Transient  
		  private List<Menu> menus;*/
		  
		    @Override
		    public String toString() {
		        return "salad{" + "id=" + id + ", saladName=" + saladName +"}";
		    }

			public String getSaladName() {
				return saladName;
			}

			public void setSaladName(String saladName) {
				this.saladName = saladName;
			}
			

	}
	

