<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>管理者画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>管理者画面</h1>
		<div class="admin">
			<a href='<s:url action="ProductListAction" />' class="admin_btn">商品一覧</a>
			<a href='<s:url action="UserListAction" />' class="admin_btn">ユーザー一覧</a>
			<br> <br> <br> <br> <br> <br> <a
				href='<s:url action="CreateProductAction" />' class="admin_btn">商品登録</a>
			<a href='<s:url action="NewUserAction" />' class="admin_btn">ユーザー登録</a>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>