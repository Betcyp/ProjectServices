package com.databases;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONObject;

import com.constants.StudentQueries;

public class DatabaseConnection {
	
	
	public void insertInToDb(JSONObject jsonObject){
		try {
			Connection connection=getConnection();
			String studName=(String)jsonObject.get("name");
			int studMark1=(int)jsonObject.get("maths");
			int studMark2=(int)jsonObject.get("physics");
			int studMark3=(int)jsonObject.get("chemistry");
			
			PreparedStatement inserted=connection.prepareStatement(StudentQueries.INSERT_QUERY);
		
			inserted.setString(1,studName);
			inserted.setInt(2, studMark1);
			inserted.setInt(3, studMark2);
			inserted.setInt(4, studMark3);
			inserted.executeUpdate();
		//	System.out.println("inserted");
			connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

	public static void createTable() {
		try {
			Connection connection=getConnection();
			PreparedStatement create=connection.prepareStatement("CREATE TABLE IF NOT EXISTS REQUESTS(name varchar(225),maths int NOT NULL AUTO_INCREMENT,physics int NOT NULL,chemistry int NOT NULL,PRIMARY KEY(maths),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
			create.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static Connection getConnection(){
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("Config.properties"));
		
			String theUsername=prop.getProperty("username");
			String thePassword=prop.getProperty("password");
			String theDburl=prop.getProperty("url");
			
			Connection connection=DriverManager.getConnection(theDburl, theUsername, thePassword);
			System.out.println("connected");
			return connection;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
