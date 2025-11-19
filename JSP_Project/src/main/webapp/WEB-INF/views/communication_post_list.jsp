
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="models.CommunicationPost" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 목록</title>
</head>
<body>
    <h2>게시물 목록</h2>

    <table border="1">
        <thead>
            <tr>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
            <%
                // request에서 "posts" 속성 가져오기
                List<CommunicationPost> posts = (List<CommunicationPost>) request.getAttribute("posts");
                if (posts != null) {
                    for (CommunicationPost post : posts) {
            %>
                <tr>
                    <td><a href="communicationPost.do?action=view&id=<%= post.getId() %>"><%= post.getTitle() %></a></td>
                    <td><%= post.getAuthor() %></td>
                    <td><%= post.getCreatedDate() %></td>
                    <td><%= post.getViews() %></td>
                    <td>
                        <a href="communicationPost.do?action=update&id=<%= post.getId() %>">수정</a> | 
                        <a href="communicationPost.do?action=delete&id=<%= post.getId() %>">삭제</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="5">게시물이 없습니다.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <br>
    <a href="communicationPost.do?action=create">게시물 작성</a>
</body>
</html>
