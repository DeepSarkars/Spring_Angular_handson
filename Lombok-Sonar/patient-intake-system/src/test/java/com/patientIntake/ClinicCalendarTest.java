package com.patientIntake;

import static org.junit.Assert.assertEquals;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.example.ClinicCalendar;
import org.example.PatientAppointment;
import org.junit.Test;

public class ClinicCalendarTest {

	@Test
	public void addAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("Patient", "03-12-2021 11:11 AM", "a");
		
		//verifying added appointment
		List<PatientAppointment> appointments = calendar.getAppointmentsList();
		assertEquals(1, appointments.size());
		
		//verifying date
		PatientAppointment appointment = appointments.get(0);
		assertEquals("03-12-2021 11:11 AM", appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a")));
	}
	
	@Test(expected = RuntimeException.class)
	public void invalidDateAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("patient", "03/05/2021", "a");
	}
	
	
}
