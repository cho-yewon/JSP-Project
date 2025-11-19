<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>핫딜 게시물 작성</title>
</head>
<body>
    <h2>핫딜 게시물 작성</h2>
    <form action="hotdealPostWrite.do" method="post">
        <label for="title">제목:</label>
        <input type="text" name="title" id="title" required><br>
        <label for="content">내용:</label>
        <textarea name="content" id="content" rows="4" cols="50" required></textarea><br>
        <input type="submit" value="게시물 작성">
    </form>
</body>
</html>