package com.java.demo01;

import java.util.Date;

/**
 * 代码模型01 : 简单Java类 <br/>
 * 1.类名应该有意义，Dog、Cat.... 
 * 2.类中的属性必须用private封装，所以需要有 getter 、 setter方法
 * 3.类中可以定义若干个构造方法，但是必须要有一个无参构造 
 * 4.类中不能出现 System.out.println()语句，所有的输出必须在调用处执行
 * 5.类中应该有返回类完整信息的方法： toString()
 * 
 * @author jack w
 *
 */
public class Employee {

	private Integer empId;
	private String empName;
	private Date empDate;

	public Employee() {
		
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getEmpDate() {
		return empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empDate == null) ? 0 : empDate.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empDate == null) {
			if (other.empDate != null)
				return false;
		} else if (!empDate.equals(other.empDate))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDate=" + empDate + "]";
	}
	

}
