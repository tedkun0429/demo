<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BookList</title>
</head>
<body>
<a href="/book/bookAdd.html">新增</a> <br>
<form action="/book/dynamicList" method="post">
    名称：<input type="text" name="name" /> &nbsp;
    作者：<input type="text" name="author" /> &nbsp;
    <input type="submit" value="查询" />
</form>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>作者</th>
        <th>操作</th>
    </tr>
    <#list bookList as book >
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>
                <a href="/book/preModify/${book.id}">修改</a>
                <a href="/book/delete?id=${book.id}">删除</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>