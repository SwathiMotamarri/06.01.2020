package org.cap.service;
import org.cap.dao.IUserDao;
import org.cap.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.cap.exceptions.IncorrectAccountException;

@Service
public class UserServiceImpl implements IUserService
{
private IUserDao userdao;
public IUserDao getUserDao()
{
	return userdao;
}
@Autowired
public void getUserDao(IUserDao dao)
{
	this.userdao=dao;
}

@Override
public boolean credentialsCorrect(String name, String password) 
{
    boolean correct = userdao.credentialsCorrect(name, password);
    return correct;
}

@Override
public Employee getUserByName(String name) 
{      
    if (name==null) {
        throw new IncorrectAccountException("Account is incorrect");
    }
    Employee user = userdao.getUserByname(name);
    return user;
}

}
