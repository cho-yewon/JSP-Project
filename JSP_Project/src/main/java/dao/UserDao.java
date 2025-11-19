package dao;

import models.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JSP_Project.DatabaseConnection;

public class UserDao {

    // 사용자 로그인 확인 메소드
    public boolean validateUser(User user) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());

            ResultSet rs = pstmt.executeQuery();

            return rs.next();  // 사용자 존재 여부 확인

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 오류 발생 시 false 반환
        }
    }

    // 사용자 저장 메소드 (회원가입)
    public boolean save(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // 사용자가 성공적으로 저장되면 true 반환

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 오류 발생 시 false 반환
        }
    }
}