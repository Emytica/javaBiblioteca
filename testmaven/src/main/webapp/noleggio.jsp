<%@page import="it.corsojava.testmaven.vo.LibriVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="general.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Noleggio</title>
<link href="css/noleggio.css" rel="stylesheet">
</head>
<body>

	<div>
		<form class="cerca" action="" method="get">

			<label class="cata">Cerca Libro :</label> <input class="cercacom"
				type="search" name="titolo" placeholder="Cerca per titolo">
			<input class="submit" type="submit" value="Cerca">

		</form>
		<div id="catalogo">

			<p class="cata">Catalogo libri :</p>
			<table>
				<thead>
					<tr>
						<th>Nome Libro</th>
						<th>Autore Libro</th>
						<th>Isbn Libro</th>
						<th>Disponibilità</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${libri}" var="lib">

						<tr>
							<td>${lib.nome}</td>
							<td>${lib.autore}</td>
							<td>${lib.isbn}</td>
							<td>${lib.disponibilita}</td>
							<td>
								<form action="out?libroid=${lib.id}" method="get">
									<input class="submit" name="id" type="submit" value="Noleggia">
								</form>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>



		</div>
	</div>

</body>
</html>