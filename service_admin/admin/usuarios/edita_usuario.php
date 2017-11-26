<?php
include('../conexion.php');
$id = $_POST['id'];
$valores = $dbconfig->query("SELECT * FROM usuarios WHERE idUsuario = '$id'");
$valores2 = mysqli_fetch_array($valores);
$datos = array(
				 
				0 => $valores2['nombreCompleto'], 
			    1 => $valores2['email'], 
				2 => $valores2['user'], 
				3 => $valores2['pass'], 
				4 => $valores2['token'], 
				5 => $valores2['nivel'], 
				6 => $valores2['estadoU'], 
			    7 => $valores2['observacionesC'], 
				); 
echo json_encode($datos);
?>