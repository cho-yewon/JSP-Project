<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>핫딜 게시물 목록</title>
</head>
<body>
    <h2>핫딜 게시물 목록</h2>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${hotdealPosts}">
                <tr>
                    <td>${post.id}</td>
                    <td><a href="hotdealPostView.do?id=${post.id}">${post.title}</a></td>
                    <td>${post.author}</td>
                    <td>${post.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
