// NOT ATTACKING CODE 

package com.criminal_record_management.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.criminal_record_management.entities.Users;
import java.sql.ResultSet;
import java.sql.ResultSet;


public class userDao {
	private Connection con;
	boolean flag=false;

	public userDao(Connection con) {
		super();
		this.con = con;
	}
	
	//create method to insert data into database
	public void saveUser(Users user){
		try {
			String query ="insert into users(username,useremail,password,gender,dob) values(?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, user.getUserName());
			psmt.setString(2, user.getUserEmail());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getGender());
			psmt.setString(5, user.getDob());
			
			psmt.executeUpdate();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to featch user from email and password
	
	public Users getUserByEmailPass(String email,String password){
	    Users u = null;
	    try {
	        String query2 = "select * from users where useremail=? and password=?";
	        PreparedStatement psmt1 = con.prepareStatement(query2);
	        psmt1.setString(1, email);
	        psmt1.setString(2, password); // Set the password parameter to index 2
	        
	        ResultSet rs = psmt1.executeQuery();
	        //if all ok then we got user with specified email,password
	        if(rs.next()) {
	            u = new Users();
	            
	            u.setUserName(rs.getString("username"));
	            u.setUserEmail(rs.getString("useremail"));
	            u.setGender(rs.getString("gender"));
	            u.setDob(rs.getString("dob"));
	            
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return u;
	}
}









// ATTACKING CODE 



//package com.criminal_record_management.dao;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import com.criminal_record_management.entities.Users;
//
//public class userDao {
//    private Connection con;
//    boolean flag = false;
//
//    public userDao(Connection con) {
//        super();
//        this.con = con;
//    }
//    
//    // Create method to insert data into the database
//    public void saveUser(Users user) {
//        try {
//            String query = "INSERT INTO users(username, useremail, password, gender, dob) VALUES('" 
//                + user.getUserName() + "','" 
//                + user.getUserEmail() + "','" 
//                + user.getPassword() + "','" 
//                + user.getGender() + "','" 
//                + user.getDob() + "')";
//            
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(query);
//            flag = true;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    // Method to fetch user from email and password
//    public Users getUserByEmailPass(String email, String password) {
//        Users u = null;
//        try {
//            String query2 = "SELECT * FROM users WHERE useremail='" 
//                + email + "' AND password='" 
//                + password + "'";
//            
//            Statement stmt1 = con.createStatement();
//            ResultSet rs = stmt1.executeQuery(query2);
//            
//            // If all ok then we got user with specified email and password
//            if (rs.next()) {
//                u = new Users();
//                u.setUserName(rs.getString("username"));
//                u.setUserEmail(rs.getString("useremail"));
//                u.setGender(rs.getString("gender"));
//                u.setDob(rs.getString("dob"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return u;
//    }
//}


