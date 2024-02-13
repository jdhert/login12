<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% HttpSession session1 = request.getSession();

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/todo/style.css" />
    <title>Todo List</title>
</head>
<body>
<header>

</header>
<span>이름 : <%=session1.getAttribute("name")%></span>
<a href="/login/logout1">로그아웃</a>
<h1>todos</h1>
<form id="form">
    <input name="todo1" type="text" class="input" id="input" placeholder="Enter Your todo" autocomplete="off">
    <ul class="todos" id="todos">
    </ul>
</form>
<small>왼쪽 클릭: 항목 완료 <br> 오른쪽 클릭: 해당 항목 삭제</small>
<script src="/todo/script1.js"></script>
</body>
</html>