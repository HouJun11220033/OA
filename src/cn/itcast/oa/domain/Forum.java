package cn.itcast.oa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 版块
 * 
 * @author tyg
 * 
 */
public class Forum implements Serializable {
	private Long id;
	private String name;
	private String description;
	private int position; // 排序用的位置号

	private Set<Topic> topics = new HashSet<Topic>();// 一个版块多个主题
	private int topicCount;// 主题数量
	private int articCount;// 文章数量（）
	private Topic lastTopic;// 最后发表的时间

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public int getArticCount() {
		return articCount;
	}

	public Topic getLastTopic() {
		return lastTopic;
	}

	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}

	public void setArticCount(int articCount) {
		this.articCount = articCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
