<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/applist.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>アプリ一覧</title>
</head>
<body>

	<h1 class="midashi">Welcome</h1>

		<h2 class="midashi2">アプリ一覧</h2>

<br>
<p class="april"><b>April Coming Soon!!!!</b></p>
<br>
<div class="list">
<s:iterator value="siteInfoList">
<ul>
		<li><s:a href="%{url}"><s:property value="siteName" /></s:a></li>
</ul>
</s:iterator>
</div>

		<s:form action="logout">
		<s:submit name="submit" value="ログアウト"/>
		</s:form>


	</body>
</html>