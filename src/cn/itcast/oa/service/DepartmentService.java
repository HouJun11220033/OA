package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	List<Department> findTopList();


	List<Department> finChildList(Long parentId);

}
