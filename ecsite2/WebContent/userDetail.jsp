<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ユーザー詳細</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ユーザー詳細</h1>

		<div>
			<s:if test="userInfoDTOList == null">
				<h3>このユーザーの情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>このユーザーの詳細は以下です。</h3>

				<table class="vertical-list-table">
					<tr>
						<th scope="row"><s:label value="ユーザーID" /></th>
						<td><s:property value="%{#session.userId}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="パスワード" /></th>
						<td><s:property value="%{#session.password}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="苗字" /></th>
						<td><s:property value="%{#session.familyName}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="名前" /></th>
						<td><s:property value="%{#session.firstName}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="苗字かな" /></th>
						<td><s:property value="%{#session.familyNameKana}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="名前かな" /></th>
						<td><s:property value="%{#session.firstNameKana}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="性別" /></th>
						<td><s:if test="#session.sex==0">男性</s:if>
							<s:if test="#session.sex==1">女性</s:if></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="メールアドレス" /></th>
						<td><s:property value="%{#session.email}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="ユーザー登録日" /></th>
						<td><s:property value="%{#session.registDate}" /></td>
					</tr>
				</table>

				<s:form action="UserUpdateAction">
					<s:submit value="このユーザー情報を更新する" />
				</s:form>

				<s:form action="UserDetailAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="このユーザー情報を削除する" />
				</s:form>
			</s:elseif>

			<s:if test="message != null">
				<h3>
					<s:property value="message" />
				</h3>
			</s:if>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>