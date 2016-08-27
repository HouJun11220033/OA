package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;

public interface ForumService extends DaoSupport<Forum> {

	// 上移动
	public void moveUp(Long id);

	// 下移动
	public void moveDown(Long id);

}
