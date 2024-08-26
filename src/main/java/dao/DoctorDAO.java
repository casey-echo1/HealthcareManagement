package dao;

import model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
	private Connection connection;

	public DoctorDAO(Connection connection) {
		this.connection = connection;
	}

	void createDoctor(Doctor doctor){
		String sql = "INSERT INTO Doctors (id, firstName, lastName, specialty, email) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, doctor.getDoctorID());
			stmt.setString(2, doctor.getFirstName());
			stmt.setString(3, doctor.getLastName());
			stmt.setString(4, doctor.getSpecialty());
			stmt.setString(5, doctor.getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	public Doctor getDoctorById(int DoctorID){
		String sql = "SELECT * FROM Doctors WHERE doctorID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, DoctorID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Doctor(
					rs.getInt(DoctorID),
					rs.getString("FirstName"),
					rs.getString("LastName"),
					rs.getString("Specialty"),
					rs.getString("Email")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateDoctor(Doctor doctor) {
		String sql = "UPDATE Doctors SET firstName = ?, lastName = ?" +
			" specialty = ?, email = ?, WHERE doctorID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, doctor.getFirstName());
			stmt.setString(2, doctor.getLastName());
			stmt.setString(3, doctor.getSpecialty());
			stmt.setString(4, doctor.getEmail());
			stmt.setInt(5, doctor.getDoctorID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteDoctor(int DoctorID) {
		String sql = "DELETE FROM Doctors WHERE doctorID = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, DoctorID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		String sql = "SELECT * FROM Doctors";
		try (Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				doctors.add(new Doctor(
					rs.getInt("DoctorID"),
					rs.getString("FirstName"),
					rs.getString("LastName"),
					rs.getString("Specialty"),
					rs.getString("Email")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}

}
