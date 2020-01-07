package org.cap.dao;
import org.cap.entities.Employee;

public interface IUserDao 
{
	boolean credentialsCorrect(String name, String password);
	Employee getUserByname(String name);
}




   
