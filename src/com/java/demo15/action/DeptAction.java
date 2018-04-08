package com.java.demo15.action;

import com.java.demo15.utils.BeanOperation;
import com.java.demo15.vo.Dept;

public class DeptAction {

	Dept dept = new Dept();

	public void index(String info) {
		BeanOperation.setFeildValue(this, info);
		System.out.println(this.dept);
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
