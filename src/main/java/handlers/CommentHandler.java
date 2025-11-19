package handlers;

import models.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;

public class CommentHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 댓글 작성 처리
        String commentContent = request.getParameter("commentContent");
        String postId = request.getParameter("postId");

        if (commentContent == null || commentContent.trim().isEmpty()) {
            // 댓글 내용이 없으면 에러 페이지 또는 메시지 표시
            request.setAttribute("error", "댓글 내용을 입력해주세요.");
            return "comment_error";  // "/WEB-INF/views/comment_error.jsp"
        }

        // Comment 객체 생성
        Comment comment = new Comment();
        comment.setContent(commentContent);
        comment.setPostId(Integer.parseInt(postId));
        comment.setAuthor("Anonymous");  // 예시로 'Anonymous'로 설정, 실제 구현 시 세션 등에서 사용자 정보를 가져올 것

        // DB에 댓글 저장
        CommentDao commentDao = new CommentDao();
        boolean isSaved = commentDao.save(comment);

        if (!isSaved) {
            request.setAttribute("error", "댓글 저장에 실패했습니다.");
            return "comment_error";  // "/WEB-INF/views/comment_error.jsp"
        }

        // 저장 성공 후 결과 페이지로 이동
        return "comment_result";  // "/WEB-INF/views/comment_result.jsp"
    }
}