package zw.co.psmi.canteen.admin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.auth.entity.User;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_department")
public class Department extends BaseEntity{
	
    private String departmentName;
    private String subDepartment;
    private String location;
  
    @Override
    public String toString() {
        return "department{" + "id=" + id + ", departmentName=" + departmentName + ", subDepartment=" + subDepartment + ", location=" + location + "}";
    }

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
