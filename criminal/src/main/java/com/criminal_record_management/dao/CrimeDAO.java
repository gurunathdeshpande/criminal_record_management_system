package com.criminal_record_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.criminal_record_management.entities.Crime;

public class CrimeDAO {
    private Connection con;
    boolean flag = false;

    public CrimeDAO(Connection con) {
        super();
        this.con = con;
    }

    // Method to insert crime details into the database
    public boolean addCrime(Crime crime) {
        try {
            String query = "INSERT INTO crimes (date_of_crime, location, crime_type, description, people_involved, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, crime.getDate());
            psmt.setString(2, crime.getLocation());
            psmt.setString(3, crime.getType());
            psmt.setString(4, crime.getDescription());
            psmt.setString(5, crime.getPeopleInvolved());
            psmt.setString(6, crime.getStatus());

            psmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Method to delete crime record from the database
    public boolean deleteCrime(String crimeId) {
    	boolean flag = false;
        try {
            String query = "DELETE FROM crimes WHERE crimeid=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, crimeId);
            psmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    
    public Crime getCrimeById(int crimeId) {
    	Crime crm = null;
    	try {
    		String query="select * from crimes where crimeid=?"; 
    		PreparedStatement psmt = con.prepareStatement(query);
    		psmt.setInt(1, crimeId);
    		ResultSet rs = psmt.executeQuery();
    		if(rs.next()) {
    			crm = new Crime();
    			crm.setCrimeId(rs.getInt("crimeid"));
    			crm.setDate(rs.getString("date_of_crime"));
    			crm.setLocation(rs.getString("location"));
    			crm.setType(rs.getString("crime_type"));
    			crm.setDescription(rs.getString("description"));
    			crm.setPeopleInvolved(rs.getString("people_involved"));
    			crm.setStatus(rs.getString("status"));
    			
    			}
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	    return crm;

    	}
    
    public boolean updatecrime(Crime crm){
    	boolean flag=false;
    	try{
    		String upquery="update crimes set date_of_crime=?, location=?, crime_type=?, description=?," + "people_involved=?, status=? where crimeid=?";
    		PreparedStatement psmt = con.prepareStatement (upquery);
    		psmt.setString(1, crm.getDate());
            psmt.setString(2, crm.getLocation());
            psmt.setString(3, crm.getType());
            psmt.setString(4, crm.getDescription()); 
            psmt.setString(5, crm.getPeopleInvolved());
            psmt.setString(6, crm.getStatus()); 
            psmt.setInt(7, crm.getCrimeId());
            psmt.executeUpdate();
            flag=true;
            
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return flag;

    	}
}
