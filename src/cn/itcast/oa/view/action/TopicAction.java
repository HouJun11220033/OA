package cn.itcast.oa.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
	private Long forumId;
	private int pageNum = 1;
	private int pageSize = 10;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String addUI() {
		// 隶属于哪一个版块
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}

	public String add() {

		// 表单参数已经封装了title,content
		model.setForum(forumService.getById(forumId));

		// author是user类型的
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		// 保存
		topicService.save(model);

		// 转到新主题的显示页面
		return "toShow";
	}

	public String show() {
		// 准备数据:forumId和 topicId
		// topic里面有forumId!!!!
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);

		// List<Reply> replyList = replyService.findByTopic(topic);
		// ActionContext.getContext().put("replyList", replyList);
		// 准备分页信息
		PageBean pageBean = replyService.getPageBeanByTopic(pageNum, pageSize,
				topic);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "show";
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

}
