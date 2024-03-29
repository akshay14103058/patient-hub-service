package com.patient.hub.entity;

import java.util.UUID;

public class Patient {
    private UUID patientId;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String phone;
    private String email;
    private boolean isRegisteredMember;

    public Patient(String firstName, String lastName, int age) {
        this.patientId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //define getters and setters

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRegisteredMember() {
        return isRegisteredMember;
    }

    public void setRegisteredMember(boolean registeredMember) {
        isRegisteredMember = registeredMember;
    }
}