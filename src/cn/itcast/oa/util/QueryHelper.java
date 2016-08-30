package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.PageBean;

import com.opensymphony.xwork2.ActionContext;

public class QueryHelper {

	private String fromClause;
	private String whereClause;
	private String orderByClause;

	private List<Object> parameters = new ArrayList<Object>();

	// from子句
	public QueryHelper(Class clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}

	// 拼接where子句
	public QueryHelper addCondition(String condition, Object... params) {
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;

		} else {
			whereClause += " AND " + condition;

		}

		if (params != null) {
			for (Object p : params) {
				parameters.add(p);
			}
		}
		return this;
	}

	// 如果第一个参数为true，则拼接Where子句

	public QueryHelper addCondition(boolean append, String condition,
			Object... params) {
		if (append) {
			addCondition(condition, params);

		}
		return this;

	}

	// 拼接OrderBy子句

	public QueryHelper addOrderProperty(String propertyName, boolean asc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName
					+ (asc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (asc ? " ASC" : " DESC");
		}
		return this;

	}

	// 如果第一个参数为true，则拼接OrderBy子句

	public QueryHelper addOrderProperty(boolean append, String propertyName,
			boolean asc) {

		if (append) {
			addOrderProperty(propertyName, asc);
		}

		return this;
	}

	/**
	 * 获取生成的用于 “查询数据列表” 的HQL语句
	 * 
	 * @return
	 */
	public String getListQueryHql() {
		return fromClause + whereClause + orderByClause;
	}

	/**
	 * 获取生成的用于 “ 查询总记录数 ” 的HQL语句
	 * 
	 * @return
	 */
	public String getCountQueryHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}

	/**
	 * 获取HQL中的 “ 参数值 ” 列表
	 * 
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	public void preparePageBean(DaoSupport<?> service, int pageNum, int pageSize) {
		PageBean pageBean = service.getPageBean(pageNum, pageSize, this);
		ActionContext.getContext().getValueStack().push(pageBean);

	}
}
