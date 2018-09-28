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
<title>管理画面</title>
<style type="text/css">
h1 {
	margin: 0 auto;
	margin-top: 20px;
	margin-bottom: 10px;
	padding-top: 5px;
	padding-bottom: 5px;
	width: 500px;
	font-size: 20px;
}

body {
	margin: 0px;
	padding: 00px;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
}

label {
	font-size: 12px;
}

.new {
	float: left;
	margin-left: 45px;
	text-align: left;
}

.delete {
	float: right;
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

#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
	border-radius: 5px;
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

#admin1 {
	border: 1px solid lightgray;
	border-radius: 5px;
	width: 600px;
	height: 100px;
	margin: 15px auto;
	vertical-align: middle text-align:center;
	background-color: #F5F5F5;
}

#admin1 .btn {
	text-decoration: none;
	color: #000000;
	background-color: #fcfcfc;
	border: #000000 solid 1px;
	font-size: 15px;
	padding: 20px;
	margin: 60px 30px 30px 30px;
	vertical-align: middle;
}

#admin1 .btn:hover {
	color: #ffffff;
	background-color: #000000;
	cursor: pointer;
}

#admin2 {
	border: 1px solid lightgray;
	border-radius: 5px;
	width: 600px;
	height: 100px;
	margin: 15px auto;
	vertical-align: middle text-align:center;
	background-color: #F5F5F5;
}

#admin2 .btn {
	text-decoration: none;
	color: #000000;
	background-color: #fcfcfc;
	border: #000000 solid 1px;
	font-size: 15px;
	padding: 20px;
	margin: 60px 30px 30px 30px;
	vertical-align: middle;
}

#admin2 .btn:hover {
	color: #ffffff;
	background-color: #000000;
	cursor: pointer;
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

#text-link {
	display: inline-block;
	text-align: right;
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
	font-weight: bold; hover span{ -webkit-transform : rotateX( 360deg);
	-ms-transform: rotateX(360deg);
	transform: rotateX(360deg);
}

.square_btn:active {
	border-bottom: solid 2px #fd9535;
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}

.new h1 {
	border-left: 4px solid black;
	padding-left: 5.5px;
}
</style>

</head>
<body>

	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>管理画面</p>
		</div>

		<div id="admin1">
			<a href='<s:url action="ItemCreateAction" />' class="btn">新商品登録</a> <a
				href='<s:url action="NewUserAction" />' class="btn">新規ユーザー登録</a> <br>
			<br>
			<br>
			<br>
		</div>
		<br>
		<div id="admin2">
			<a href='<s:url action="ItemListAction" />' class="btn">商品一覧</a> <a
				href='<s:url action="UserListAction" />' class="btn">ユーザー一覧</a>
		</div>
	</div>

	<div id="footer">
		<div class="other">
			<a href='<s:url action="GoHomeAction" />' class="square_btn">HOMEへ</a>
			<%-- 			<a href='<s:url action="ItemListAction" />' class="square_btn">商品一覧へ</a> --%>
			<%-- 			<a href='<s:url action="UserListAction" />' class="square_btn">ユーザー一覧へ</a> --%>
			<a href='<s:url action="LogoutAction" />' class="square_btn">ログアウト</a>
		</div>
	</div>

</body>
</html>