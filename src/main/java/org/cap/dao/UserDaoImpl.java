package org.cap.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.cap.entities.Employee;
import org.cap.exceptions.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements IUserDao
		{

	  private Map<String,Employee> store = new HashMap<>();
	
	  public UserDaoImpl() {
	        Employee user1 = new Employee(1,"Swathi","abcd123");
	        store.put("Swathi", user1);
	        Employee user2 = new Employee(2,"Sekhar", "abcd123");
	        store.put("Sekhar", user2);
	    }

	    @Override
	    public boolean credentialsCorrect(String name, String password) 
	    {
	        Employee user = store.get(name);
	        if (user == null) {
	            return false;
	        }
	        return user.getPassword().equals(password);
	    }

	   	    @Override
	    public Employee getUserByname(String name) 
	    {
	        Employee user = store.get(name);
	        if (user == null) {
	            throw new AccountNotFoundException("Employee not found for name=" +name);
	        }
	        return user;
	    }
}
