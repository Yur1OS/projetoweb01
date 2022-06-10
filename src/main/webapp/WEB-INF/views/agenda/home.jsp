<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COTI Inform�tica - Agenda</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<div class="container mb-2">
		<h3>AGENDA DE COMPROMISSOS</h3>
		<h5>Seja bem vindo ao sistema!</h5>
	<hr />
	</div>
	<div class="container mb-2">
		Usu�rio autenticado: <strong> ${usuario_autenticado.nome} </strong> <br>
		Email: <strong> ${usuario_autenticado.email} </strong>
	</div>
	<div class="container mt-2">
		<a href="/projetoweb01/logout" class="btn btn-outline-secondary btn-sm" onclick="return confirm('Deseja encerrar a sess�o ? ');">
		Sair do Sistema </a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
