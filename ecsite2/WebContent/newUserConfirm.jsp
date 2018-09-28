<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>【管理者用】ユーザー登録の内容画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>【管理者用】ユーザー登録の内容画面</h1>
		<h3>登録する内容は以下でよろしいですか。</h3>
		<s:form action="NewUserCompleteAction">

			<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="姓" /></th>
					<td><s:property value="familyName" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名" /></th>
					<td><s:property value="firstName" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="姓ふりがな" /></th>
					<td><s:property value="familyNameKana" escape="false" /></td>
				</tr>


				<tr>
					<th scope="row"><s:label value="名ふりがな" /></th>
					<td><s:property value="firstNameKana" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="性別" /></th>
					<td><s:property value="sex" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="メールアドレス" /></th>
					<td><s:property value="email" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="ログインID" /></th>
					<td><s:property value="loginId" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="パスワード" /></th>
					<td><s:property value="password" escape="false" /></td>
				</tr>
			</table>

			<s:submit value="完了" />

			<%-- 			<s:hidden name="familyName" value="%{familyName}" /> --%>
			<%-- 			<s:hidden name="firstName" value="%{firstName}" /> --%>
			<%-- 			<s:hidden name="familyNameKana" value="%{familyNameKana}" /> --%>
			<%-- 			<s:hidden name="firstNameKana" value="%{firstNameKana}" /> --%>
			<%-- 			<s:if test='sex.equals("男性")'>; --%>
			<%-- 				<s:hidden name="sex" value="0" /> --%>
			<%-- 			</s:if> --%>
			<%-- 			<s:if test='sex.equals("女性")'>; --%>
			<%-- 				<s:hidden name="sex" value="1" /> --%>
			<%-- 			</s:if> --%>
			<%-- 			<s:hidden name="email" value="%{email}" /> --%>
			<%-- 			<s:hidden name="loginId" value="%{loginId}" /> --%>
			<%-- 			<s:hidden name="password" value="%{password}" /> --%>

		</s:form>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>