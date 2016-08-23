package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
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
	@Resource
	private SessionFactory sessionFactory;

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public Department getById(Long id) {
		if (id != null) {
			return departmentDao.getById(id);

		} else {
			return null;
		}

	}

	public void save(Department model) {
		departmentDao.save(model);
	}

	public void update(Department department) {
		departmentDao.update(department);
	}

	public List<Department> findTopList() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

	@Override
	public List<Department> finChildList(Long parentId) {
		return sessionFactory.getCurrentSession()//
				.createQuery("FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();//

	}

}
