package com.example.dummy;

public class MyModel {
    String fname,lname,mail,mobile,date,gender,image;
//    int rating;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMail() {
        return mail;
    }

    public String getMobile() {
        return mobile;
    }


    public String getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public MyModel() {
    }

    public MyModel(String fname, String lname, String mail, String mobile, String date, String gender, String image) {
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.mobile = mobile;
        this.date = date;
        this.gender = gender;
        this.image = image;
    }
}
