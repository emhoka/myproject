package zw.co.psmi.canteen.cook.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_starch")
public class Starch extends BaseEntity{
	
	 private String starchName;
	  /*@Transient  
	  private List<Menu> menus;*/
	  
	    @Override
	    public String toString() {
	        return "starch{" + "id=" + id + ", starchName=" + starchName +"}";
	    }

		public String getStarchName() {
			return starchName;
		}

		public void setStarchName(String starchName) {
			this.starchName = starchName;
		}

		
	

}
