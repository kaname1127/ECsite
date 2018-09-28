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
<title>商品一覧画面</title>
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

#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}
</style>
</head>

<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>商品一覧</p>
		</div>
		<div>
			<%-- 		<s:form action ="BuyItemAction"> --%>
			<p>商品の一覧は以下です。購入したい商品の詳細から、購入へ進めます</p>
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
			<!-- 			<table> -->
			<!-- 				<tr> -->
			<!-- 					<td> -->
			<%-- 						<span>商品名</span> --%>
			<!-- 					</td> -->
			<!-- 					<td> -->
			<%-- 						<s:property value ="session.buyItem_name" /><br> --%>
			<!-- 					</td> -->
			<!-- 				</tr> -->
			<!-- 				<tr> -->
			<!-- 					<td> -->
			<%-- 						<span>値段</span> --%>
			<!-- 					</td> -->
			<!-- 					<td> -->
			<%-- 						<s:property value="session.buyItem_price" /><span>円</span> --%>
			<!-- 					</td> -->
			<!-- 				</tr> -->
			<!-- 				<tr> -->
			<!-- 					<td> -->
			<%-- 						<span>購入個数</span> --%>
			<!-- 					</td> -->
			<!-- 					<td> -->
			<%-- 						<select name ="count"> --%>
			<!-- 							<option value ="1" selected="selected">1</option> -->
			<!-- 								<option value ="2">2</option> -->
			<!-- 								<option value ="3">3</option> -->
			<!-- 								<option value ="4">4</option> -->
			<!-- 								<option value ="5">5</option> -->
			<%-- 						</select> --%>
			<!-- 					</td> -->
			<!-- 				</tr> -->
			<!-- 				<tr> -->
			<!-- 					<td> -->
			<%-- 						<span>支払い方法</span> --%>
			<!-- 					</td> -->
			<!-- 					<td> -->
			<!-- 					<input type="radio" name="pay" value="1" checked="checked">現金払い -->
			<!-- 					<input type="radio" name="pay" value="2">クレジットカード -->
			<!-- 					</td> -->
			<!-- 				</tr> -->
			<!-- 				<tr> -->
			<!-- 					<td> -->
			<%-- 					<s:submit value="購入"/> --%>
			<!-- 					</td> -->
			<!-- 				</tr> -->
			<!-- 			</table> -->
			<%-- 			</s:form> --%>

			<div>
				<p>
					前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
				</p>
				<p>
					マイぺージは<a href='<s:url action="MyPageAction" />'>こちら</a>
				</p>
				<p>
					ログアウトは<a href='<s:url action="GoLogoutAction" />'>こちら</a>
				</p>
			</div>

		</div>
	</div>

	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>