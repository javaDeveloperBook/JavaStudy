package com.java.demo15.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Emp implements Serializable {
	private String ename;
	private String job;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [ename=" + ename + ", job=" + job + "]";
	}

}
