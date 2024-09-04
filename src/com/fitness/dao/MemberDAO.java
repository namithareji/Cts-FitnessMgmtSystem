package com.fitness.dao;

import com.fitness.exception.MemberNotFoundException;
import com.fitness.model.Member;

import util.DBConnection;
import java.sql.*;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
public class MemberDAO {
	
	
    public void registerMember(Member member) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Member (name, email, phone_number, membership_type) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhoneNumber());
            pstmt.setString(4, member.getMembershipType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member viewMember(int memberId)throws MemberNotFoundException {
        Member member = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Member WHERE member_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new Member(
                    rs.getInt("member_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("membership_type")
                );
            }
            else {
                throw new MemberNotFoundException("No member found with ID: " + memberId);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return member;
    }

    public void updateMember(Member member) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Member SET name = ?, email = ?, phone_number = ?, membership_type = ? WHERE member_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhoneNumber());
            pstmt.setString(4, member.getMembershipType());
            pstmt.setInt(5, member.getMemberId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(int memberId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Member WHERE member_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

