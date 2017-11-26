
<?php session_start(); ?>

		<?php
			include '../admin/conexion.php';
		 
		 $user = mysqli_real_escape_string($dbconfig, $_POST['username']);
		 $pass=mysqli_real_escape_string($dbconfig,$_POST['pass']);

				$log = $dbconfig->query("SELECT * FROM usuarios WHERE user='$user' AND pass='$pass'");
				if (mysqli_num_rows($log)>0) {
					$row = mysqli_fetch_array($log);
					$_SESSION["user"] = $row['user']; 
				  	$_SESSION["nivel"] = $row['nivel']; 
				  	if ($_SESSION["nivel"] == admin) {
				  		echo '<script> alert("Bienvenido al Sistema ");</script>';
				  		echo '<script> window.location="../index.php"; </script>';
				  	}
				}
				else{
					echo '<script> alert("Usuario o contraseña incorrectos. ");</script>';
					echo '<script> window.location="../login.php"; </script>';
				}
		?>	