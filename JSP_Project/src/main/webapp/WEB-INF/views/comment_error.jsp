<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>댓글 오류</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header class="main-header">
        <div class="logo">
            <a href="main.jsp">
                <img src="kbo_logo.png" alt="KBO Community Logo" />
            </a>
        </div>
    </header>

    <main class="content">
        <h2>댓글 작성 오류</h2>
        <p><strong>오류:</strong> <%= request.getAttribute("error") %></p>
        <button onclick="history.back()">뒤로 가기</button>
    </main>
</body>
</html>