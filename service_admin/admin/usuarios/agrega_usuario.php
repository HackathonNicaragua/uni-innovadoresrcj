
<?php
include('../conexion.php');

$id = $_POST['id-registro'];
$proceso = $_POST['pro'];
$nombre = $_POST['nombres'];
$email = $_POST['email'];
$user = $_POST['user'];
$pass = $_POST['pass'];
$token = $_POST['token'];
$nivel = $_POST['nivel'];
$estado = $_POST['estado'];
$observaciones = $_POST['observaciones'];

switch($proceso){
	case 'Registro': $dbconfig->query("INSERT INTO usuarios (nombreCompleto, email, user, pass, token, nivel, estadoU, observacionesC) VALUES('$nombre','$email','$user','$pass','$token','$nivel','$estado','$observaciones')");

	break;
	case 'Edicion': $dbconfig->query("UPDATE usuarios SET nombreCompleto = '$nombre', email = '$email', user = '$user', pass = '$pass', token = '$token', nivel = '$nivel', estadoU = '$estado', observacionesA = '$observaciones' where idAfiliado = '$id'"); 
	break;
   }
    $registro = $dbconfig->query("SELECT * FROM usuarios ORDER BY idUsuario ASC");

    echo '<table class="table table-striped table-condensed table-hover">
        	          <tr>
                            <th width="20%">Nombre</th>
                         <th width="10%">Email</th>
                         <th width="10%">User</th>
                         <th width="10%">Pass</th>
                         <th width="10%">Token</th>
                          <th width="10%">Nivel</th>
                         <th width="10%">Estado</th>
                         <th width="10%">Observaciones</th>
                         <th width="10%">Opciones</th>
                     </tr>';    
	while($registro2 = mysqli_fetch_array($registro)){
		echo '<tr>
                        <td>'.$registro2['nombreCompleto'].'</td>
                                <td>'.$registro2['email'].'</td>
                                <td>'.$registro2['user'].'</td>
                                 <td>'.$registro2['pass'].'</td>
                                <td>'.$registro2['token'].'</td>
                                 <td>'.$registro2['nivel'].'</td>
                                 <td>'.$registro2['estadoU'].'</td>
                                <td>'.$registro2['observacionesC'].'</td>
                               <td> <a href="javascript:editarRegistro('.$registro2['idUsuario'].');">
                              <img src="../imagenes/editar.png" width="25" height="25" alt="delete" title="Editar" /></a>
                              <a href="javascript:eliminarRegistro('.$registro2['idUsuario'].');">
                              <img src="../imagenes/borrar.png" width="25" height="25" alt="delete" title="Eliminar" /></a>
                          </td>
				</tr>';
	}
   echo '</table>';
?>