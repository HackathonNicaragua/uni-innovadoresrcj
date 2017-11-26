<?php
session_start();
include 'conexion.php';

if(isset($_SESSION['user'])) {
        ?>

        <?php
         $consulta3="select idCategoria, nombreCategoria from categorias";
          $categorias=$dbconfig->query($consulta3);

        ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Uniservices</title>
    <link rel="shortcut icon" href="../imagenes/icono.ico" type="image/x-icon">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/estilo.css" rel="stylesheet">
    <link href="../css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.js"></script>
    <script src="../js/back-to-top.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="servicios/myjava.js"></script>

        <link href="../css/sweetalert.css" rel="stylesheet">
       <script src="../js/sweetalert.min.js"></script>
</head>
<body>
        <?php include ('../includes/menu.php'); ?>   <!-- Menu -->
       <br><br><br>
        <div class="container">
            <div class="row">
              <!-- Parte Superior -->
                <div class="col-lg-12">
                  <div class="col-md-3"><img src="../imagenes/logouniservicios.png" width="150" height="100" class="img-responsive"></div>
                             <div class="col-md-6">                      
                               <h2>Sistema Administrativo Uniservices</h2>                   
                        </div>
                        <div class="col-md-3">
                      <h5><i class="fa fa-circle fa-stack-1x fa-inverse" style="color:green; text-align: left; "></i><b> &nbsp; Online: </b>Juan Perez</h5>
                        </div> 
                </div>
            </div>

           <div class="col-lg-12">              
                <ol class="breadcrumb">
                    <li><a href="../index.php">Inicio</a>
                    </li>
                    <li class="active">Servicios</li>
                </ol>
            </div>

        <!-- Contenido Central -->
        <hr>
                <div class="row">
            <!-- Content Column -->
            <div class="col-md-9">
                <div class="container">
      <div class="panel panel-primary">
        <div class="panel-heading">
            <div class="btn-group pull-right">
            </div>
            <center><h4><b>Administracion de Servicios</b></h4></center>
        </div>
        <div class="panel-body">
            <div class="row">
                   <div class="col-md-1"><h4>Buscar:</h4></div>
                   <div class="col-md-5">
                   <input type="text" name="s" id="bs-prod" class="form-control" placeholder="Escribir el nombre del Servicio">
                   </div>
                    <div class="col-md-6">
                      <button id="nuevo-producto" class="botonOscuro"> <i class="glyphicon glyphicon-plus"></i> Nuevo Servicio</button> 
                      <a href="#"> <button class="botonNaranja"><i class="fa fa-file-pdf-o"></i>  Exportar Listado a PDF</button> </a>
                   </div>
                <br>
 <br>
    <div class="registros" style="width:100%;" id="agrega-registros"></div>
      <div class="col-md-6" style="text-align: left;">
        <center>
            <ul class="pagination" id="pagination"></ul>
        </center>
      </div>
      <div class="col-md-6">
       <center>
       <h4 style="font-weight: bold;"> 
    <?php
   include('conexion.php');
   $numeroRegistros = mysqli_num_rows($dbconfig->query("SELECT * FROM servicios"));
   echo "Registros Totales: $numeroRegistros";
        ?>
        </h4>
          </center>
      </div>
   
  
    <!-- MODAL PARA EL REGISTRO-->
    <div class="modal fade" id="registra-datos" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header" style="background:#03A9F4; text-align: center;">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title" style="color:white;" id="myModalLabel"><b>
              <i class='glyphicon glyphicon-user'></i>&nbsp;&nbsp;Servicios</b></h4>
            </div>
            <form id="formulario" class="form-group" onsubmit="return agregarRegistro();">
            <div class="modal-body">

            <input type="text" class="form-control" required readonly id="id-registro" name="id-registro" readonly="readonly" style="visibility:hidden; height:5px;"/>

                 <div class="form-group"> <label for="codigo" class="col-md-2 control-label">Proceso:</label>
        <div class="col-md-10"><input type="text" class="form-control" required readonly id="pro" name="pro" hidden="true" /></div>
         </div> <br>

         <div class="form-group"> <label for="nombre" class="col-md-2 control-label">Servicio:</label>
        <div class="col-md-10"><input type="text" class="form-control" id="srvicio" name="servicio" required="true" maxlength="50"></div>
         </div><br>

          <div class="form-group"> <label for="nombre" class="col-md-2 control-label">Descripcion:</label>
        <div class="col-md-10"><input type="text" class="form-control" id="descripcion" name="descripcion" required="true" maxlength="50"></div>
         </div><br>

         <div class="form-group"> <label for="cedula" class="col-md-2 control-label">Imagen:</label>
        <div class="col-md-10"><input type="text" class="form-control" id="imagen" name="imagen" required="true" maxlength="16"></div>
         </div><br>

          <div class="form-group"> <label for="carrera" class="col-md-2 control-label">Categoria:</label>
                         <div class="col-md-10">
                       <select class="form-control" id="categoria" name="categoria">
                     <?php 
                          while($fila=mysqli_fetch_row($categorias)){
                          echo "<option value='".$fila['0']."'>".$fila['1']."</option>";
                          }
                          ?>
                      </select>
                       </div>
                    </div> <br>

        <div class="form-group"> <label for="correo" class="col-md-2 control-label">Puntuacion</label>
        <div class="col-md-10"><input type="number" class="form-control" id="puntuacion" name="puntuacion" required="true" maxlength="50"></div>
         </div><br>

        <div class="form-group"> <label for="correo" class="col-md-2 control-label">Precio:</label>
        <div class="col-md-10"><input type="emai" class="form-control" id="precio" name="precio" required="true" maxlength="50"></div>
         </div><br>

         <div class="form-group"> <label for="celular" class="col-md-2 control-label">Estado:</label>
        <div class="col-md-10">
           <select class="form-control" id="estado" name="estado" required="true">
                      <option value="1" selected="1">Activo</option>
                       <option value="0">Inactivo</option>
          </select>
        </div>
         </div><br>

         <div class="form-group"> <label for="observaciones" class="col-md-2 control-label">Observ.:</label>
        <div class="col-md-10">
           <textarea class="form-control" id="observaciones" name="observaciones" required="true" maxlength="200"></textarea></div>
           <br>
         </div><br><br><br><br><br>           
                 <div id="mensaje"></div>           
             </div>         
            <div class="modal-footer">
                <input type="submit" value="Registrar" class="botonOscuro" id="reg"/>
                <input type="submit" value="Editar" class="btn btn-warning"  id="edi"/>
            </div>
            </form>
          </div>
        </div>
      </div>
            </div>
        </div>
    </div>

            </div>
                    
        </div>
        <!-- Fin del Panel -->
      </div>
    </div>
</div>
</div>
        <hr>
    </div>
    </div>
    <?php
    include('../includes/footer.php');
 ?>
</body>
</html>
<?php
     }
     else{
        echo '<script> alert("No Tienes los permisos para acceder a esta pagina.");</script>';
         echo '<script> window.location="login.php"; </script>';
     }
?>
