package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements
		PrivilegeService {

	@Override
	public List<Privilege> findTopList() {
		List<Privilege> privilegeList = getSession().createQuery(
				"FROM Privilege p WHERE p.parent IS NULL").list();
		return privilegeList;

	}
}
