package zw.co.psmi.canteen.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_nationality")
public class Nationality extends BaseEntity{

	 private String name;
	 
	 @Override
	    public String toString() {
	        return "nationality{" + "id=" + id + ", name=" + name +"}";
	    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	 
}
