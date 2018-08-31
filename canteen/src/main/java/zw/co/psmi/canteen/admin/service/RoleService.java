package zw.co.psmi.canteen.admin.service;



import zw.co.psmi.canteen.admin.entity.Role;
import zw.co.psmi.canteen.basic.BasicService;

public interface RoleService extends BasicService<Role> {
	
public Role findByRoleName(String roleName);
String delete(long id);
}
