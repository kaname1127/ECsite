<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品情報更新</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>【管理者用】商品情報更新画面</h1>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>

		<div>
			<s:form action="ProductUpdateConfirmAction">
				<div>
					<label>商品No：</label>
					<s:property value="%{#session.id}" escape="false" />
					<s:hidden name="id" value="%{#session.id}" />
				</div>
				<div>
					<label>新しい値段</label> <br> <input type="text" name="price"
						value="" size="30" class="update" />円<br>
				</div>
				<div>
					<label>新しい商品詳細情報</label> <br> <input type="text"
						name="productDescription" value="" size="50" class="update" /><br>
				</div>
				<br>


				<div>
					<s:submit value="商品の情報を更新する" />
				</div>
			</s:form>
		</div>

	</div>
	<s:include value="footer.jsp" />
</body>
</html>