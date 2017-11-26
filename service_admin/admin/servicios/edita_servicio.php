<?php
include('../conexion.php');
$id = $_POST['id'];
$valores = $dbconfig->query("SELECT * FROM servicios WHERE idServicio= '$id'");
$valores2 = mysqli_fetch_array($valores);
$datos = array(
				 
				0 => $valores2['NombreServicio'], 
			    1 => $valores2['DescripcionServicio'], 
				2 => $valores2['ImagenServicio'], 
				3 => $valores2['idCategoria'], 
				4 => $valores2['puntuacion'], 
				5 => $valores2['PrecioBase'],
				6 => $valores2['estadoS'],  
			    7 => $valores2['observacionesC'], 
				); 
echo json_encode($datos);
?>