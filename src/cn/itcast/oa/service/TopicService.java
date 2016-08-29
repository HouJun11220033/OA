package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Topic;

public interface TopicService extends DaoSupport<Topic> {

	/**
	 * 查询指定版块中的所有主题，排序：所有置顶帖在最上面，并按最后更新时间排序，让新状态的在上面。
	 * 
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

	PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum);

}
