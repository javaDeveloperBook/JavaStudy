package com.java.demo15;

import com.java.demo15.action.EmpAction;

public class TestEmpDemo {
	public static void main(String[] args) {
		String info = "emp.ename:Jaywu|emp.job:Java";
		EmpAction empAction = new EmpAction();
		empAction.index(info);
	}
}
