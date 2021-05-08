package org.example;

public enum Doctor {
	
	a("DR A"),
	b("dr b"),
	x("dr x");

	private String doctorName;
	
	public String getDoctorName() {
		return doctorName;
	}
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

}
