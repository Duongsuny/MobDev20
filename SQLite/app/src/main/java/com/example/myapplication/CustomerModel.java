package com.example.myapplication;

public class CustomerModel {
    private int ID;
    private String name;
    private int age;
    private boolean isVip;

    public CustomerModel(int ID, String name, int age, boolean isVip) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.isVip = isVip;
    }

    public CustomerModel() {    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Override
    public String toString() {
        return  "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isVip=" + isVip +
                '}';
    }
}
