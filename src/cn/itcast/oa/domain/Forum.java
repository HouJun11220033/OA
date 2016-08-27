package cn.itcast.oa.domain;

import java.io.Serializable;

/**
 * 版块
 * 
 * @author tyg
 * 
 */
public class Forum implements Serializable {
	private Long id;
	private String name;
	private String description;
	private int position; // 排序用的位置号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
