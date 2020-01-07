package org.cap.service;

import org.cap.entities.Employee;

public interface IUserService 
{
	boolean credentialsCorrect(String name, String password);

	Employee getUserByName(String name);
	
}
