package dao;

import model.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoctorDAOTest {
	private static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/HealthcareManagementDB";
		String user = "root";
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) throws SQLException {
		try (Connection connection = getConnection()) {
			DoctorDAO doctorDAO = new DoctorDAO(connection);

			Doctor newDoctor = new Doctor(1, "John", "Doe", "Cardiology", "john.doe@gmail.com");
			doctorDAO.createDoctor(newDoctor);
			System.out.println("Doctor created: " + newDoctor);
		}
	}
}
