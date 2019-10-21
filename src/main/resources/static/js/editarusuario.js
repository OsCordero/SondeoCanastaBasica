$(document).ready(function(){
	
});
		
$(document).on("submit", "#form-editar-usuario", function(e) {
	e.preventDefault();
	
	axios.get("/todosusuariosajax")
	.then(response => {
		
		console.log(response);
		
		// Validaciones
		
		var txt_idusuario = $("#form-editar-usuario input[name=idUsuario]").val();
		
		var txt_nombre = $("#form-editar-usuario input[name=nombre]").val();
		
		var txt_username = $("#form-editar-usuario input[name=username]").val();
		var txt_username_error = false;
		
		var txt_correo = $("#form-editar-usuario input[name=correo]").val();
		var txt_correo_error = false;
		
		var txt_password = $("#form-editar-usuario input[name=password]").val();
		var txt_password_error = false;
		
		var txt_rol = $("#form-editar-usuario select[name=rol_add] option:selected").val();
		
		$("#error_username").html("");
		$("#error_correo").html("");
		$("#error_password").html("");
		
		var error_general = false;
		
		response.data.forEach(function(element) {
			if (txt_idusuario != element.idUsuario) {
				if (element.username == txt_username) {
					txt_username_error = true;
					error_general = true;
					$("#error_username").html($("#error_username").html() + "Ya existe registrado esté nombre de usuario, por favor pruebe con otro.");
				}
		            	
				if (element.correo == txt_correo) {
					txt_correo_error = true;
					error_general = true;
					$("#error_correo").html($("#error_correo").html() + "Ya existe registrado esté correo, por favor pruebe con otro.");
				}
			}
		});
		
		if (txt_password.length > 0) {
			if (txt_password.length < 6) {
				error_general = true;
				$("#error_password").html($("#error_password").html() + "La contraseña debe tener al menos 6 caracteres.");
			}	
		}
		
		if (!error_general) {
			$("#error_username").html("");
			$("#error_correo").html("");
			$("#error_password").html("");
			
			var params = {
					"idUsuario":  txt_idusuario,
					"nombre":  txt_nombre,
					"username":  txt_username,
					"correo":  txt_correo,
					"password":  txt_password,
					"rol_add":  txt_rol,
			};
			
			console.log(params);
			
			var url = $(this).attr("action");
			console.log(url);
			
			var data = $(this).serialize();
			console.log(data);
			
			axios.get(url, {
				
				params: params
				
			}).then(responsee => {
				
				console.log(responsee);
				
                // Mostrar mensaje de éxito de que todo ha sido registrado
                Swal.fire({
                    type: 'success',
                    title: 'Usuario:',
                    text: 'Editado con éxito!:',
                })
                .then(function(){
                    window.location.href = "/listarusuarios";
                });
				
			}).catch(eee => {
				// Imprimir error en consola
				console.log(eee);
				
				// Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
		        Swal.fire({
		            type: 'error',
		            title: 'Oops...',
		            text: '¡Algo ha salido mal!, por favor intente más tarde.',
		        });
			});
		} else {			
            // Mostrar mensaje de error en caso de que los parametros estén malo
            Swal.fire({
                type: 'error',
                title: '¡Alto!',
                text: 'Hay algunos datos incorrectos, por favor verifique.',
            });
		}
	            
	}).catch(ee => {
		// Imprimir error en consola
		console.log(ee);
		
        // Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: '¡Algo ha salido mal!, por favor intente más tarde.',
        });
	});
			
});

$(document).on("click", "#btn-cancelar", function(e) {
	window.location.href = "/listarusuarios";
});