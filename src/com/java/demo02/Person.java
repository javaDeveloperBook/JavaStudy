package com.java.demo02;

/**
 * 代码模型02 : 对象比较
 * 
 * @author jack w
 *
 */
public class Person {

	private String name;
	private Integer age;

	public Person() {

	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 判断两个对象是否相等 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else {
			if (!this.name.equals(other.name)) {
				return false;
			}
		}
		if (this.age == null) {
			if (other.age != null) {
				return false;
			}
		} else {
			if (!this.age.equals(other.age)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
