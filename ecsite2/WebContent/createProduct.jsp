<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>新商品登録画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>【管理者用】新商品の登録画面</h1>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>

		<s:form action="CreateProductConfirmAction">

			<table class="vertical-list-table">
				<tr>
					<th scope="row">商品ID</th>
					<td><input type="text" name="productId" value="" size="30"
						class="update" placeholder="商品IDを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">商品名</th>
					<td><input type="text" name="productName" value="" size="60"
						class="update" placeholder="商品名を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">商品名かな</th>
					<td><input type="text" name="productNameKana" value=""
						size="60" class="update" placeholder="商品名かなを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">商品詳細</th>
					<td><input type="text" name="productDescription" value=""
						size="70" class="update" placeholder="商品詳細を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">カテゴリID</th>
					<td><input type="text" name="categoryId" value="" size="30"
						class="update" placeholder="カテゴリIDを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">商品の値段</th>
					<td><input type="text" name="price" value="" size="30"
						class="update" placeholder="商品の値段を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">画像ファイルパス</th>
					<td><input type="text" name="imageFilePath" value="" size="30"
						class="update" placeholder="画像ファイルパスを入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">画像ファイル名</th>
					<td><input type="text" name="imageFileName" value="" size="30"
						class="update" placeholder="画像ファイル名を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">発売年月</th>
					<td><input type="date" name="releaseDate" value="" size="30"
						class="update" placeholder="発売年月を入力して下さい" /></td>
				</tr>

				<tr>
					<th scope="row">発売会社</th>
					<td><input type="text" name="releaseCompany" value=""
						size="40" class="update" placeholder="発売会社を入力して下さい" /></td>
				</tr>
			</table>

			<s:submit value="新商品を登録する" />
		</s:form>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>