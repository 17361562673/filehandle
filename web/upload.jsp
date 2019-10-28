<%--
  Created by IntelliJ IDEA.
  User: 17361562673
  Date: 2019/10/25
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${cpath}/upload" method="post" enctype="multipart/form-data">
    照片：<input type="file" name="pic"><br>
    文档：<input type="file" name="doc"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
