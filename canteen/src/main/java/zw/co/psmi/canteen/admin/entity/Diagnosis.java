package zw.co.psmi.canteen.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Table(name = "_diagnosis")
@Data
public class Diagnosis extends BaseEntity {
   private String code; 
   private String name; 
   
   @Override
   public String toString() {
       return "diagnosis{" + "id=" + id + ", name=" + name +", code =" + code +"}";
   }

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   
   
}