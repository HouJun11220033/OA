package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.itcast.oa.domain.Department;

public class DepartmentUtils {

	public static List<Department> getAllDepartments(List<Department> topList) {
		// 把遍历的结果放到这个集合里面
		List<Department> list = new ArrayList<Department>();
		// 调用遍历方法
		walkDepartmentTreeList(topList, "┣", list);
		return list;

	}

	public static void walkDepartmentTreeList(Collection<Department> topList,
			String prefix, List<Department> list) {
		for (Department top : topList) {
			// 使用副本，因为原对象在Session中
			Department copy = new Department();
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy);
			walkDepartmentTreeList(top.getChildren(), "　" + prefix, list);
		}
	}

}
