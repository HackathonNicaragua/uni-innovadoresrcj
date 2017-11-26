$(document).ready(pagination(1));
$(function(){
	$('#nuevo-producto').on('click',function(){
		$('#formulario')[0].reset();
		$('#pro').val('Registro');
		$('#edi').hide();
		$('#reg').show();
		$('#registra-datos').modal({
			show:true,
			backdrop:'static'
		});
	});	
	$('#bs-prod').on('keyup',function(){
		var dato = $('#bs-prod').val();
		var url = 'afiliados/busca_afiliado.php';
		$.ajax({
		type:'POST',
		url:url,
		data:'dato='+dato,
		success: function(datos){
			$('#agrega-registros').html(datos);
		}
	});
	return false;
	});	
});

//funcion para agregar Registro
function agregarRegistro(){
	var url = 'afiliados/agrega_afiliado.php';
	$.ajax({
		type:'POST',
		url:url,
		data:$('#formulario').serialize(),
		success: function(registro){
			if ($('#pro').val() == 'Registro'){
			$('#formulario')[0].reset();
			swal("¡Registro Agregado Correctamente!", "Has agregado un Registro nuevo al Sistema Uniservices Online", "success");
			$('#agrega-registros').html(registro);
			return false;
			}else{
			swal("¡Registro Editado Correctamente!", "Has editado el Registro del Sistema Uniservices Online", "success");
			$('#agrega-registros').html(registro);
			return false;
			}
		}
	});
	return false;
}
//funcion para eliminar Registro
function eliminarRegistro(id){
	swal({   
        title: "Eliminacion de Registro",   
        text: "Desea eliminar este Registro ?",   
        type: "warning",   
        showCancelButton: true,   
        confirmButtonColor: "#DD6B55",   
        confirmButtonText: "Eliminar",   
        closeOnConfirm: true }, 
        function(){   
          var value = {
            id: id
          };
          $.ajax(
          {
            url : "afiliados/elimina_afiliado.php",
            type: "POST",
            data : value,
            success: function(registro)
            {
              $('#agrega-registros').html(registro);
			return false;

            },
            error: function(registro)
            {
             swal("Error!", "Error al Borrar", "error");
            }
          });
        });
}

swal({   
        title: "Delete Cust?",   
        text: "Delete Cust : "+name+" ?",   
        type: "warning",   
        showCancelButton: true,   
        confirmButtonColor: "#DD6B55",   
        confirmButtonText: "Delete",   
        closeOnConfirm: true }, 
        function(){   
          var value = {
            id_cust: id_cust
          };
          $.ajax(
          {
            url : "delete.php",
            type: "POST",
            data : value,
            success: function(data, textStatus, jqXHR)
            {
              var data = jQuery.parseJSON(data);
              if(data.result ==1){
                $.notify('Successfull delete customer');
                var table = $('#table_cust').DataTable(); 
                table.ajax.reload( null, false );
              }else{
                swal("Error","Can't delete customer data, error : "+data.error,"error");
              }

            },
            error: function(jqXHR, textStatus, errorThrown)
            {
             swal("Error!", textStatus, "error");
            }
          });
        });
//funcion para modificar Registro
function editarRegistro(id){
	$('#formulario')[0].reset();
	var url = 'afiliados/edita_afiliado.php';
		$.ajax({
		type:'POST',
		url:url,
		data:'id='+id,
		success: function(valores){
				var datos = eval(valores);
				$('#reg').hide();
				$('#edi').show();
				$('#pro').val('Edicion');
				$('#id-registro').val(id);
				$('#nombres').val(datos[0]);
				$('#apellidos').val(datos[1]);
				$('#cedula').val(datos[2]);
				$('#telefono').val(datos[3]);
				$('#correo').val(datos[4]);
				$('#estado').val(datos[5]);
				$('#observaciones').val(datos[6]);
				$('#registra-datos').modal({
					show:true,
					backdrop:'static'
				});
			return false;
		}
	});
	return false;
}
//funcion para paginar los Registro
function pagination(partida){
	var url = 'afiliados/paginar_afiliado.php';
	$.ajax({
		type:'POST',
		url:url,
		data:'partida='+partida,
		success:function(data){
			var array = eval(data);
			$('#agrega-registros').html(array[0]);
			$('#pagination').html(array[1]);
		}
	});
	return false;
}