<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BookModify</title>
</head>
<body>
<form action="/book/modify" method="post">
    <input type="hidden" name="id" value="${book.id}"/>
    名称：<input type="text" name="name" value="${book.name}"/> <br>
    作者：<input type="text" name="author" value="${book.author}"/> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>