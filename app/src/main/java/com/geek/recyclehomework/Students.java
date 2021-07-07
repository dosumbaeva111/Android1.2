package com.geek.recyclehomework;

public class Students {

    private String name;
    private String surename;

    public Students(String name, String surename) {
        this.name = name;
        this.surename = surename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }
}