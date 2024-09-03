package com.fitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fitness.model.*;

public class ClassDAO {

    // Method to schedule a new class
    public void scheduleClass(FitnessClass fitnessClass) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Class (trainer_id, class_name, schedule, capacity, status) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, fitnessClass.getClassId());
            pstmt.setInt(1, fitnessClass.getTrainerId());
            pstmt.setString(2, fitnessClass.getClassName());
            pstmt.setObject(3, fitnessClass.getSchedule());
            pstmt.setInt(4, fitnessClass.getCapacity());
            pstmt.setString(5, fitnessClass.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view class details
    public FitnessClass viewClass(int classId) {
        FitnessClass fitnessClass = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Class WHERE class_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                fitnessClass = new FitnessClass(
                    rs.getInt("class_id"),
                    rs.getInt("trainer_id"),
                    rs.getString("class_name"),
                    //rs.getObject("schedule", LocalDateTime.class),
                    rs.getString("schedule"),
                    rs.getInt("capacity"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fitnessClass;
    }

    // Method to update class information
    
    public void updateClass(FitnessClass fitnessClass) {   
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Class SET trainer_id = ?, class_name = ?, schedule = ?, capacity = ?, status = ? WHERE class_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, fitnessClass.getTrainerId());
            pstmt.setString(2, fitnessClass.getClassName());
            pstmt.setObject(3, fitnessClass.getSchedule());
            pstmt.setInt(4, fitnessClass.getCapacity());
            pstmt.setString(5, fitnessClass.getStatus());
            pstmt.setInt(6, fitnessClass.getClassId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to cancel a class
    public void cancelClass(int classId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Class SET status = 'cancelled' WHERE class_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}

