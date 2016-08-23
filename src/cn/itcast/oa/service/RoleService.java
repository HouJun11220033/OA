package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Role;

public interface RoleService {

	// 查询所有
	List<Role> findAll();

	void delete(Long id);

	void save(Role role);

	Role getById(Long id);

	void update(Role role);

}
