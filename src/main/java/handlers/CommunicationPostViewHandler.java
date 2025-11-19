package handlers;

import models.CommunicationPost;
import models.Comment;
import dao.CommunicationPostDao;
import dao.CommentDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommunicationPostViewHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String postIdStr = request.getParameter("id");
        if (postIdStr == null) {
            request.setAttribute("error", "잘못된 게시물 ID입니다.");
            return "error";
        }

        int postId = Integer.parseInt(postIdStr);

        // 게시물 정보 가져오기
        CommunicationPostDao postDao = new CommunicationPostDao();
        CommunicationPost post = postDao.getPostById(postId);

        // 댓글 정보 가져오기
        CommentDao commentDao = new CommentDao();
        List<Comment> comments = commentDao.getCommentsByPostId(postId);

        if (post == null) {
            request.setAttribute("error", "게시물을 찾을 수 없습니다.");
            return "error";
        }

        // 요청에 게시물 및 댓글 정보 추가
        request.setAttribute("post", post);
        request.setAttribute("comments", comments);

        // 게시물 상세보기 페이지로 이동
        return "communication_post_view";
    }
}