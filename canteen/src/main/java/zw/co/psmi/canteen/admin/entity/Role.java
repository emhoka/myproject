package zw.co.psmi.canteen.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.basic.BaseEntity;


@Entity
@Data
@Table(name="_role")
public class Role extends BaseEntity{
	private String roleName;
	
	@Override
    public String toString() {
        return "role{" + "id=" + id + ", roleName=" + roleName + "}";
    }

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	
	
}
