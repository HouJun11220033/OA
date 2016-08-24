package cn.itcast.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements
		UserService {

	// 已经不用Dao层了
	// 直接继承已经写好的Dao实现类
	// @Resource
	// private RoleDao roleDao;

	// public Role getById(Long id) {
	// return roleDao.getById(id);
	// }
	//
	// public void delete(Long id) {
	// roleDao.delete(id);
	// }
	//
	// public void save(Role role) {
	// roleDao.save(role);
	// }
	//
	// public void update(Role role) {
	// roleDao.update(role);
	// }
	//
	// public List<Role> findAll() {
	// return roleDao.findAll();
	// }

}
