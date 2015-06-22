<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>ログイン画面</title>
		<link href="css/login.css" rel="stylesheet" type="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<div class="sp">
		<s:form action="LoginAction">
			<s:textfield label="username:" name="username" value="" size="15"></s:textfield>
			<s:password  label="password:" name="password" value="" size="16"></s:password>
			<s:submit name="submit" value="Login" />
		</s:form>
		<s:form action="TwitterLogin">
			<s:submit name="submit" value="TwitterLogin" />
		</s:form>
		</div>
	</body>
</html>