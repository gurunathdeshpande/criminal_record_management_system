package com.criminal_record_management.entities;

public class Crime {
    private int crimeId;
    private String date;
    private String location;
    private String type;
    private String description;
    private String peopleInvolved;
    private String status;

    public Crime() {
        super();
    }

    public Crime(int crimeId, String date, String location, String type, String description, String peopleInvolved, String status) {
        super();
        this.crimeId = crimeId;
        this.date = date;
        this.location = location;
        this.type = type;
        this.description = description;
        this.peopleInvolved = peopleInvolved;
        this.status = status;
    }

    public Crime(String date, String location, String type, String description, String peopleInvolved, String status) {
        super();
        this.date = date;
        this.location = location;
        this.type = type;
        this.description = description;
        this.peopleInvolved = peopleInvolved;
        this.status = status;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(int crimeId) {
        this.crimeId = crimeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeopleInvolved() {
        return peopleInvolved;
    }

    public void setPeopleInvolved(String peopleInvolved) {
        this.peopleInvolved = peopleInvolved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
