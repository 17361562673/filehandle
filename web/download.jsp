<%--
  Created by IntelliJ IDEA.
  User: 17361562673
  Date: 2019/10/25
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>文件下载列表</title>
    <style type="text/css" rel="stylesheet">
        a{text-decoration: none}
    </style>
</head>
<body>
<h2>文件下载列表</h2>
<hr>
<c:forEach items="${fileList}" var="file">
    <a href="${cpath}/download?fileName=${file.getName()}">${file.getName()}&nbsp;&nbsp;&nbsp;点击下载</a><br><br>
</c:forEach>
</body>
</html>
