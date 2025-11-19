package dao;

import models.Post;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JSP_Project.DatabaseConnection;

public class PostDao {

    // 게시물 저장 메소드
    public boolean save(Post post) {
        String sql = "INSERT INTO posts (title, content, author, date) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getAuthor());
            pstmt.setString(4, post.getDate());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // 게시물이 성공적으로 저장되면 true 반환

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 오류 발생 시 false 반환
        }
    }
}