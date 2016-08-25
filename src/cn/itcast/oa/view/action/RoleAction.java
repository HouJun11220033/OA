package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	private Long[] privilegeIds;

	// @Resource
	// private RoleService roleService;

	// private Long id;
	// private String name;
	// private String description;
	// private Role model = new Role();
	//
	// public Role getModel() {
	//
	// return model;
	// }

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	/** 列表 */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	public String saveUI() throws Exception {

		return "saveUI";
	}

	public String editUI_new() throws Exception {

		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI_new";

	}

	/** 添加 */
	public String add() throws Exception {
		// // 封装到对象中
		// Role role = new Role();
		// role.setName(model.getName());
		// role.setDescription(model.getDescription());
		//
		// // 保存到数据库
		// roleService.save(role);

		roleService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Role role = roleService.getById(model.getId());

		// 2，设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		// 3，更新到数据库
		roleService.update(role);

		return "toList";
	}

	/* 设置权限页面 */
	public String setPrivilegeUI() throws Exception {
		// 准备回显数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		// 拿到privilegeIds!!!,用于修改
		if (role.getPrivileges() != null) {
			// 这是一个数组!!!
			privilegeIds = new Long[role.getPrivileges().size()];
			int index = 0;
			for (Privilege privilege : role.getPrivileges()) {
				privilegeIds[index++] = privilege.getId();
			}

		}

		// 准备数据 privilegeList
		List<Privilege> privilegeList = privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);

		return "setPrivilegeUI";

	}

	// 设置权限动作
	public String setPrivilege() throws Exception {

		Role role = roleService.getById(model.getId());
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));

		roleService.update(role);

		return "toList";

	}

}
