package com.java.demo03;

/**
 * 数据表与简单java类 ： 一对多
 * 还有多对多，类似的，就没有写了
 * 
 * 
 * @author jack w
 *
 */

class Employee {
	private Integer empId;
	private String name;
	private Double salary;

	private Department department;
	private Employee manager;

	public Employee() {

	}

	public Employee(Integer empId, String name, Double salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Employee getManager() {
		return manager;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", manager=" + manager + "]";
	}
	

}

class Department {
	private Integer deptId;
	private String deptName;

	private Employee[] employees;

	public Department() {

	}

	public Department(Integer deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	public Employee[] getEmployees() {
		return employees;
	}
}

public class OneToMany {
	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1001, "jack", 1000.00);
		Employee emp2 = new Employee(1002, "smith", 2000.00);
		Employee emp3 = new Employee(1003, "tom", 4000.00);
		Department dept1 = new Department(1, "技术部");
		Department dept2 = new Department(2, "产品部");
		
		emp1.setDepartment(dept1);
		emp1.setManager(emp3);
		emp2.setDepartment(dept2);
		emp2.setManager(emp3);
		emp3.setDepartment(dept2);
		
		dept1.setEmployees(new Employee[]{emp1});
		dept2.setEmployees(new Employee[]{emp2,emp3});
		
		for (int i = 0; i < dept1.getEmployees().length; i++) {
			System.out.println(dept1.getEmployees()[i].toString());
		}
	}
}
