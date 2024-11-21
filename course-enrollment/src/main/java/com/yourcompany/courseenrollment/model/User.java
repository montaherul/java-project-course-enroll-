package com.yourcompany.courseenrollment.model;



public class User {

    private Long id;

    private String name;
    private String email;
    private String password;


    public CharSequence getPassword() {
        return password;
    }

    public void setPassword(String encode) {
        this.password = encode;
    }

    public String getEmail() {
        return email;
    }

    // Getters and Setters
    // ...
}
