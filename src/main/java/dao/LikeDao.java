package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeDao {
    private Connection conn;

    public LikeDao(Connection conn) {
        this.conn = conn;
    }

    // 좋아요 등록
    public void addLike(int postId, int userId) throws SQLException {
        String sql = "INSERT INTO likes (post_id, user_id) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);

            pstmt.executeUpdate();
        }
    }

    // 좋아요 취소
    public void removeLike(int postId, int userId) throws SQLException {
        String sql = "DELETE FROM likes WHERE post_id = ? AND user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);

            pstmt.executeUpdate();
        }
    }

    // 게시글의 좋아요 수 조회
    public int getLikeCount(int postId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM likes WHERE post_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }

        return 0;
    }

    // 사용자가 게시글에 좋아요를 눌렀는지 확인
    public boolean isLikedByUser(int postId, int userId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM likes WHERE post_id = ? AND user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }

        return false;
    }
}