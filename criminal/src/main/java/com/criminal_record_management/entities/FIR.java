package com.criminal_record_management.entities;

public class FIR {
    private int id;
    private String date;
    private String complainantName;
    private String policeName;
    private String incidentDate;
    private String incidentTime;
    private String location;
    private String description;
    private String accusedDetails;

    public FIR() {
        super();
    }

    public FIR(int id, String date, String complainantName, String policeName, String incidentDate, String incidentTime, String location, String description, String accusedDetails) {
        super();
        this.id = id;
        this.date = date;
        this.complainantName = complainantName;
        this.policeName = policeName;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
        this.accusedDetails = accusedDetails;
    }

    public FIR(String date, String complainantName, String policeName, String incidentDate, String incidentTime, String location, String description, String accusedDetails) {
        super();
        this.date = date;
        this.complainantName = complainantName;
        this.policeName = policeName;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
        this.accusedDetails = accusedDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public void setComplainantName(String complainantName) {
        this.complainantName = complainantName;
    }

    public String getPoliceName() {
        return policeName;
    }

    public void setPoliceName(String policeName) {
        this.policeName = policeName;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(String incidentTime) {
        this.incidentTime = incidentTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccusedDetails() {
        return accusedDetails;
    }

    public void setAccusedDetails(String accusedDetails) {
        this.accusedDetails = accusedDetails;
    }
}
