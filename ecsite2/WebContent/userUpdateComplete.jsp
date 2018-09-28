<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ユーザー情報更新完了</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="contents">
		<h1>ユーザー情報の更新完了画面</h1>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<h3>ユーザー情報の更新が完了しました！</h3>
	</div>

	<s:include value="footer.jsp" />
</body>
</html>