package zw.co.psmi.canteen.cook.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_relish")
public class Relish extends BaseEntity{
	
	 private String relishName;
	  /*@Transient  
	  private List<Menu> menus;*/
	  
	    @Override
	    public String toString() {
	        return "relish{" + "id=" + id + ", relishName=" + relishName +"}";
	    }

		public String getRelishName() {
			return relishName;
		}

		public void setRelishName(String relishName) {
			this.relishName = relishName;
		}

	

}
