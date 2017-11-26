<?php
include('../conexion.php');
$id = $_POST['id'];
$valores = $dbconfig->query("SELECT * FROM categorias WHERE idCategoria= '$id'");
$valores2 = mysqli_fetch_array($valores);
$datos = array(
				 
				0 => $valores2['nombreCategoria'], 
			    1 => $valores2['DescripcionCategoria'], 
				2 => $valores2['estado'], 
			    3 => $valores2['observacionesC'], 
				); 
echo json_encode($datos);
?>