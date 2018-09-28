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
<title>商品詳細ページ</title>
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
	height: 500px;
	text-align: center;
	float: clear;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: #000080;
	clear: both;
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
		<div id="top">
			<p>商品詳細ページ</p>
		</div>
		<div>
			<s:if test="itemDetailDTOList == null">
				<h3>この商品情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>この商品の詳細は以下です。</h3>
				<table>
					<tr id="box">
						<th class="th_top">商品id</th>
						<td class="td_top">No.<s:property value="%{#session.id}" /></td>
					</tr>
					<tr id="box">
						<th>商品名</th>
						<td><s:property value="%{#session.itemName}" /></td>
					</tr>
					<tr id="box">
						<th>値段</th>
						<td><s:property value="%{#session.itemPrice}" />円</td>
					</tr>
					<tr id="box">
						<th>在庫数</th>
						<td><s:property value="%{#session.itemStock}" />個</td>
					</tr>
				</table>

				<s:form action="ItemUpdateAction">
					<s:submit value="この商品の情報を更新する" />
				</s:form>

				<s:form action="ItemDetailAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="この商品情報を削除する" />
				</s:form>
			</s:elseif>

			<s:if test="message != null">
				<h3>
					<s:property value="message" />
				</h3>
			</s:if>


			<div id="text-right">
				<p>
					商品一覧へ戻る場合は<a href='<s:url action="ItemListAction" />'>こちら</a>
				</p>
				<p>
					Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
				</p>
				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
				</p>
			</div>
		</div>
	</div>

	<div id="footer">
		<div id="pr"></div>
	</div>

</body>

</html>