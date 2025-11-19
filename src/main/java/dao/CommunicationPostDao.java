package dao;

import models.CommunicationPost;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JSP_Project.DatabaseConnection;

public class CommunicationPostDao {

    // 게시글 생성 메소드
    public boolean createPost(CommunicationPost post) {
        String sql = "INSERT INTO tb_post (title, content, author) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getAuthor());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 게시글 ID로 게시글 가져오기
    public CommunicationPost getPostById(int postId) {
        String sql = "SELECT * FROM tb_post WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    CommunicationPost post = new CommunicationPost();
                    post.setId(rs.getInt("id"));
                    post.setTitle(rs.getString("title"));
                    post.setContent(rs.getString("content"));
                    post.setAuthor(rs.getString("author"));
                    post.setCreatedDate(rs.getTimestamp("created_date"));
                    return post;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 모든 게시글 가져오기
    public List<CommunicationPost> getAllPosts() {
        List<CommunicationPost> posts = new ArrayList<>();
        String sql = "SELECT * FROM tb_post ORDER BY created_date DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CommunicationPost post = new CommunicationPost();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setAuthor(rs.getString("author"));
                post.setCreatedDate(rs.getTimestamp("created_date"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    // 게시글 수정 메소드
    public boolean updatePost(CommunicationPost post) {
        String sql = "UPDATE tb_post SET title = ?, content = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getId());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // 게시글 삭제 메소드
    public boolean deletePost(int postId) {
        String sql = "DELETE FROM tb_post WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

   

