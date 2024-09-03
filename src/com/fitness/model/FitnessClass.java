package com.fitness.model;

//import java.time.LocalDateTime;

public class FitnessClass {
    private int classId;
    private int trainerId;
    private String className;
    //private LocalDateTime schedule;
    private String schedule;
    private int capacity;
    private String status;

     // Constructor without classId (for creating new classes)
     public FitnessClass(int trainerId, String className, String schedule, int capacity, String status) {
         this.trainerId = trainerId;
         this.className = className;
         this.schedule = schedule;
         this.capacity = capacity;
         this.status = status;
     }

    // Constructor with classId (for viewing/updating existing classes)
    public FitnessClass(int classId, int trainerId, String className, String schedule, int capacity, String status) {
        this.classId = classId;
        this.trainerId = trainerId;
        this.className = className;
        this.schedule = schedule;
        this.capacity = capacity;
        this.status = status;
    }

    // Getters and Setters
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method for easy display of class details
    @Override
    public String toString() {
        return "FitnessClass{" +
                "classId=" + classId +
                ", trainerId=" + trainerId +
                ", className='" + className + '\'' +
                ", schedule=" + schedule +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                '}';
    }
}


