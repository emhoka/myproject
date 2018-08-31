
package zw.co.psmi.canteen.admin.service;


import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.basic.BasicService;

public interface DepartmentService extends BasicService<Department>{
	public	Department findByDepartmentName(String departmentName);
	String delete(long id);

}
