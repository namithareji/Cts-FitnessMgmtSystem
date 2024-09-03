CREATE DATABASE FitnessDB;

USE FitnessDB;
CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    membership_type VARCHAR(50) NOT NULL
);

CREATE TABLE Trainer (
    trainer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

CREATE TABLE Class (
    class_id INT AUTO_INCREMENT PRIMARY KEY,
    trainer_id INT,
    class_name VARCHAR(100) NOT NULL,
    schedule TIMESTAMP NOT NULL,
    capacity INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES Trainer(trainer_id)
);
SHOW DATABASES;
select * from Member;
select * from Trainer;
select * from Class;