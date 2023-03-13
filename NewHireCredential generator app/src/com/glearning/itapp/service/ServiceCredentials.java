package com.glearning.itapp.service;

import com.glearning.itapp.model.Employee;

public interface ServiceCredentials {
	
	public String generateEmailAddress(String firstName,String lastName,String departName,String company);
	public String generateCredentials(int maxLength);
	public void displayCredentials(Employee employee);

}