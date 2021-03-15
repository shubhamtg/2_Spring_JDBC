package com.springjdbc._Spring_JDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc._Spring_JDBC.Dao.EmployeeDao;
import com.springjdbc._Spring_JDBC.model.Employee;

@RestController
public class EmpController {

	@Autowired
	private EmployeeDao employeedao;

	@GetMapping("/getempl")
	public List<Employee> getEmployees() {
		return employeedao.getEmployeeList();
	}

	@PostMapping("/insertdata")
	public String insertData(@RequestBody Employee empRef) {
		return employeedao.insertData(empRef);
	}

	@GetMapping("/getOneRow/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeedao.getEmployeeById(id);
	}

	@DeleteMapping("/deleteRow/{id}")
	public void deleteData(@PathVariable int id) {
		employeedao.deleteData(id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}
	
	/*
	 * @PutMapping("/updateRow") public String updateData(@RequestBody Employee
	 * empObj) { return employeedao.updateData(empObj);
	 * //System.out.println("Updated Record with ID = " + id ); }
	 */
	
	@PutMapping("/updateRow")
	public String updateData(@RequestParam int id,@RequestParam String name, @RequestParam(required = false) int salary) {
		//return employeedao.updateData(id,name,salary);
		return employeedao.updateData(id,name);
		//System.out.println("Updated Record with ID = " + id );
	}

}
