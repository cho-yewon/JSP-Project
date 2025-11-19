<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>핫딜 게시물 상세 보기</title>
</head>
<body>
    <h2>${post.title}</h2>
    <p>${post.content}</p>
    <p>작성자: ${post.author}</p>
    <p>작성일: ${post.date}</p>

    <h3>댓글</h3>
    <c:forEach var="comment" items="${comments}">
        <div>
            <p>${comment.content}</p>
            <p>작성자: ${comment.author}</p>
        </div>
    </c:forEach>

    <h3>댓글 작성</h3>
    <form action="commentWrite.do" method="post">
        <textarea name="commentContent" rows="3" cols="50"></textarea><br>
        <input type="hidden" name="postId" value="${post.id}">
        <input type="submit" value="댓글 작성">
    </form>

    <form action="likePost.do" method="post">
        <input type="hidden" name="postId" value="${post.id}">
        <input type="submit" value="좋아요">
    </form>
</body>
</html>