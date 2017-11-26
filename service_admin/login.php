<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Uniservices.Online</title>
      <link rel="stylesheet" href="css/bootstrap.css"> 
      <link rel="stylesheet" href="css/estilo.css"> 
</head>

<body>
 <div class="container">
     <div class="col-md-6 card" style="margin-top: 10%; margin-left: 25%; ">
         <div style="text-align: center; padding: 10px;">
          <img class="img img-responsive" src="imagenes/logouniservicios.png" alt="logo Uniservices"> 
         </div>
        <form class="form-signin" action="includes/validarLogin.php" method="post">
          <h2 class="form-signin-heading" style="text-align: center;">Inicio de Sesion</h2> <br>
          <label for="Usuario" class="sr-only">Usuario</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required='true' autofocus> <br>
          <label for="Password" class="sr-only">Password</label>
          <input type="password" id="pass" name="pass" class="form-control" placeholder="Contraseña" required='true'>
          <div class="checkbox">
            <label>
              <input type="checkbox" value="recordarme">Recordarme
            </label>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button> <br>
        </form>
      </div>
    </div> <!-- /contenedor -->

</body>
</html>