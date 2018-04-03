package com.java.demo01;

import java.util.Date;

public class Demo {
	
	public static void main(String[] args) {
		Employee employee = new Employee() ;
		employee.setEmpId(10000);
		employee.setEmpName("jack w");
		employee.setEmpDate(new Date());
		
		System.out.println(employee);
	}
	
}
