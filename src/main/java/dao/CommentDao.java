package dao;

import models.Comment;
import JSP_Project.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    // 댓글을 DB에 저장하는 메소드
    public boolean save(Comment comment) {
        String sql = "INSERT INTO comments (content, author, post_id) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, comment.getContent());
            pstmt.setString(2, comment.getAuthor());
            pstmt.setInt(3, comment.getPostId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // 댓글이 성공적으로 저장되면 true 반환

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 오류 발생 시 false 반환
        }
    }

    // postId를 기반으로 댓글 목록을 가져오는 메소드
    public List<Comment> getCommentsByPostId(int postId) {
        String sql = "SELECT * FROM comments WHERE post_id = ?";
        List<Comment> comments = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setContent(rs.getString("content"));
                comment.setAuthor(rs.getString("author"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setDate(rs.getTimestamp("created_date").toLocalDateTime()); // 예시로 작성된 created_date 필드
                
                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return comments;
    }
}