package com.aigulsharip.java_ee.lecture5.db;

public class User {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private UserRoles userRole;

    public User() {}

    public User(Long id, String email, String password, String fullName, UserRoles userRoles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.userRole = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoles userRole) {
        this.userRole = userRole;
    }
}
