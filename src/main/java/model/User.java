package model;

public class User {
    private int userID;
    private String userEmail;
    private String userPass;
    private String userRole;
    private String phoneNumber;
    private String userName;


    public User() {
    }

    public User(int userID, String userEmail, String userPass, String userRole, String phoneNumber, String userName) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userRole = userRole;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    public User(int userID, String userEmail, String userPass, String userRole) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userRole = userRole;
    }

    public User(String userEmail, String userPass, String userRole, String phoneNumber, String userName) {
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userRole = userRole;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
