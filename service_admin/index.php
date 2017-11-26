<?php
session_start();
include 'admin/conexion.php';

if(isset($_SESSION['user'])) {
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
    <link rel="shortcut icon" href="../imagenes/logoUNI.ico" type="image/x-icon">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/estilo.css" rel="stylesheet">
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.js"></script>
    <script src="js/back-to-top1.js"></script>
    <script src="js/bootstrap.js"></script>
      <link href="css/sweetalert.css" rel="stylesheet">
    <script src="js/sweetalert.min.js"></script>

</head>
<body>
        <?php include ('includes/menu.php'); ?>   <!-- Menu -->
       <br><br><br>
        <div class="container">
            <div class="row">
              <!-- Parte Superior -->
                <div class="col-lg-12">
                        <div class="col-md-3"><img src="imagenes/logo.png" width="80" height="80" class="img-responsive"></div>
                             <div class="col-md-6">                      
                               <h2>Sistema Administrativo Uniservices</h2>                   
                        </div>
                        <div class="col-md-3">
                      <h5><i class="fa fa-circle fa-stack-1x fa-inverse" style="color:green; text-align: left; "></i><b> &nbsp; Online: </b>Juan Perez</h5>
                        </div> 
                </div>
        </div>
        <!-- Contenido Central -->
   <hr>
        <div class="row">
                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/afiliados.jpg" class="img-fluid" alt="afiliados">
                                <a href="admin/afiliados.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--Afiliados-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Mantenimientos de los Afiliados.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/afiliados.php" class="btnHover botonNaranja">Ir ala Pagina</a>
                            </div>
                        </div>
                    </div> 

                     <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/clientes.jpg" class="img-fluid" alt="">
                                <a href="admin/clientes.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--Clientes-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Mantenimientos de los Clientes.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/clientes.php" class="botonNaranja">Ir ala Pagina</a>
                            </div>
                        </div>
                    </div> 
                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/clientes.jpg" class="img-fluid" alt="">
                                <a href="admin/servicios.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--Servicios-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Mantenimientos de los Servicios.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/servicios.php" class="botonNaranja">Ir ala Pagina</a>
                            </div>
                        </div>
                    </div> 
                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/categorias.jpg" class="img-fluid" alt="">
                                <a href="#">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--categorias-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Mantenimientos de las Categorias.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/categorias.php" class="botonNaranja">Ir a la Pagina</a>
                            </div>
                        </div>
                    </div> 
                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/estadisticas.jpg" class="img-fluid" alt="">
                                <a href="admin/usuarios.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--usuarios-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Mantenimientos de los Usuarios.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/usuarios.php" class="botonNaranja">Ir a la Pagina</a>
                            </div>
                        </div>
                    </div> 
                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/estadisticas.jpg" class="img-fluid" alt="">
                                <a href="admin/estadisticas.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--Estadisticas-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Estadisticas del Sistema.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/estadisticas.php" class="botonNaranja">Ir a la Pagina</a>
                            </div>
                        </div>
                    </div> 
                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/reportes.jpg" class="img-fluid" alt="">
                                <a href="admin/reportes.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--Reportes-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Reportes del Sistema.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/reportes.php" class="botonNaranja">Ir a la Pagina</a>
                            </div>
                        </div>
                    </div> 

                      <div class="col-md-3">
                         <div class="card">
                            <!--Imagen-->
                            <div class="view overlay hm-white-slight hm-zoom hoverable">
                                <img src="imagenes/categorias.jpg" class="img-fluid" alt="">
                                <a href="admin/subcategorias.php">
                                    <div class="mask waves-effect waves-light"></div>
                                </a>
                            </div>

                            <!--Subcategorias-->
                            <div class="card-body">
                                <p class="cantidadRegistros">Total Registros: 34</p>
                                <p class="card-text text-truncate">Mantenimientos de los clientes.</p>
                                <h5 class="card-title">Realizacion de todas las operaciones que se pueden realizar en un sistema</h5>
                                <a href="admin/subcategorias.php" class="botonNaranja">Ir a la Pagina</a>
                            </div>
                        </div>
                    </div> 
        </div>

        <!-- Final del Contenido Central -->
    </div>
    <?php
    include('includes/footer.php');
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