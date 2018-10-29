package com.example.app.myapp.model;

public class Information {
    private String id;
    private String oc;
    private String name;
    private String phone;

    public Information() {
    }


    public Information(String id, String oc, String name, String phone) {
        this.id = id;
        this.oc = oc;
        this.name = name;
        this.phone = phone;
    }

    public String getOc() {
        return oc;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

}
