package com.java.demo15.action;

import com.java.demo15.utils.BeanOperation;
import com.java.demo15.vo.Emp;

/**
 * 模拟Action
 * 
 * @author jack w
 *
 */
public class EmpAction {

	private Emp emp = new Emp();

	public void index(String info) {
		BeanOperation.setFeildValue(this, info);
		System.out.println(this.emp);
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
