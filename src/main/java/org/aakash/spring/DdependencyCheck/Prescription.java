package org.aakash.spring.DdependencyCheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class Prescription {

	
	private int id;
	private String patientName;
	private List<String> medicine;

	public int getId() {
		return id;
	}
	@Required
	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public List<String> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<String> medicine) {
		this.medicine = medicine;
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", patientName=" + patientName + ", medicine=" + medicine + ", getId()="
				+ getId() + ", getPatientName()=" + getPatientName() + ", getMedicine()=" + getMedicine()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
