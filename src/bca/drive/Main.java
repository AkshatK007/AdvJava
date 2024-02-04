package bca.drive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import bca.model.Employee;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//1. load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2
		String url = "jdbc:mysql://localhost:3306/n1";
		String username = "root";
		String pwd = "ak1234";
		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		Employee s = new Employee();
		//insert 
		//s.addEmployee(con, sc);
		while(true) {
			menu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1: s.addEmployee(con, sc);
				break;
				
			case 2: s.displayEmployee(con);
				break;
				
			case 3: s.updateEmployeeName(con, sc);
				break;
				
			case 4: s.deleteEmployee(con, sc);
				break;
				
			case 5:
				System.out.println("Bye Bye ...");
				System.exit(0);
			default:
				System.out.println("Wrong Choice...");
			}
		}
		
	}
	
	public static void menu() {
		System.out.println("**-----**--Menu--**-----**");
		System.out.println("1. Add New Employee");
		System.out.println("2. Display All Employees");
		System.out.println("3. Update Name of Employee");
		System.out.println("4. Delete an Employee");
		System.out.println("5. Exit");
		System.out.println("Your Choice...");
	}

}
