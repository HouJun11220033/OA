package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Forum> {

	// 这个回复指的是这个动作
	public String addUI() {
		return "addUI";
	}

	public String add() {
		return null;
	}

}
