package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.TopicService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements
		TopicService {
	@Override
	public void save(Topic topic) {

		// 1,设置属性并保存
		topic.setType(Topic.TYPE_NORMAL);
		topic.setReplyCount(0);
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getPostTime());
		getSession().save(topic);

		// 2,维护特殊属性
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount() + 1);
		forum.setLastTopic(topic);
		forum.setTopicCount(forum.getTopicCount() + 1);
		getSession().update(forum);

	}

	// 传入一个forum对象，得到一个topic集合
	// 因为forum对象里面包含topic集合，所以需要传入一个forum对象
	@Override
	public List<Topic> findByForum(Forum forum) {
		return getSession()
				.createQuery(
				// 需求:置顶帖一直在上面，且按最后一次更新时间降序排序
				// 精华帖和普通贴一律按普通贴处理,排在置顶帖下面，且按最后一次更新时间降序排序
						"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)//
				.list();

	}

	@Override
	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum) {

		// 查询本页的数据列表
		List list = getSession()
				.createQuery(//
						"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)//
				.setFirstResult((pageNum - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();

		// 查询总记录数量
		Long count = (Long) getSession()
				.createQuery("SELECT COUNT(*) FROM Topic t WHERE t.forum = ?")//
				.setParameter(0, forum)//
				.uniqueResult();
		return new PageBean(pageNum, pageSize, count.intValue(), list);

	}
}
