package com.ui.pojo;

public class User {
	
	private String emailAddress;
	
	private String password;
	
	
	public User(String emailAddress, String password)
	{
		this.emailAddress=emailAddress;
		
		this.password=password;
	}
	
	
	public void setEmailAdress(String emailAddress)
	{
        this.emailAddress=emailAddress;
		
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setPassword(String password)
	{
        this.password=password;
		
	}
	
	public String getPassword()
	{
		return password;
	}


	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	

}
