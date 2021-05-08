package com.cognizant.patientintakesystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;

//@SpringBootTest
class PatientIntakeTests {

	@Test
	void addAppointment() throws ParseException {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("ajay", "03/12/2021", "ANIL");

		// verifying added appointment
		List<PatientAppointment> appointments = calendar.getAppointmentsList();
		assertEquals(1, appointments.size());
		
		//verifying name
		assertEquals("ANIL",appointments.get(0).getDoctor().name());
		assertEquals("ajay",appointments.get(0).getPatientName());

		// verifying date
		PatientAppointment appointment = appointments.get(0);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String datetime = df.format(appointment.getAppointmentDateTime());
		assertEquals("03/12/2021", datetime);
		
		//running main
		String args[]= {};
		PatientIntakeApp.main(args);
		PatientIntakeApp patientIntakeApp=new PatientIntakeApp();
	}

	@Test
	void invalidDateAppointment() throws ParseException {
		ClinicCalendar calendar = new ClinicCalendar();
		assertThrows(ParseException.class, () -> calendar.addAppointment("a", "03-09-2020", "BISHAL"));
	}

}
