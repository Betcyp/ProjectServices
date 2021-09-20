package com.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.constants.StudentQueries;
import com.databases.DatabaseConnection;

/**
 * Servlet implementation class FirstService
 */
@WebServlet("/FirstService")
public class FirstService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START="<html><body>";
	public static final String HTML_END="</body></html>";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstService() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println(HTML_START + "<h2>Hello, How are you?</h2><br/><h3>Date="+date +"</h3>"+HTML_END);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		StringBuilder sb=new StringBuilder();
		BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } 
	    finally {
	        reader.close();
	    }
	    System.out.println(sb.toString());
	    JSONObject jsonObject=new JSONObject(sb.toString());
	    DatabaseConnection id=new DatabaseConnection();
		//String file1=args[0];
		id.getConnection();
		id.insertInToDb(jsonObject);
	    
	 
		/*	Connection connection=DatabaseConnection.getConnection();
			String studName=(String)jsonObject.get("name");
			int studMark1=(int)jsonObject.get("maths");
			int studMark2=(int)jsonObject.get("physics");
			int studMark3=(int)jsonObject.get("chemistry");
			
			PreparedStatement inserted=connection.prepareStatement(StudentQueries.INSERT_QUERY);

				inserted.setString(1,studName);
				inserted.setInt(2,studMark1);
				inserted.setInt(3,studMark2);
				inserted.setInt(4,studMark3);
				inserted.executeUpdate();
				//out.println("inserted");
				connection.close();*/
				/*PrintWriter out = response.getWriter();
			    response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        String outputString="{\"status\":\"success\"}";
		        out.print(outputString);*/
	
		
	}
	
}
