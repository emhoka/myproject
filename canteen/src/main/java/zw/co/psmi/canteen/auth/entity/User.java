package zw.co.psmi.canteen.auth.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.entity.Role;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_users")
public class User extends BaseEntity{
    private String name;
    private String surname;
    private String username;
    
    @ManyToOne
    private Role role;
    @ManyToOne
    private Department department;
    @javax.persistence.Lob
    private String password;
    

    @Override
    public String toString() {
        return "users{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + "}";
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

    
    
}
