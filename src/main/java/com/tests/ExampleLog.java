package com.tests;
import org.apache.log4j.Logger;  

import java.io.*;  
import java.sql.SQLException; 
public class ExampleLog {
	static Logger log = Logger.getLogger(ExampleLog.class);  
    
	   public static void main(String[] args)throws IOException,SQLException{  
	      log.debug("Hello this is a debug message");  
	      log.info("Hello this is an info message");  
	   }  
}  

