
<?php
//$host = 'uniservices.online';
//$username = 'uniserv_uniserv';
//$password = '1OxhVkzW3I';
//$database = 'uniserv_BD';

//$dbconfig =  mysqli_connect($host,$username,$password,$database);
//$dbconfig->query("SET NAMES 'utf8'");

//if ($dbconfig->connect_error) {
//    die("Error de conexion: " . $dbconfig->connect_error);
//}
?>


<?php
$host = 'localhost';
$username = 'root';
$password = '';
$database = 'uniserv_BD';

$dbconfig =  mysqli_connect($host,$username,$password,$database);
$dbconfig->query("SET NAMES 'utf8'");

if ($dbconfig->connect_error) {
    die("Error de conexion: " . $dbconfig->connect_error);
}
?>


