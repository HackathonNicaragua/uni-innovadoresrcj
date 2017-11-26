<?php
include('../conexion.php');
$id = $_POST['id'];
if (!$dbconfig->query("DELETE FROM afiliados WHERE idAfiliado = '$id'")) {
  echo '<script> alert("Este registro no se puede borrar porque esta siendo utilizado por el sistema.");</script>';
}
$registro = $dbconfig->query("SELECT * FROM afiliados ORDER BY idAfiliado ASC");

echo '<table class="table table-striped table-condensed table-hover table-responsive">
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