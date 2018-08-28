package zw.co.psmi.canteen.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.admin.entity.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {
	public	Department findByDepartmentName(String departmentName);

}
