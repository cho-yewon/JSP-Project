<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원 가입</h2>
    <form action="register.do" method="post">
        <label for="username">아이디:</label>
        <input type="text" name="username" id="username" required><br>
        <label for="email">이메일:</label>
        <input type="email" name="email" id="email" required><br>
        <label for="password">비밀번호:</label>
        <input type="password" name="password" id="password" required><br>
        <input type="submit" value="가입하기">
    </form>
</body>
</html>