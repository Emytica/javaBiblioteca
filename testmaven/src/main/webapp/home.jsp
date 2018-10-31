<%@page import="it.corsojava.testmaven.vo.UtenteVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="general.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/general.css" rel="stylesheet">
<link href="css/homeUser.css" rel="stylesheet">
<title>Home Page</title>
</head>
<body>


	<c:choose>
		<c:when test="${utenteLoggato.nome.equalsIgnoreCase('rosario')}">
			<form action="ViewServlet" method="post">
				<input type="text" name="nome" placeholder="Titolo libro"> <input
					type="text" name="autore" placeholder="Autore libro"><br>
				<input type="text" name="isbn" placeholder="Isbn"> <input
					type="text" name="disp" placeholder="Disponibile"> <input
					type="submit" value="invia">
			</form>
		</c:when>
		<c:otherwise>
			<div id="content">
				<div id="id1">
					<a href="">Storico noleggi.</a>
					<div class="contimg">
						<img alt="" src="img/storico noleggi.png">
					</div>
				</div>
				<div id="id2">
					<a href="noleggio">Noleggia Libro. / Cerca.</a>
					<div class="contimg">
						<img alt="" src="img/ricerca libri.png">
					</div>
				</div>
				<div id="id3">
					<a href="">Restituisci libro.</a>
					<div class="contimg">
						<img alt="" src="img/Restituisci libro.png">
					</div>
				</div>
			</div>
		</c:otherwise>

	</c:choose>
	<!-- 
	<c:forEach var="obj" items="${lista}">
	${obj.name}
	</c:forEach>
	Pearson is : ${pearson.name}
	 -->

</body>
</html>