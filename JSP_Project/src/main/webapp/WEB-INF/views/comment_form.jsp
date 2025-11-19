<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>댓글 작성</title>
</head>
<body>
    <h2>댓글 작성</h2>
    <form action="commentWrite.do" method="post">
        <label for="commentContent">댓글 내용:</label>
        <textarea name="commentContent" id="commentContent" rows="4" cols="50"></textarea><br>
        <input type="submit" value="댓글 작성">
    </form>
</body>
</html>