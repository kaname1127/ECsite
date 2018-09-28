<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="./css/style.css"> -->

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
	border-collapse: collapse;
	width: 60%;
}

td.t_top {
	border-top: #b3b3b3 4px solid;
}

th {
	border-bottom: #e3e3e3 1px dotted;
	text-align: left;
	padding: 10px;
	font-weight: bold;
	font-size: 13px;
	background-color: navy;
	color: white;
	width: 25%
}

td {
	border-bottom: #e3e3e3 1px dotted;
	text-align: left;
	padding: 10px;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}
</style>

<title>商品情報更新の確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>【管理者用】商品情報更新の確認画面</h1>
		<div id="main">
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="ProductUpdateCompleteAction">
					<tr id="box">
						<th>新しい値段</th>
						<td><s:property value="price" escape="false" /></td>
					</tr>
					<tr id="box">
						<th>新しい詳細情報</th>
						<td><s:property value="productDescription" escape="false" />
						</td>
					</tr>
					<s:hidden name="id" value="%{id}" />
					<s:hidden name="price" value="%{price}" />
					<s:hidden name="productDescription" value="%{productDescription}" />
					<s:submit value="商品情報を更新する" />
				</s:form>
			</table>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>