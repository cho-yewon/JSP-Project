<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메인 화면</title>
</head>
<body>
    <h2>메인 화면</h2>
    <nav>
        <a href="communicationPostList.do">소통 게시판</a> |
        <a href="hotdealPostList.do">핫딜 게시판</a> |
        <a href="performanceCheck.do">성능 체크 링크</a> |
        <a href="login.do">로그인</a>
    </nav>

    <h3>인기 핫딜 게시물</h3>
    <table>
        <thead>
            <tr>
                <th>제목</th>
                <th>조회수</th>
                <th>날짜</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${hotdealPosts}">
                <tr>
                    <td><a href="hotdealPostView.do?id=${post.id}">${post.title}</a></td>
                    <td>${post.viewCount}</td>
                    <td>${post.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>