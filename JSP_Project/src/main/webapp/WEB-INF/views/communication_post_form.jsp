<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    // 작성자의 정보를 세션에서 가져옵니다.
    String author = (String) session.getAttribute("username");
    if (author == null) {
        author = "익명"; // 작성자 정보가 없을 경우 기본값 설정
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 작성</title>
</head>
<body>
    <h2>게시물 작성</h2>
    <form action="communicationPost.do?action=create" method="post">
        <!-- 작성자 정보는 세션에서 가져와 히든 필드로 설정 -->
        <input type="hidden" name="author" value="<%= author %>">

        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required><br>

        <label for="content">내용:</label>
        <textarea id="content" name="content" required></textarea><br>

        <button type="submit">게시물 작성</button>
    </form>
</body>
</html>
