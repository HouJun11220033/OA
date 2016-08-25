package cn.itcast.oa.util;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

public class InitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	// 因为每次都要用，为避免每次查询，所以放在一个监听器里面，每次程序初始化的时候加载数据
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext ac = WebApplicationContextUtils//
				.getWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService) ac
				.getBean("privilegeServiceImpl");

		// 准备数据->顶级权限(注意：加载顶级权限的时候，同时也要加载set集合（自权限），注意懒加载异常（坐电梯牵狗）)
		// 解决方案:关掉懒加载，懒加载在这里发挥不出来优势,因为加载顶级权限的时候都要用
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		sce.getServletContext().setAttribute("topPrivilegeList",
				topPrivilegeList);
		System.out.println("------------> 已准备数据 <------------");

	}

}
