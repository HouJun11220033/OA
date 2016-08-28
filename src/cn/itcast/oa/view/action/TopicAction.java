package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
	public String addUI() {
		return "addUI";
	}

	public String add() {
		return null;
	}

	public String show() {
		return "show";
	}

}
