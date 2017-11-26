
<?php
include('../conexion.php');

$id = $_POST['id-registro'];
$proceso = $_POST['pro'];
$nombre = $_POST['servicio'];
$descripcion = $_POST['descripcion'];
$imagen = $_POST['imagen'];
$categoria= $_POST['categoria'];
$puntuacion = $_POST['puntuacion'];
$precio = $_POST['precio'];
$estado = $_POST['estado'];
$observaciones = $_POST['observaciones'];

switch($proceso){
	case 'Registro': $dbconfig->query("INSERT INTO servicios (NombreServicio, DescripcionServicio, ImagenServicio, idCategoria, puntuacion, PrecioBase, estadoS, observacionesC) VALUES('$nombre','$descripcion','$imagen','$categoria','$puntuacion','$precio','$estado','$observaciones')");

	break;
	case 'Edicion': $dbconfig->query("UPDATE servicios SET NombreServicio = '$nombre', DescripcionServicio = '$descripcion', ImagenServicio = '$imagen', idCategoria = '$categoria', puntuacion = '$puntuacion', PrecioBase = '$precio', estadoS = '$estado', observacionesC = '$observaciones' where idAfiliado = '$id'"); 
	break;
   }
    $registro = $dbconfig->query("select servicios.idServicio as id, servicios.NombreServicio  as servicio, servicios.DescripcionServicio  as descripcion, servicios.ImagenServicio as imagen,categorias.nombreCategoria  as categoria, servicios.puntuacion as puntuacion, servicios.precioBase as precio,
servicios.estados as estado, servicios.observacionesC as observaciones  
from servicios inner join categorias on servicios.idCategoria =categorias.idCategoria");

    echo '<table class="table table-striped table-condensed table-hover">
        	          <tr>
                         <th width="20%">Servicio</th>
                         <th width="10%">Descripcion</th>
                         <th width="20%">Imagen</th>
                         <th width="10%">Categoria</th>
                         <th width="10%">Puntuacion</th>
                          <th width="10%">Precio</th>
                         <th width="10%">Estado</th>
                         <th width="10%">Observaciones</th>
                         <th width="10%">Opciones</th>
                     </tr>';    
	while($registro2 = mysqli_fetch_array($registro)){
		echo '<tr>
                        <td>'.$registro2['servicio'].'</td>
                              <td>'.$registro2['descripcion'].'</td>
                                <td>'.$registro2['imagen'].'</td>
                                <td>'.$registro2['categoria'].'</td>
                                 <td>'.$registro2['puntuacion'].'</td>
                                <td>'.$registro2['precio'].'</td>
                                 <td>'.$registro2['estado'].'</td>
                                <td>'.$registro2['observaciones'].'</td>
                               <td> <a href="javascript:editarRegistro('.$registro2['id'].');">
                              <img src="../imagenes/editar.png" width="25" height="25" alt="delete" title="Editar" /></a>
                              <a href="javascript:eliminarRegistro('.$registro2['id'].');">
                              <img src="../imagenes/borrar.png" width="25" height="25" alt="delete" title="Eliminar" /></a>
                          </td>
				</tr>';
	}
   echo '</table>';
?>