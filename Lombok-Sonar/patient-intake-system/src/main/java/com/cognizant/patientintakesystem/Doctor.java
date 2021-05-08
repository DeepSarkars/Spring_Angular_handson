package com.cognizant.patientintakesystem;

public enum Doctor {
	ANIL("Dr Anil"),
	BISHAL("Dr Bishal"),
	CHANDRA("Dr Chandra"),
	DEEP("Deepsubhra");
	
	private String doctorName;
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}
}
