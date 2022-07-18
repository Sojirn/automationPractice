package com.demo.data;

import java.util.HashMap;
import com.demo.utility.Utility;

public class RandomData {
	
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

}
