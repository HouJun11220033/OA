//package cn.itcast.oa.view.action;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//
//import cn.itcast.oa.domain.Department;
//import cn.itcast.oa.service.DepartmentService;
//
//import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;
//
//@Controller
//@Scope("prototype")
//public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
//
//	@Resource
//	private DepartmentService departmentService;
//
//	private Department model = new Department();
//
//	public Department getModel() {
//		return model;
//	}
//
//	/** 列表 */
//	public String list() throws Exception {
//		List<Department> departmentList = departmentService.findAll();
//		ActionContext.getContext().put("departmentList", departmentList);
//		return "list";
//	}
//
//	/** 删除 */
//	public String delete() throws Exception {
//		departmentService.delete(model.getId());
//		return "toList";
//	}
//
//	/** 添加页面 */
//	public String addUI() throws Exception {
//		return "saveUI";
//	}
//
//	/** 添加 */
//	public String add() throws Exception {
//		// Department department = new Department();
//		// department.setName(name);
//		// department.setDescription(description)
//
//		// 保存
//		departmentService.save(model);
//
//		return "toList";
//	}
//
//	/** 修改页面 */
//	public String editUI() throws Exception {
//		// 准备回显的数据
//		Department department = departmentService.getById(model.getId());
//		ActionContext.getContext().getValueStack().push(department);
//		return "saveUI";
//	}
//
//	/** 修改 */
//	public String edit() throws Exception {
//		// 1，从数据库取出原对象
//		Department department = departmentService.getById(model.getId());
//
//		// 2，设置要修改的属性
//		department.setName(model.getName());
//		department.setDescription(model.getDescription());
//
//		// 3，更新到数据库中
//		departmentService.update(department);
//
//		return "toList";
//	}
// }
