<?php
include('../conexion.php');
$id = $_POST['id'];
if (!$dbconfig->query("DELETE FROM categorias WHERE idCategoria = '$id'")) {
  echo '<script> alert("Este registro no se puede borrar porque esta siendo utilizado por el sistema.");</script>';
}
$registro = $dbconfig->query("SELECT * FROM categorias ORDER BY idCategoria ASC");

echo '<table class="table table-striped table-condensed table-hover table-responsive">
        	          <tr>
                       <th width="20%">Nombre</th>
                         <th width="30%">Descripcion</th>
                         <th width="10%">Estado</th>
                         <th width="30%">Observaciones</th>
                         <th width="10%">Opciones</th>
                   </tr>';
	while($registro2 = mysqli_fetch_array($registro)){
		        echo '<tr>
		                      <td>'.$registro2['nombreCategoria'].'</td>
                            <td>'.$registro2['DescripcionCategoria'].'</td>
                             <td>'.$registro2['estado'].'</td>
                            <td>'.$registro2['observacionesC'].'</td>
                           <td> <a href="javascript:editarRegistro('.$registro2['idCategoria'].');">
                          <img src="../imagenes/editar.png" width="25" height="25" alt="delete" title="Editar" /></a>
                          <a href="javascript:eliminarRegistro('.$registro2['idCategoria'].');">
                          <img src="../imagenes/borrar.png" width="25" height="25" alt="delete" title="Eliminar" /></a>
                      </td>
			         	</tr>';
	}
echo '</table>';
?>