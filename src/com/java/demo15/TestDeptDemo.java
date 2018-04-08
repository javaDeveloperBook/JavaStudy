package com.java.demo15;

import com.java.demo15.action.DeptAction;

public class TestDeptDemo {
	public static void main(String[] args) {
		String info = "dept.dname:事业部|dept.loc:重庆";
		DeptAction deptAction = new DeptAction();
		deptAction.index(info);
	}
}
