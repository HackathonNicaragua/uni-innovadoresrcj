
<?php
include('../conexion.php');

$id = $_POST['id-registro'];
$proceso = $_POST['pro'];
$nombre = $_POST['nombres'];
$apellido = $_POST['apellidos'];
$cedula = $_POST['cedula'];
$correo = $_POST['correo'];
$telefono = $_POST['telefono'];
$estado = $_POST['estado'];
$observaciones = $_POST['observaciones'];

switch($proceso){
	case 'Registro': $dbconfig->query("INSERT INTO servicios (NombreServicio, DescripcionServicio, ImagenServicio, idCategoria, puntuacion, PrecioBase estadoS, observacionesC) VALUES('$nombre','$apellido','$cedula','$telefono','$correo','$estado','$observaciones')");

	break;
	case 'Edicion': $dbconfig->query("UPDATE servicios SET nombresA = '$nombre', apellidosA = '$apellido', cedulaA = '$cedula', telefonoA = '$telefono', correoA = '$correo', estadoA = '$estado', observacionesA = '$observaciones' where idAfiliado = '$id'"); 
	break;
   }
    $registro = $dbconfig->query("SELECT * FROM afiliados ORDER BY idAfiliado ASC");

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