package com.tests;

import java.sql.Connection;
import java.sql.DriverManager;

import org.json.JSONObject;

public class JsonObj {
	
	double total;
	double per;
	@SuppressWarnings("unchecked")
	public JSONObject object() {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Name","Anu");
		jsonObject.put("Maths",88);
		jsonObject.put("Physics",85);
		jsonObject.put("Chemistry",87);
		
		System.out.println(jsonObject);
		return jsonObject;
	}
}
/*Properties prop=new Properties();
prop.load(new FileInputStream("Config.properties"));

String theUsername=prop.getProperty("username");
String thePassword=prop.getProperty("password");
String theDburl=prop.getProperty("url");

Connection connection=DriverManager.getConnection(theDburl, theUsername, thePassword);
System.out.println("connected");
return connection;*/