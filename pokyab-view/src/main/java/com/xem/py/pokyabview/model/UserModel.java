package com.xem.py.pokyabview.model;

/**
 *
 * @author arria
 */
public class UserModel {
    /**
     *
     */
//    private static final long serialVersionUID = 1L;

    private int id;
    private String fullName;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
