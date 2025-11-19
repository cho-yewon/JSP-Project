package handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunicationPostDao;
import models.CommunicationPost;

import java.util.List;

public class CommunicationPostHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Logic to handle communication post (create, read, update, delete)
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        CommunicationPostDao postDao = new CommunicationPostDao();

        switch (action) {
        case "create":
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String author = request.getParameter("author");  // 실제로는 세션에서 사용자 정보를 가져올 것

            if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
                request.setAttribute("error", "제목과 내용을 모두 입력해주세요.");
                return "communication_post_form";  // "/WEB-INF/views/communication_post_form.jsp"
            }

            CommunicationPost newPost = new CommunicationPost();
            newPost.setTitle(title);
            newPost.setContent(content);
            newPost.setAuthor(author);

            boolean isCreated = postDao.createPost(newPost);
            if (!isCreated) {
                request.setAttribute("error", "게시글 작성에 실패했습니다.");
                return "communication_post_form";  // "/WEB-INF/views/communication_post_form.jsp"
            }

            // 게시글 작성 후 게시판 목록 페이지로 리다이렉트
            response.sendRedirect("communicationPostList.do");  // 게시판 목록 페이지로 이동
            return null;  // 리다이렉트 후 추가 로직은 필요 없음

            case "read":
                // Logic to read a post
                String postIdStr = request.getParameter("postId");
                if (postIdStr == null) {
                    request.setAttribute("error", "잘못된 게시글 ID입니다.");
                    return "communication_post_list";  // "/WEB-INF/views/communication_post_list.jsp"
                }

                int postId = Integer.parseInt(postIdStr);
                CommunicationPost post = postDao.getPostById(postId);
                if (post == null) {
                    request.setAttribute("error", "게시글을 찾을 수 없습니다.");
                    return "communication_post_list";  // "/WEB-INF/views/communication_post_list.jsp"
                }

                request.setAttribute("post", post);
                return "communication_post_view";  // "/WEB-INF/views/communication_post_view.jsp"

            case "update":
                // Logic to update a post
                postIdStr = request.getParameter("postId");
                if (postIdStr == null) {
                    request.setAttribute("error", "잘못된 게시글 ID입니다.");
                    return "communication_post_list";
                }

                postId = Integer.parseInt(postIdStr);
                post = postDao.getPostById(postId);
                if (post == null) {
                    request.setAttribute("error", "게시글을 찾을 수 없습니다.");
                    return "communication_post_list";
                }

                title = request.getParameter("title");
                content = request.getParameter("content");
                if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
                    request.setAttribute("error", "제목과 내용을 모두 입력해주세요.");
                    request.setAttribute("post", post);
                    return "communication_post_form";  // 게시글 수정 폼으로 이동
                }

                post.setTitle(title);
                post.setContent(content);
                boolean isUpdated = postDao.updatePost(post);
                if (!isUpdated) {
                    request.setAttribute("error", "게시글 수정에 실패했습니다.");
                    return "communication_post_form";
                }

                return "communication_post_view";  // 수정 후 상세보기로 이동

            case "delete":
                // Logic to delete a post
                postIdStr = request.getParameter("postId");
                if (postIdStr == null) {
                    request.setAttribute("error", "잘못된 게시글 ID입니다.");
                    return "communication_post_list";
                }

                postId = Integer.parseInt(postIdStr);
                boolean isDeleted = postDao.deletePost(postId);
                if (!isDeleted) {
                    request.setAttribute("error", "게시글 삭제에 실패했습니다.");
                    return "communication_post_view";
                }

                return "communication_post_list";  // 삭제 후 목록으로 이동

            default:
                // Default to listing posts
                List<CommunicationPost> posts = postDao.getAllPosts();
                request.setAttribute("posts", posts);
                return "communication_post_list";  // "/WEB-INF/views/communication_post_list.jsp"
        }
    }
}
