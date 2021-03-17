package com.springjdbc._Spring_JDBC.Dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springjdbc._Spring_JDBC.model.Employee;
import com.springjdbc._Spring_JDBC.repository.EmployeeRepo;

@Repository
public class EmployeeDao implements EmployeeRepo {

	@Autowired
	private JdbcTemplate jdbctemp;
	
	@Override
	public List<Employee> getEmployeeList() {
		String sql = "select * from emp";
		List<Employee> list = jdbctemp.query(sql, new BeanPropertyRowMapper(Employee.class));
		return list;
	}

	@Override
	public String insertData(Employee empObj) {
		String sql = "insert into emp values(?,?,?)";
		jdbctemp.update(sql, new Object[] {empObj.getId(),empObj.getName(),empObj.getSalary()}, new int[] {Types.INTEGER,Types.VARCHAR,Types.INTEGER});
		return "data inserted";
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from emp where id = ?";
		return (Employee) jdbctemp.queryForObject(sql, new Object[] {id}, new int[] {Types.INTEGER}, new BeanPropertyRowMapper(Employee.class));
	}

	@Override
	public void deleteData(int id) {
		String sql = "delete from emp where id = ?";
		jdbctemp.update(sql,new Object[] {id}, new int[] {Types.INTEGER});
	}

	/*
	 * @Override public String updateData(Employee empObj) { String sql =
	 * "update emp set name = ?,salary = ? where id= ?"; jdbctemp.update(sql, new
	 * Object[] {empObj.getName(),empObj.getSalary(),empObj.getId()}); return
	 * "Employee updated";
	 * 
	 * }
	 */
	
	@Override
	public String updateData(int id,String name) {
		String sql = "update emp set name = ? where id= ?";
		jdbctemp.update(sql, new Object[] {name,id});
		return "Employee updated";
		
	}

	@Override
	public List<Map<String, Object>> getCombineData() {
		String sql = "select a.id,a.name,a.salary,b.name as dept_name from emp a, department b where a.dept_id = b.id";
		List<Map<String,Object>> ls = jdbctemp.queryForList(sql);
		return ls;
	}



	
	

	

}
