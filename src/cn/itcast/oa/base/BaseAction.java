package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.RoleService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// =============== ModelDriven的支持 ==================

	protected T model;

	@Override
	public T getModel() {

		return model;
	}

	public BaseAction() {
		try {
			ParameterizedType pType = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pType.getActualTypeArguments()[0];
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// =============== Service实例的声明 ==================

	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;

}