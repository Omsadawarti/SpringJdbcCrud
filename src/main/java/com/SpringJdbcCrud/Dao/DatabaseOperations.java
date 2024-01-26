package com.SpringJdbcCrud.Dao;

import com.SpringJdbcCrud.Entity.Employee;
import com.SpringJdbcCrud.Entity.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public interface DatabaseOperations {
    
    
    
    public int insert(Employee emp);
    
    public int delete(int empId);
    
    public  List<Object> getUserList();
    
    public List<Object> getEmployeeList();
    
   
    
  

}
