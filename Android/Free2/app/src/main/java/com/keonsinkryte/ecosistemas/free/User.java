package com.keonsinkryte.ecosistemas.free;

/**
 * Created by msi on 31/05/2018.
 */

public class User {

    private String email, password, uID, ID;
    private float score;

    public User(){}

    public User(String email, String password, String uID, String ID, float score){
        this.email = email;
        this.password = password;
        this.uID = uID;
        this.ID = ID;
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}