<?php
include('../conexion.php');
$dato = $_POST['dato'];

$instruccion = "SELECT * FROM usuarios WHERE nombreCompleto LIKE '%$dato%' ORDER BY idUsuario ASC";
$consulta = $dbconfig->query($instruccion);
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
      if(mysqli_num_rows($consulta)>0){
	     while($registro2 = mysqli_fetch_array($consulta)){
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
      }else{
      	echo '<tr>
      				<td colspan="8">No se encontraron resultados</td>
      			</tr>';
      }
      echo '</table>';
?>
