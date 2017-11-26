<?php
include('../conexion.php');
$dato = $_POST['dato'];

$instruccion = "SELECT * FROM clientes WHERE nombresC LIKE '%$dato%' ORDER BY idCliente ASC";
$consulta = $dbconfig->query($instruccion);
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
      if(mysqli_num_rows($consulta)>0){
	     while($registro2 = mysqli_fetch_array($consulta)){
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
      }else{
      	echo '<tr>
      				<td colspan="8">No se encontraron resultados</td>
      			</tr>';
      }
      echo '</table>';
?>
