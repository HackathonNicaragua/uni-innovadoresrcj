<?php
include('../conexion.php');
$id = $_POST['id'];
$valores = $dbconfig->query("SELECT * FROM clientes WHERE clientes = '$id'");
$valores2 = mysqli_fetch_array($valores);
$datos = array(
				 
				0 => $valores2['nombresC'], 
			    1 => $valores2['apellidosC'], 
				2 => $valores2['cedulaC'], 
				3 => $valores2['telefonoC'], 
				4 => $valores2['correoC'], 
				5 => $valores2['estadoC'], 
			    6 => $valores2['observacionesC'], 
				); 
echo json_encode($datos);
?>