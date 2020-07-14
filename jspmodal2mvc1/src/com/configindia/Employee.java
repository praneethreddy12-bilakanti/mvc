package com.configindia;
import java.io.Serializable;
public class Employee implements Serializable {
	 private int empId;
	    private String firstName;
	    private String lastName;
	    private int salary;
	    
		public Employee()
		{
			System.out.println("dc of Employee");
			    empId=0;
		        firstName = "";
		        lastName = "";
		        salary = 0;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
	    
}
