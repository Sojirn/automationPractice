package com.demo.data;

import java.util.HashMap;
import com.demo.utility.Utility;

public class RandomData {
	String userDir=System.getProperty("user.dir") + "/src/main/resources/";
	
	public static HashMap<String, String> getAddressData(){
		HashMap<String, String> address = new HashMap<>();
		address.put("company", "QA Company "+Utility.getRandomInt());
		address.put("address1", "QA Address 1 "+Utility.getRandomInt());
		address.put("address2", "QA Address 2 "+Utility.getRandomInt());
		address.put("city","QA City "+Utility.getRandomInt());
		address.put("postalcode","00052");
		address.put("phone","8978787"+Utility.getRandomInt());
		address.put("mobile","8978787"+Utility.getRandomInt());
		address.put("additional", "testaddi"+Utility.getRandomInt());
		address.put("expected","test "+Utility.getRandomInt());
		address.put("updatefirstname", "Sojitest");
		address.put("additionalupdate", "Update"+Utility.getRandomInt());
		return address;
	}
	public static HashMap<String, String> getContactData(){
		HashMap<String, String> contact = new HashMap<>();
		contact.put("phone","8977"+Utility.getRandomInt());
		contact.put("msg", "testaddi"+Utility.getRandomInt());
		contact.put("ordertest","abcde");
		contact.put("expected","test "+Utility.getRandomInt());
		contact.put("updatefirstname", "Sojitest");
		contact.put("additionalupdate", "Update"+Utility.getRandomInt());
		return contact;
	}
	public static HashMap<String, String> getAccountData(){
		HashMap<String, String> account = new HashMap<>();
		account.put("firstname", "First Name ");
		account.put("secondname", "Second Name ");
		account.put("accntPassword", "Uc@"+Utility.getRandomInt());
		account.put("address1", "Address 1"+Utility.getRandomInt());
		account.put("address2", "Address 2 "+Utility.getRandomInt());
		account.put("city","QA City "+Utility.getRandomInt());
		account.put("postalcode","00052");
		account.put("phone","8978787"+Utility.getRandomInt());
		account.put("mobile","8978787"+Utility.getRandomInt());
		account.put("additional", "testaddi"+Utility.getRandomInt());
		account.put("expected","test "+Utility.getRandomInt());
		return account;
	}
	
	public static String[] getInValidUserData() {
		String[] userData = new String[2];
	    String username = Utility.readExcelData(1,1).toString();
		String password = Utility.readExcelData(1,2).toString();
		userData[0] = username;
		userData[1] = password;
		return userData;
	}
	
	public static String[] getValidUserData() {
		String[] userData = new String[2];
	    String username = Utility.readExcelData(0, 1).toString();
		String password = Utility.readExcelData(0,2).toString();
		userData[0] = username;
		userData[1] = password;
		return userData;
	}

}
