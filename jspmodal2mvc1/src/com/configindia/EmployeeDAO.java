package com.configindia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	private Connection con;

	public EmployeeDAO() throws ClassNotFoundException, SQLException {
		establishConnection();
	}

	// method used to establish connection with database
	private void establishConnection() throws ClassNotFoundException, SQLException {
		System.out.println("in connection method");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String conUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(conUrl,"system","system");
	}

	// used to search the employee against first name and returns the ArrayList
	// that contains only those EmployeeInfo objects which matches the search
	// criteria
	public ArrayList retrieveEmployeesList(String fName) throws SQLException {
		ArrayList empList = new ArrayList();

		String sql = " SELECT * FROM employees WHERE first_name = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, fName);

		ResultSet rs = pStmt.executeQuery();

		int empId;
		String firstName;
		String lastName;
		int sal;

		while (rs.next()) {
			empId = rs.getInt("emp_id");
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");
			sal = rs.getInt("salary");

			// creating a Employee object
			Employee empBean = new Employee();
			empBean.setEmpId(empId);
			empBean.setFirstName(firstName);
			empBean.setLastName(lastName);
			empBean.setSalary(sal);
			// adding a bean to arraylist
			empList.add(empBean);
		}
		return empList;
	}

	// this method accepts an object of EmployeeInfo, and stores it into the
	// database
	public void addEmployee(Employee employee) throws SQLException {
		String sql = " INSERT INTO employees VALUES (?, ?, ?, ?)";
		PreparedStatement pStmt = con.prepareStatement(sql);

		int empId = employee.getEmpId();
		String fName = employee.getFirstName();
		String lName = employee.getLastName();
		int sal = employee.getSalary();

		pStmt.setInt(1, empId);
		pStmt.setString(2, fName);
		pStmt.setString(3, lName);
		pStmt.setInt(4, sal);

		pStmt.executeUpdate();
	}

	// overriding finalize method to release acquired resources
	public void finalize() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqlex) {
			System.out.println(sqlex);
		}
	}
}
