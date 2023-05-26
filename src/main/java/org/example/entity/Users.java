package org.example.entity;


import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Users {
    private int userId;
    private String userName;
    private String password;
    private Date singinDate;

    public Users() {

    }

    public Users(String userName, String password, Date singinDate) {
        this.userName = userName;
        this.password = password;
        this.singinDate = singinDate;
    }

    public Users(int userId, String userName, String password, Date singinDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.singinDate = singinDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSinginDate() {
        return singinDate;
    }

    public void setSinginDate(Date singinDate) {
        this.singinDate = singinDate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", singinDate=" + singinDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(userName, users.userName) && Objects.equals(password, users.password) && Objects.equals(singinDate, users.singinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, singinDate);
    }
}
