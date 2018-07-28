package com.aakash.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hospital {
	
	private String name;
	private List<String> Department;
	private Set<String> DrName;
	private Map<String, String> DocAddrs;
	public Map<String, String> getDocAddrs() {
		return DocAddrs;
	}
	public void setDocAddrs(Map<String, String> docAddrs) {
		DocAddrs = docAddrs;
	}
	public Set<String> getDrName() {
		return DrName;
	}
	public void setDrName(Set<String> drName) {
		DrName = drName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getDepartment() {
		return Department;
	}
	public void setDepartment(List<String> department) {
		Department = department;
	}
	@Override
	public String toString() {
		return "Hospital [name=" + name + ", Department=" + Department + ", DrName=" + DrName + ", DocAddrs=" + DocAddrs
				+ "]";
	}
	
	
	
	

}
