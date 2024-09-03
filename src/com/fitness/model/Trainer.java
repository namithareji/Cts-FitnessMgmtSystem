package com.fitness.model;


public class Trainer {
    private int trainerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String specialization;

    // Constructors
    public Trainer() {}

    public Trainer(int trainerId, String name, String email, String phoneNumber, String specialization) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }

    // Getters and Setters
    public int getTrainerId() { return trainerId; }
    public void setTrainerId(int trainerId) { this.trainerId = trainerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}

