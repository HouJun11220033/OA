package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

public interface ReplyService extends DaoSupport<Reply>{

	/**
	 * 查询指定主题中所有的回复列表，排序：按发表时间升序排列。
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);

}
