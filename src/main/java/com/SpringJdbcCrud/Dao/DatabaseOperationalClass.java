package com.SpringJdbcCrud.Dao;

import com.SpringJdbcCrud.Entity.Employee;
import com.SpringJdbcCrud.Entity.User;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
@Component("dbOb")
public class DatabaseOperationalClass
        implements DatabaseOperations,RowMapper<Object>{

    @Autowired
    JdbcTemplate jdbcTemplate;
    public int switchh = 0; //0 = users, 1 = employee
   
    public int insert(Employee emp) {
        
        String query = "insert into employees(name,email,age,phone,city,status) values(?,?,?,?,?,?)";
        this.jdbcTemplate.update(query,emp.getName(),emp.getEmail(),emp.getAge(),emp.getPhone(),emp.getCity(),emp.getStatus());

return 0;
    }

    public int delete(int empId) {
       String query = "update employees set status = 0 where id = ?";
       this.jdbcTemplate.update(query,empId);
        
        return 0;
    }
    
    public int update(Employee employee) {
    	String query = "update employees set name = ? , email = ? , phone = ? , age = ? , city = ? where id = ? and status = 1 ";
    	
    	this.jdbcTemplate.update(query,employee.getName(),employee.getEmail() , employee.getPhone(),employee.getAge() , employee.getCity() , employee.getId() );
    	return 0 ; 
    }

    @Override
	public List<Object> getUserList() {
    	switchh = 0 ;
		String query = "select * from users where status = 1";
                 List<Object> userList;
		if(this.jdbcTemplate != null) {
			userList = this.jdbcTemplate.query(query, this);
			return userList;
		}
			
		else {
			return null;
		}
	}
 @Override
    public List<Object> getEmployeeList() {
	 switchh = 1 ;
        List<Object> employeeList;
        String query = "select * from employees where status = 1";
		if(this.jdbcTemplate != null) {
			employeeList = this.jdbcTemplate.query(query, this);
			return employeeList;
		}
			
		else {
			return null;
		}
    }
 
    public ArrayList<User> typeCastToUser(List<Object> objects){
    	
    	ArrayList<User>arrayList  = new ArrayList<User>();
    	for(Object o:objects) {
    		User user = (User)o;
    		arrayList.add(user);
    	}
    	return arrayList;
    }
    
     public ArrayList<Employee> typeCastToEmployee(List<Object> objects){
    	
    	ArrayList<Employee>arrayList  = new ArrayList<Employee>();
    	for(Object o:objects) {
    		Employee emp = (Employee)o;
    		arrayList.add(emp);
    	}
    	return arrayList;
    }
    
    ////////////////rowmapper overriden method/////////////////////////
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        
        if(switchh == 0){
            User user = new User();

            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            return user;
        }
        else if(switchh == 1)
        {
            Employee employee = new Employee();
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setAge(rs.getInt("age"));
            employee.setPhone(Long.parseLong(rs.getString("phone")));
            employee.setId(rs.getInt("id"));
            employee.setStatus(rs.getInt("status"));
            employee.setCity(rs.getString("city"));
        	return employee;
        }
        else return null;
        
        
        
       // return null;
    }

   

	
    
    
            

}
