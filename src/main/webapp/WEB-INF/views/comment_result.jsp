<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>댓글 작성 결과</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header class="main-header">
        <div class="logo">
            <a href="main.do">
                <img src="kbo_logo.png" alt="KBO Community Logo" />
            </a>
        </div>
    </header>

    <main class="content">
        <h2>댓글 작성 성공</h2>
        <p>댓글이 성공적으로 작성되었습니다.</p>
        <button onclick="window.location.href='postDetail.jsp?postId=<%= request.getParameter("postId") %>';">게시글로 돌아가기</button>
    </main>
</body>
</html>