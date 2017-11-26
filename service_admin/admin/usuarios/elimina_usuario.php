<?php
include('../conexion.php');
$id = $_POST['id'];
if (!$dbconfig->query("DELETE FROM usuarios WHERE idUsuario = '$id'")) {
  echo '<script> alert("Este registro no se puede borrar porque esta siendo utilizado por el sistema.");</script>';
}
$registro = $dbconfig->query("SELECT * FROM usuarios ORDER BY idUsuario ASC");

echo '<table class="table table-striped table-condensed table-hover table-responsive">
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