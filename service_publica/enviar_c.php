<?php
if
(isset($_POST['nombre']) && !empty($_POST['nombre']) &&
isset()($_POST(['correo']) && !empty($_POST['correo'])) &&
isset($_POST(['celular']) && !empty($_POST['celular'])) &&
isset($_POST(['mensaje']) && !empty($_POST['mensaje']))
{
	$destino = "whitebts77@outlook.es";
	$desde = "from:". "CodigoFacilito";
	$nombre = &_POST['nombre'];
	$correo = &_POST['correo'];
	$celular = &_POST['celular'];
	$mensaje = &_POST['mensaje'];
	mail($destino,$asunto,$mensaje,$desde);
	acho "Correo enviado...";
}else{
echo "problemas al enviar";
}
?>
