package com.vinayak09.wsafety;

import java.util.ArrayList;

public class Users {

    private static ArrayList<Users> user_list = new ArrayList<>();

    private String name;
    private String email;
    private String age;
    private String ph_number;
    private String address;
    private String healthissue;
    private String medicationad;

    public Users() {

    }

    public Users(String name, String email, String age, String ph_number, String address, String healthissue, String medicationad) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.ph_number = ph_number;
        this.address = address;
        this.healthissue = healthissue;
        this.medicationad = medicationad;
    }

    public static ArrayList<Users> getUser_list() {
        return user_list;
    }

    public static void setUserArrayList(Users p) {
        Users.user_list.add(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPh_number() {
        return ph_number;
    }

    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getHealthissue() {
        return healthissue;
    }

    public void setHealthissue(String healthissue) {
        this.healthissue = healthissue;
    }

    public String getMedicationad() {
        return medicationad;
    }

    public void setMedicationad(String medicationad) {
        this.medicationad = medicationad;
    }
}

