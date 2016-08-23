package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	public void save(Department model) {
		departmentDao.save(model);
	}

	public void update(Department department) {
		departmentDao.update(department);
	}

}
