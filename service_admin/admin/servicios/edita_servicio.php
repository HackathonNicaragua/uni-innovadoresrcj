<?php
include('../conexion.php');
$id = $_POST['id'];
$valores = $dbconfig->query("SELECT * FROM afiliados WHERE idAfiliado = '$id'");
$valores2 = mysqli_fetch_array($valores);
$datos = array(
				 
				0 => $valores2['nombresA'], 
			    1 => $valores2['apellidosA'], 
				2 => $valores2['cedulaA'], 
				3 => $valores2['telefonoA'], 
				4 => $valores2['correoA'], 
				5 => $valores2['estadoA'], 
			    6 => $valores2['observacionesA'], 
				); 
echo json_encode($datos);
?>