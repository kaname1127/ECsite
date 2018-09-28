<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
#contents {
	width: 80%;
	height: 400px;
	text-align: center;
	margin-bottom: 20px;
}

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

h1 {
	text-align: left;
}

h3 {
	margin-left: 30px;
	text-align: left;
}

table {
	text-align: center;
	margin: 30px 60px;
}

tr {
	padding: 5px;
}

th {
	width: 10px;
}
</style>

<title>ユーザー一覧</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ユーザー一覧</h1>

		<s:if test="userInfoDTOList == null">
			<h3>登録されているユーザーはありません。</h3>
		</s:if>

		<s:else>
			<s:if test="message != null">
				<h3>
					<s:property value="message" />
				</h3>
			</s:if>
			<h3>以下のユーザーが登録されています。</h3>

			<table border="1">
				<tr>
					<th>ユーザーNo</th>
					<th>ユーザーID</th>
					<th>苗字</th>
					<th>名前</th>
					<th>ユーザー詳細</th>
				</tr>

				<s:iterator value="userInfoDTOList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="userId" /></td>
						<td><s:property value="familyName" /></td>
						<td><s:property value="firstName" /></td>
						<td><a
							href='<s:url action="UserDetailAction"><s:param name="id" value="%{id}"/></s:url>'>詳細</a></td>
					</tr>
				</s:iterator>
			</table>

			<s:form action="UserListAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="管理者以外のユーザー全削除" method="delete" />
			</s:form>
		</s:else>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>