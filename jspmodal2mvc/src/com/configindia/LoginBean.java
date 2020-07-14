package com.configindia;
public class LoginBean {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validate()
	{
		if(name.equals("ksreddy")&&(password.equals("java")))
		{
			return true;
		}
		else{
			return false;
		}
	}

}
