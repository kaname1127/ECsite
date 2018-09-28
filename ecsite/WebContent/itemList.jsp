<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>商品一覧</title>
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
}

tr {
	padding: 5px;
}

.square_btn {
	position: relative;
	display: inline-block;
	padding: 5px 3px;
	margin: 5px;
	text-decoration: none;
	color: #FFF;
	background: #fd9535;
	border-bottom: solid 2px #d27d00;
	border-radius: 4px;
	box-shadow: inset 0 2px 0 rgba(255, 255, 255, 0.2), 0 2px 2px
		rgba(0, 0, 0, 0.19);
	font-weight: bold;
}

.square_btn:active {
	border-bottom: solid 2px #fd9535;
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}

#top {
	margin: 0 auto;
	letter-spacing: 4px;
	font: normal 26px/1 Verdana, Helvetica;
	font-size: 25px;
	position: relative;
	width: 300px;
	padding-bottom: 0px;
	border-bottom: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: #000080;
}

#main {
	width: 100%;
	height: 400px;
	text-align: center;
	margin-bottom: 20px;
}

#item {
	border: 1px solid lightgray;
	border-radius: 5px;
	width: 780px;
	height: 400px;
	margin: 15px auto;
	text-align: center;
	border-radius: 6px;
	background-color: white;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: #000080;
	clear: both;
}

#footer .other {
	text-align: center;
}

#text-right {
	display: inline-block;
	text-align: right;
}
</style>

</head>

<body>

	<div id="header"></div>

	<div id="main">
		<div id="item">
			<div id="top">
				<p>商品一覧</p>
			</div>
			<div>
				<s:if test="itemDTOList == null">
					<h3>登録されている商品はありません。</h3>
				</s:if>
				<s:elseif test="message == null">
					<h3>以下の商品が登録されています。</h3>
					<table border="1">
						<tr>
							<th>商品id</th>
							<th>商品名</th>
							<th>値段</th>
							<th>在庫</th>
							<th>詳細</th>
						</tr>

						<s:iterator value="itemDTOList">
							<tr>
								<td>No.<s:property value="id" /></td>
								<td><s:property value="itemName" /></td>
								<td><s:property value="itemPrice" />円</td>
								<td><s:property value="itemStock" />個</td>
								<td><a
									href='<s:url action="ItemDetailAction"><s:param name="id" value="%{id}"/></s:url>'>詳細</a></td>
							</tr>
						</s:iterator>
					</table>

					<div>
						<s:form action="ItemListAction">
							<input type="hidden" name="deleteFlg" value="1">
							<s:submit value="登録されている商品を全削除" method="delete" />
						</s:form>
					</div>
				</s:elseif>

				<s:if test="message != null">
					<h3>
						<s:property value="message" />
					</h3>
				</s:if>
			</div>
		</div>
	</div>

	<div id="footer">
		<div class="other">
			<a href='<s:url action="GoAdminAction" />' class="square_btn">管理画面へ</a>
			<a href='<s:url action="GoHomeAction" />' class="square_btn">HOMEへ</a>
			<a href='<s:url action="GoLogoutAction" />' class="square_btn">ログアウト</a>
		</div>
	</div>

</body>
</html>