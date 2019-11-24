$(document).ready(function(){
});
		
$(document).on("submit", "#form-editar-periodo", function(e) {
	e.preventDefault();
        // Validaciones 
        var txt_idperiodo = $("#form-editar-periodo input[name=idPeriodo]").val();      
		var txt_nombrePeriodo = $("#form-editar-periodo input[name=nombrePeriodo]").val();
		var txt_fechaInicio = $("#form-editar-periodo input[name=fechaInicio]").val();
		var txt_fechaInicio_error = false;
		var txt_fechaFin = $("#form-editar-periodo input[name=fechaFin]").val();
		var txt_fechaFin_error = false;
		
		$("#error_fechaInicio").html("");
		$("#error_fechaFin").html("");

		var error_general = false;
		
		if (txt_fechaFin < txt_fechaInicio) {
			error_general = true;
			$("#error_fechaInicio").html($("#error_fechaInicio").html() + "La fecha de inicio debe ser anterior a la fecha de fin");
		}

		if (!error_general) {
			var params = {
                    "idPeriodo": txt_idperiodo,
					"nombrePeriodo":  txt_nombrePeriodo,
					"fechaInicio":  txt_fechaInicio,
					"fechaFin":  txt_fechaFin,
			};
			
			console.log(params);
			
			var url = $(this).attr("action");
			console.log(url);
			
			axios.get(url, {

				params: params
			}).then(responsee => {
				
				console.log(responsee);
				
                // Mostrar mensaje de éxito de que todo ha sido registrado
                Swal.fire({
                    type: 'success',
                    title: 'periodo:',
                    text: 'Editado con éxito!',
                })
                .then(function(){
                    window.location.href = "/listarperiodos";
                });
				
			}).catch(eee => {
				Swal.fire({
                    type: 'error',
                    title: '¡Alto!',
                    text: 'Hubo un error en la finalización.',
                });
				console.log(eee);
				
			});
		} else {			
            // Mostrar mensaje de error en caso de que los parametros estén malo
            Swal.fire({
                type: 'error',
                title: '¡Alto!',
                text: 'Hay algunos datos incorrectos, por favor verifique.',
            });
		}
	            
	})

$(document).on("click", "#btn-cancelar", function(e) {
	window.location.href = "/listarperiodos";
});