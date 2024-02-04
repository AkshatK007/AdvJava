package bca.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addEmployee(Connection con, Scanner sc) throws SQLException {
		//create statement
		Statement st = con.createStatement();
		
		//read employee details
		System.out.println("Enter Employee Id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter Employee Name: ");
		String name = sc.next();
		
		System.out.println("Enter Employee Job: ");
		String job = sc.next();
		
		System.out.println("Enter Employee Salary: ");
		int salary = sc.nextInt();
		
		
		//create sql squery string
		String query = String.format("Insert Into employee values(%d, '%s', '%s', %d) ", id, name, job, salary);
		
		//execute sql query
		int rows = st.executeUpdate(query);
		
		System.out.println(rows + " record inserted!!!");
		
	}
	
	public void displayEmployee(Connection con) throws SQLException {
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from employee");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+ "\t"+ rs.getString(3)+"\t"+rs.getInt(4));
		}
	}
	
	public void updateEmployeeName(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Employee New Name: ");
		String name = sc.next();
		
		String query = String.format("update employee set empname='%s' where empid = %d", name, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected+" recored updated!!!");
	
	}
	
	public void deleteEmployee(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();
		
		int rowAffected = st.executeUpdate("delete from employee where empid = "+id);
		System.out.println(rowAffected + " record deleted!!!");
	}
}
