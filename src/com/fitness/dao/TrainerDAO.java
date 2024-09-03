package com.fitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fitness.model.*;

public class TrainerDAO {

    // Method to add a new trainer
    public void addTrainer(Trainer trainer) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Trainer (name, email, phone_number, specialization) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trainer.getName());
            pstmt.setString(2, trainer.getEmail());
            pstmt.setString(3, trainer.getPhoneNumber());
            pstmt.setString(4, trainer.getSpecialization());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view trainer details
    public Trainer viewTrainer(int trainerId) {
        Trainer trainer = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Trainer WHERE trainer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, trainerId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                trainer = new Trainer(
                    rs.getInt("trainer_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("specialization")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainer;
    }

    // Method to update trainer information
    public void updateTrainer(Trainer trainer) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Trainer SET name = ?, email = ?, phone_number = ?, specialization = ? WHERE trainer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trainer.getName());
            pstmt.setString(2, trainer.getEmail());
            pstmt.setString(3, trainer.getPhoneNumber());
            pstmt.setString(4, trainer.getSpecialization());
            pstmt.setInt(5, trainer.getTrainerId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a trainer
    public void deleteTrainer(int trainerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Trainer WHERE trainer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, trainerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  Method to list all trainers
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Trainer";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Trainer trainer = new Trainer(
                    rs.getInt("trainer_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("specialization")
                );
                trainers.add(trainer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }
}


