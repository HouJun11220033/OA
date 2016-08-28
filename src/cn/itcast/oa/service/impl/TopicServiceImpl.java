package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
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

	@Override
	public List<Topic> findByForum(Forum forum) {
		return null;

	}

}
