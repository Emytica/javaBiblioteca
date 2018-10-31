<%@page import="it.corsojava.testmaven.vo.LibriVo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/index.css">
<title>Benvenuto in biblioteca</title>
</head>
<body>

	<h1 id="titolo">Benvenuto in biblioteca!!</h1>


	<form action="login" method="post">
		<table>

			<tr>
				<td><input class="daites" type="text" name="username"
					placeholder="Username"></td>
			</tr>
			<tr>
				<td><input class="daites" type="password" name="password"
					placeholder="Password"></td>
			</tr>

			<tr>
				<td><input class="submit" type="submit" value="Loggati"></td>
			</tr>


		</table>
		<p>
			<a href="">Sei nuovo? Registrati!!</a>
		</p>
		<p>
			<a href="">Password dimenticata?</a>
		</p>
	</form>





</body>
</html>
