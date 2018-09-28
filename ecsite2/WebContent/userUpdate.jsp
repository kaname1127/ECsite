<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ユーザー情報更新</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ユーザー情報更新画面</h1>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<h3>ユーザーの更新情報を、下の項目に入力して下さい。</h3>
		<div>
			<s:form action="UserUpdateConfirmAction">
				<div>
					<label>id：</label>
					<s:property value="%{#session.id}" escape="false" />
					<s:hidden name="id" value="%{#session.id}" />
				</div>
				<table class="vertical-list-table">
					<tr>
						<th scope="row">姓</th>
						<td><s:textfield name="familyName"
								value="%{#session.familyName}" label="姓" placeholder="姓"
								class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">名</th>
						<td><s:textfield name="firstName"
								value="%{#session.firstName}" label="名" placeholder="名"
								class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">姓ふりがな</th>
						<td><s:textfield name="familyNameKana"
								value="%{#session.familyNameKana}" label="姓ふりがな"
								placeholder="姓ふりがな" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">名ふりがな</th>
						<td><s:textfield name="firstNameKana"
								value="%{#session.firstNameKana}" label="名ふりがな"
								placeholder="名ふりがな" class="txt" /></td>
					</tr>
<!-- 					<tr> -->
<!-- 						<th scope="row">性別</th> -->
<%-- 						<td><s:radio name="sex" list="%{#session.sexList}" --%>
<%-- 								value="%{#session.sex}" label="性別" placeholder="性別" /></td> --%>
<!-- 					</tr> -->
					<tr>
						<th scope="row">メールアドレス</th>
						<td><s:textfield name="email" value="%{#session.email}"
								label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">ログインID</th>
						<td><s:textfield name="loginId" value="%{#session.loginId}"
								label="ログインID" placeholder="ログインID" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">パスワード</th>
						<td><s:password name="password" value="" label="パスワード"
								placeholder="パスワード" class="txt" /></td>
					</tr>
				</table>
				<div class="submit_btn_box">
					<div id=".contents-btn-set">
						<s:submit value="ユーザー情報を更新" class="submit_btn" />
					</div>
				</div>
			</s:form>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>