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
<title>Login画面</title>
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

.square_btn {
	display: inline-block;
	padding: 2px 2px;
	margin: 6px;
	text-decoration: none;
	background: #f7f7f7;
	color: black;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.29);
}

.square_btn:active {
	box-shadow: inset 0 0 2px rgba(128, 128, 128, 0.1);
	transform: translateY(2px);
}

#login .login {
	padding: 7px;
	border-radius: 6px;
}

#login {
	border: 1px solid lightgray;
	border-radius: 5px;
	width: 780px;
	height: 300px;
	margin: 30px auto;
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

#text-link {
	display: inline-block;
	text-align: right;
}
</style>
</head>

<body>
	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>

		<div>
			<div id="login">
				<div id="loginform">
					<p>商品を購入する際にはログインをお願いします。</p>
					<s:form action="LoginAction">
						<s:textfield class="login" name="loginUserId" placeholder="ユーザーID" />
						<s:password class="login" name="loginPassword"
							placeholder="ログインパスワード" />
						<s:submit value="ログイン" />
					</s:form>
				</div>
				<br />
				<div id="text-link">
					<a href='<s:url action="UserCreateAction" />' class="square_btn">新規ユーザー登録へ</a>
					<a href='<s:url action="GoHomeAction" />' class="square_btn">Homeへ</a>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>