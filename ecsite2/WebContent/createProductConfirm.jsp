<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>新商品登録内容確認画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>【管理者用】新商品：登録内容確認画面</h1>
		<h2>登録する内容は以下でよろしいですか。</h2>

		<s:form action="CreateProductCompleteAction">

			<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="商品ID" /></th>
					<td><s:property value="productId" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="新商品名" /></th>
					<td><s:property value="productName" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="商品名かな" /></th>
					<td><s:property value="productNameKana" escape="false" /></td>
				</tr>


				<tr>
					<th scope="row"><s:label value="商品詳細" /></th>
					<td><s:property value="productDescription" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="カテゴリID" /></th>
					<td><s:property value="categoryId" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="画像ファイルパス" /></th>
					<td><s:property value="imageFilePath" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="画像ファイル名" /></th>
					<td><s:property value="imageFileName" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="発売年月" /></th>
					<td><s:property value="releaseDate" escape="false" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="発売会社" /></th>
					<td><s:property value="releaseCompany" escape="false" /></td>
				</tr>
			</table>
			<s:submit value="完了" />
		</s:form>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>