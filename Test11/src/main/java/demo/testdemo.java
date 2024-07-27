package demo;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class testdemo {
	@DataProvider

	public String[] getData() {
		
		String[] user= {"Arjun","Sunitha","Ambika","Ravi","Chandra"};
		
		return user;
		// TODO Auto-generated method stub

	}
	@Test(dataProvider="getData")
	public void createUser(String un) {
		Reporter.log("Create User:"+un,true);
	}

}
