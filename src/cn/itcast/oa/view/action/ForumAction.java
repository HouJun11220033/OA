package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
	public String list() {
		return "list";
	}

	public String show() {
		return "show";
	}

}
