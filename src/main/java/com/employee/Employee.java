package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//WAP to retrieve the data records from the employee table using jdbc.
//create Emp database and employee table empid,empname,empmob,empaddress and write one update query.
public class Employee {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employeedb";
        String userName = "root";
        String password = "drisya";

        try (Connection connection = DriverManager.getConnection(url,userName,password)){
            try (Statement statement = connection.createStatement()){
                String createTableQuery = "create table employee_table(empId int primary key,emp_name varchar(20),emp_mobileNumber int,emp_address varchar(60))";
                statement.executeUpdate(createTableQuery);
                System.out.println("Table is Successfully Created");
            }
            try (Statement statement = connection.createStatement()){
                String insertTableQuery = "insert into employee_table (empId,emp_name,emp_mobileNumber,emp_address) values(1,'drisya',9999999,'kerala'),(2,'varsha',8888888,'bangalore')";
                statement.executeUpdate(insertTableQuery);
                System.out.println("Inserted Successfully ");
            }
            try (Statement statement = connection.createStatement()){
                String updateQuery = "update employee_table set emp_address = 'Malaysia' where empId = 1";
                statement.executeUpdate(updateQuery);
                System.out.println("Updated Successfully ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
