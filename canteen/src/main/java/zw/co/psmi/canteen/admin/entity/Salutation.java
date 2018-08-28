package zw.co.psmi.canteen.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_salutation")
public class Salutation   extends BaseEntity{
    private String name;
    
    @Override
    public String toString() {
    	return "salutation{"+ "id=" + id + ", name=" + name +"}";
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}