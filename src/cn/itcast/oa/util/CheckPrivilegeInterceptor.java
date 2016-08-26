package cn.itcast.oa.util;

import cn.itcast.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("--------------->Before!!!");
		// String result = invocation.invoke();

		User user = (User) ActionContext.getContext().getSession().get("user");
		String nameSpace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = nameSpace + actionName;

		// 如果未登录
		if (user == null) {
			// 如果是去登录，就放行
			if (privUrl.startsWith("/user_login")) {
				return invocation.invoke();
			} else {
				// 如果不是去登录，就转到登录页面
				return "loginUI";
			}
		} else {
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 如果有权限，就放行
				return invocation.invoke();
			} else {
				// 如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}

		}
		// 如果已登录，就判断权限

	}

}
