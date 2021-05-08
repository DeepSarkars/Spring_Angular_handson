package org.example;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static ClinicCalendar calendar = new ClinicCalendar();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome!" + "\n" + "Select an option?");
		int choice = 0;
		do {
			System.out.println("\n1. Add a patient appointment" + "\n" + "2. View all appointments" + "\n" + "3. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addPatientAppointment();
				break;
			case 2:
				viewAllAppointments();
				break;
			}
		} while (choice != 3);

		System.out.println("Thank You!!!");
	}

	private static void addPatientAppointment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient name:");
		String patientName = sc.nextLine();
		System.out.println("Enter appointment date and time (dd-MM-yyyy hh:mm a):");
		String appointmentTime = sc.nextLine();
		System.out.println("Enter doctor value:");
		String doctorName = sc.nextLine();

		try {
			calendar.addAppointment(patientName, appointmentTime, doctorName);
			System.out.println("Patient added sucessfully");
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			return;
		}
	}

	private static void viewAllAppointments() {
		List<PatientAppointment> appointmentsList = calendar.getAppointmentsList();
		if (appointmentsList.isEmpty())
			System.out.println("No appointments");
		else {
			for (PatientAppointment appointments : appointmentsList) {
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
				String datetime = df.format(appointments.getAppointmentDateTime());

				System.out.println("Patient Name: " + appointments.getPatientName() + "\n" + "Appointment Date Time: "
						+ datetime + "\n" + "Doctor Name: " + appointments.getDoctor().getDoctorName() + "\n");
			}
		}
	}
}

//mvn sonar:sonar \
//-Dsonar.projectKey=Patient \
//-Dsonar.host.url=http://localhost:9000 \
//-Dsonar.login=e588c2cc093bba6b018ec50c6c81dd130f626e49
//mvn sonar:sonar -Dsonar.projectKey=Patient -Dsonar.host.url=http://localhost:9000 -Dsonar.login=e588c2cc093bba6b018ec50c6c81dd130f626e49
