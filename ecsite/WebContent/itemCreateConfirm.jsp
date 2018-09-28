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
<title>itemCreateConfirm画面</title>
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
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#top p {
	text-transform: uppercase;
	text-align: center;
	color: #666;
	margin: 0 auto;
	letter-spacing: 4px;
	font: normal 26px/1 Verdana, Helvetica;
	font-size: 25px;
	position: relative;
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
}

#footer {
	width: 100%;
	height: 80px;
	background-color: #000080;
	clear: both;
}
</style>

</head>

<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>新商品の登録内容確認</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="ItemCreateCompleteAction">
					<tr id="box">
						<th class="th_top">新商品名</th>
						<td class="td_top"><s:property value="itemName"
								escape="false" /></td>
					</tr>
					<tr id="box">
						<th>新商品値段</th>
						<td><s:property value="itemPrice" escape="false" /></td>
					</tr>
					<tr id="box">
						<th>在庫数</th>
						<td><s:property value="itemStock" escape="false" /></td>
					</tr>

					<s:submit value="完了" />

				</s:form>
			</table>
		</div>
	</div>

	<div id="footer"></div>
</body>

</html>