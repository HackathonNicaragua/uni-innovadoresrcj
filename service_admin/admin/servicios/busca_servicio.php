<?php
include('../conexion.php');
$dato = $_POST['dato'];

$instruccion = "select servicios.idServicio as id, servicios.NombreServicio  as servicio, servicios.DescripcionServicio  as descripcion, servicios.ImagenServicio as imagen,categorias.nombreCategoria  as categoria, servicios.puntuacion as puntuacion, servicios.precioBase as precio,
servicios.estados as estado, servicios.observacionesC as observaciones  
from servicios inner join categorias on servicios.idCategoria =categorias.idCategoria where servicios.NombreServicio LIKE '%$dato%'
  order by servicios.idServicio asc";
$consulta = $dbconfig->query($instruccion);
       echo '<table class="table table-striped table-condensed table-hover table-responsive">
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
      if(mysqli_num_rows($consulta)>0){
	     while($registro2 = mysqli_fetch_array($consulta)){
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
      }else{
      	echo '<tr>
      				<td colspan="8">No se encontraron resultados</td>
      			</tr>';
      }
      echo '</table>';
?>
