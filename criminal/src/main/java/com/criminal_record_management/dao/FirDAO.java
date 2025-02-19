package com.criminal_record_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.criminal_record_management.entities.FIR;

public class FirDAO {
    private Connection con;
    boolean flag = false;

    public FirDAO(Connection con) {
        super();
        this.con = con;
    }

    // Method to insert FIR details into the database
    public boolean addFIR(FIR fir) {
        try {
            String query = "INSERT INTO fir (date_of_fir, complainant_name, police_name, incident_date, incident_time, location, incident_description, accused_details) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, fir.getDate());
            psmt.setString(2, fir.getComplainantName());
            psmt.setString(3, fir.getPoliceName());
            psmt.setString(4, fir.getIncidentDate());
            psmt.setString(5, fir.getIncidentTime());
            psmt.setString(6, fir.getLocation());
            psmt.setString(7, fir.getDescription());
            psmt.setString(8, fir.getAccusedDetails());

            psmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Method to delete FIR record from the database
    public boolean deleteFIR(String firId) {
        boolean flag = false;
        try {
            String query = "DELETE FROM fir WHERE firid=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, firId);
            psmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    
    // Method to get FIR by ID
    public FIR getFIRById(int firId) {
        FIR fir = null;
        try {
            String query = "SELECT * FROM fir WHERE firid=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, firId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                fir = new FIR();
                fir.setId(rs.getInt("firid"));
                fir.setDate(rs.getString("date_of_fir"));
                fir.setComplainantName(rs.getString("complainant_name"));
                fir.setPoliceName(rs.getString("police_name"));
                fir.setIncidentDate(rs.getString("incident_date"));
                fir.setIncidentTime(rs.getString("incident_time"));
                fir.setLocation(rs.getString("location"));
                fir.setDescription(rs.getString("incident_description"));
                fir.setAccusedDetails(rs.getString("accused_details"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fir;
    }
    
    // Method to update FIR record
    public boolean updateFIR(FIR fir) {
        boolean flag = false;
        try {
            String query = "UPDATE fir SET date_of_fir=?, complainant_name=?, police_name=?, incident_date=?, incident_time=?, location=?, incident_description=?, accused_details=? WHERE firid=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, fir.getDate());
            psmt.setString(2, fir.getComplainantName());
            psmt.setString(3, fir.getPoliceName());
            psmt.setString(4, fir.getIncidentDate());
            psmt.setString(5, fir.getIncidentTime());
            psmt.setString(6, fir.getLocation());
            psmt.setString(7, fir.getDescription());
            psmt.setString(8, fir.getAccusedDetails());
            psmt.setInt(9, fir.getId());

            psmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

