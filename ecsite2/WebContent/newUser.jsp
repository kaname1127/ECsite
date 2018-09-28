<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>【管理者用】ユーザー登録画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>【管理者用】ユーザー登録画面</h1>

		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>

		<s:form action="NewUserConfirmAction">
			<table class="vertical-list-table">
				<tr>
					<th scope="row">姓</th>
					<td><input type="text" name="familyName" value="" size="40"
						class="update" placeholder="姓を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">名</th>
					<td><input type="text" name="firstName" value="" size="40"
						class="update" placeholder="名を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">姓ふりがな</th>
					<td><input type="text" name="familyNameKana" value=""
						size="40" class="update" placeholder="姓ふりがなを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">名ふりがな</th>
					<td><input type="text" name="firstNameKana" value="" size="40"
						class="update" placeholder="名ふりがなを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">性別</th>
					<td><input type="text" name="sex" value="" size="40"
						class="update" placeholder="性別を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">メールアドレス</th>
					<td><input type="text" name="email" value="" size="40"
						class="update" placeholder="メールアドレスを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">ログインID</th>
					<td><input type="text" name="loginId" value="" size="40"
						class="update" placeholder="ログインIDを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">パスワード</th>
					<td><input type="text" name="password" value="" size="40"
						class="update" placeholder="パスワードを入力して下さい" /></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<s:submit value="登録" class="submit_btn" />
				</div>
			</div>
		</s:form>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>