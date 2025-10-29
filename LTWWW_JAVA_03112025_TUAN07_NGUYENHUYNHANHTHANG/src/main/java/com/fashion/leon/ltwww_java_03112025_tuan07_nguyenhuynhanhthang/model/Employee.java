package com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.model;

public class Employee {
    private int id;
    private String role;
    private String name;

    public Employee() {
    }

    public Employee(String name, String role, int id) {
        this.name = name;
        this.role = role;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
