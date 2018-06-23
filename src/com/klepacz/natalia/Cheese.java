package com.klepacz.natalia;

import java.net.URL;

public class Cheese {
    private String department;
    private int zipCode;
    private String cheese;
    private URL frenchURL;
    private URL englishURL;
    private URL imageURL;
    private String milk;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public URL getFrenchURL() {
        return frenchURL;
    }

    public void setFrenchURL(URL frenchURL) {
        this.frenchURL = frenchURL;
    }

    public URL getEnglishURL() {
        return englishURL;
    }

    public void setEnglishURL(URL englishURL) {
        this.englishURL = englishURL;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    @Override
    public String toString() {
        return cheese + "[" +
                "DEPARTMENT: " + department +
                ", ZIP CODE: " + zipCode +
                ", FRENCH URL: " + frenchURL +
                ", ENGLISH URL: " + englishURL +
                ", IMAGE URL: " + imageURL +
                ", MILK: " + milk +
                "]";
    }
}
