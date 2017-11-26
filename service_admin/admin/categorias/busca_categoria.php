<?php
include('../conexion.php');
$dato = $_POST['dato'];

$instruccion = "SELECT * FROM categorias WHERE nombreCategoria LIKE '%$dato%' ORDER BY idCategoria ASC";
$consulta = $dbconfig->query($instruccion);
       echo '<table class="table table-striped table-condensed table-hover table-responsive">
        	<tr>
                          <th width="20%">Nombre</th>
                         <th width="30%">Descripcion</th>
                         <th width="10%">Estado</th>
                         <th width="30%">Observaciones</th>
                         <th width="10%">Opciones</th>
            </tr>';
      if(mysqli_num_rows($consulta)>0){
	     while($registro2 = mysqli_fetch_array($consulta)){
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
      }else{
      	echo '<tr>
      				<td colspan="5">No se encontraron resultados</td>
      			</tr>';
      }
      echo '</table>';
?>
