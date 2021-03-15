package com.springjdbc._Spring_JDBC.repository;

import java.util.List;

import com.springjdbc._Spring_JDBC.model.Employee;

public interface EmployeeRepo {
	
	 List<Employee> getEmployeeList();
     String insertData(Employee empObj);
     Employee getEmployeeById(int id);
     void deleteData(int id);
     //String updateData(Employee empObj);
     //String updateData(int id,String name,int salary);
     String updateData(int id,String name);
}
