
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
	case 'Registro': $dbconfig->query("INSERT INTO afiliados (nombresA, apellidosA, cedulaA, telefonoA, correoA, estadoA, observacionesA) VALUES('$nombre','$apellido','$cedula','$telefono','$correo','$estado','$observaciones')");

	break;
	case 'Edicion': $dbconfig->query("UPDATE afiliados SET nombresA = '$nombre', apellidosA = '$apellido', cedulaA = '$cedula', telefonoA = '$telefono', correoA = '$correo', estadoA = '$estado', observacionesA = '$observaciones' where idAfiliado = '$id'"); 
	break;
   }
    $registro = $dbconfig->query("SELECT * FROM afiliados ORDER BY idAfiliado ASC");

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
                         <td>'.$registro2['nombresA'].'</td>
                            <td>'.$registro2['apellidosA'].'</td>
                            <td>'.$registro2['cedulaA'].'</td>
                             <td>'.$registro2['telefonoA'].'</td>
                            <td>'.$registro2['correoA'].'</td>
                             <td>'.$registro2['estadoA'].'</td>
                            <td>'.$registro2['observacionesA'].'</td>
                           <td> <a href="javascript:editarRegistro('.$registro2['idAfiliado'].');">
                          <img src="../imagenes/editar.png" width="25" height="25" alt="delete" title="Editar" /></a>
                          <a href="javascript:eliminarRegistro('.$registro2['idAfiliado'].');">
                          <img src="../imagenes/borrar.png" width="25" height="25" alt="delete" title="Eliminar" /></a>
                      </td>
				</tr>';
	}
   echo '</table>';
?>