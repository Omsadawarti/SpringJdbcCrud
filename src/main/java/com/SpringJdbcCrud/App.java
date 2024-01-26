package com.SpringJdbcCrud;


import com.SpringJdbcCrud.Dao.DatabaseOperationalClass;
import com.SpringJdbcCrud.Dao.DatabaseOperations;
import com.SpringJdbcCrud.Entity.Employee;
import com.SpringJdbcCrud.Entity.User;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.jws.soap.SOAPBinding.Use;
import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;

import org.SpringJdbcCrud.view.LoginFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
       
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        DatabaseOperationalClass dbob = context.getBean("dbOb",DatabaseOperationalClass.class);
//        ArrayList<User> users = dbob.typeCastToUser(dbob.getUserList());
//        users.forEach(System.out::println);
//        
//        ArrayList<Employee> employees = dbob.typeCastToEmployee(dbob.getEmployeeList());
//        employees.forEach(System.out::println);
   
       LoginFrame frame = context.getBean("frame",LoginFrame.class);
       frame.setVisible(true);
     

        
    }
    
    
}
