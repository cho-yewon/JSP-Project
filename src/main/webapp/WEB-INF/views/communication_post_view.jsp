<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 상세보기</title>
</head>
<body>
    <h2><%= request.getAttribute("postTitle") %></h2>
    <p><strong>작성자:</strong> <%= request.getAttribute("postAuthor") %></p>
    <p><strong>작성일:</strong> <%= request.getAttribute("postDate") %></p>
    <p><strong>조회수:</strong> <%= request.getAttribute("postViews") %></p>
    <p><%= request.getAttribute("postContent") %></p>

    <a href="communicationPost.do?action=update&id=<%= request.getAttribute("postId") %>">수정</a> |
    <a href="communicationPost.do?action=delete&id=<%= request.getAttribute("postId") %>">삭제</a>
    <br><br>
    <a href="communicationPost.do?action=list">목록으로</a>
</body>
</html>