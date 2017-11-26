
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
	case 'Registro': $dbconfig->query("INSERT INTO clientes (nombresC, apellidosC, cedulaC, telefonoC, correoC, estadoC, observacionesC) VALUES('$nombre','$apellido','$cedula','$telefono','$correo','$estado','$observaciones')");

	break;
	case 'Edicion': $dbconfig->query("UPDATE clientes SET nombresC = '$nombre', apellidosC = '$apellido', cedulaC = '$cedula', telefonoC = '$telefono', correoC = '$correo', estadoC = '$estado', observacionesC = '$observaciones' where idCliente = '$id'"); 
	break;
   }
    $registro = $dbconfig->query("SELECT * FROM clientes ORDER BY idCliente ASC");

    echo '<table class="table table-striped table-condensed table-hover">
        	          <tr>
                         <th width="20%">Nombre</th>
                         <th width="10%">Apellido</th>
                         <th width="20%">Cedula</th>
                         <th width="10%">Telefono</th>
                         <th width="10%">Correo</th>
                         <th width="10%">Estado</th>
                         <th width="10%">Observaciones</th>
                         <th width="10%">Opciones</th>
                     </tr>';    
	while($registro2 = mysqli_fetch_array($registro)){
		echo '<tr>
                         <td>'.$registro2['nombresC'].'</td>
                            <td>'.$registro2['apellidosC'].'</td>
                            <td>'.$registro2['cedulaC'].'</td>
                             <td>'.$registro2['telefonoC'].'</td>
                            <td>'.$registro2['correoC'].'</td>
                             <td>'.$registro2['estadoC'].'</td>
                            <td>'.$registro2['observacionesC'].'</td>
                           <td> <a href="javascript:editarRegistro('.$registro2['idCliente'].');">
                          <img src="../imagenes/editar.png" width="25" height="25" alt="delete" title="Editar" /></a>
                          <a href="javascript:eliminarRegistro('.$registro2['idCliente'].');">
                          <img src="../imagenes/borrar.png" width="25" height="25" alt="delete" title="Eliminar" /></a>
                      </td>
				</tr>';
	}
   echo '</table>';
?>