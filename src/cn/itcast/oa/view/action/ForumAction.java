package cn.itcast.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	// 显示版块列表
	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	// 点击单个版块，显示主题列表
	public String show() throws Exception {

		// 因为上面需要显示隶属于哪一个版块，所以这里需要准备版块数据

		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);

		// 根据版块准备数据：topicList
		List<Topic> topicList = topicService.findByForum(forum);
		ActionContext.getContext().put("topicList", topicList);

		return "show";
	}

}
