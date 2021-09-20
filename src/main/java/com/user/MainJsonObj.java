package com.user;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.databases.DatabaseConnection;

public class MainJsonObj {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException  {
		
		/*JsonObj obj=new JsonObj();
		@SuppressWarnings("unused")
		JSONObject jsonObject=obj.object();*/
		//String file1=args[0];
		DatabaseConnection id=new DatabaseConnection();
		String file1=args[0];
		id.getConnection(file1);
		//id.createTable(file1);
		
	}
}

