$(document).ready(function() {
	//alert("Hola mundo!");
})

// Funcion al detectar cambio de opcion en el select departamento
$(document).on("change", "#select-departamento", function() {
	//alert($(this).val());
	
	var departamento_id = $(this).val();
	
	var params = {
		departamento_id: departamento_id,
	}
	
    axios.get('/todosmunicipiosajax', {
        params: params
    }).then(response => {
    	
    	console.log(response.data);
    	
    	$("#select-municipio").empty();
    	$("#select-municipio").attr("disabled", false);
    	$("#select-municipio").append(`<option value="0" selected disabled>Seleccionar...</option>`);
    	
    	response.data.forEach(function (element) {
    		$("#select-municipio").append(`<option value="${element.idMunicipio}">${element.nombreMunicipio}</option>`);
    	})
    	
    }).catch(e => {
        // Imprimir error en consola
        console.log(e);

        // Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: '¡Algo ha salido mal!, por favor intente más tarde.',
        });
    });
});

//Funcion al detectar cambio de opcion en el select categoria
$(document).on("change", "#select-categoria", function() {
	//alert($(this).val());
	
	var categoria_id = $(this).val();
	
	var params = {
		categoria_id: categoria_id,
	}
	
    axios.get('/todossubcategoriasajax', {
        params: params
    }).then(response => {
    	
    	console.log(response.data);
    	
    	$("#select-subcategoria").empty();
    	$("#select-subcategoria").attr("disabled", false);
    	$("#select-subcategoria").append(`<option value="0" selected disabled>Seleccionar...</option>`);
    	
    	response.data.forEach(function (element) {
    		$("#select-subcategoria").append(`<option value="${element.idSubCategoria}">${element.nombreSubCategoria}</option>`);
    	})
    	
    }).catch(e => {
        // Imprimir error en consola
        console.log(e);

        // Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: '¡Algo ha salido mal!, por favor intente más tarde.',
        });
    });
});

//Funcion al detectar cambio de opcion en el select producto
$(document).on("change", "#select-subcategoria", function() {
	//alert($(this).val());
	
	var subcategoria_id = $(this).val();
	
	var params = {
		subcategoria_id: subcategoria_id,
	}
	
    axios.get('/todosproductosajax', {
        params: params
    }).then(response => {
    	
    	console.log(response.data);
    	
    	$("#select-producto").empty();
    	$("#select-producto").attr("disabled", false);
    	$("#select-producto").append(`<option value="0" selected disabled>Seleccionar...</option>`);
    	
    	response.data.forEach(function (element) {
    		$("#select-producto").append(`<option value="${element.idProducto}">${element.nombreProducto}</option>`);
    	})
    	
    }).catch(e => {
        // Imprimir error en consola
        console.log(e);

        // Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: '¡Algo ha salido mal!, por favor intente más tarde.',
        });
    });
});

//Funcion al detectar cambio de opcion en el select municipio
$(document).on("change", "#select-municipio", function() {
	//alert($(this).val());
	
	var municipio_id = $(this).val();
	
	var params = {
		municipio_id: municipio_id,
	}
	
    axios.get('/todosestablecimientossajax', {
        params: params
    }).then(response => {
    	
    	console.log(response.data);
    	
    	$("#select-establecimiento").empty();
    	$("#select-establecimiento").attr("disabled", false);
    	$("#select-establecimiento").append(`<option value="0" selected disabled>Seleccionar...</option>`);
    	
    	response.data.forEach(function (element) {
    		$("#select-establecimiento").append(`<option value="${element.idEstablecimiento}">${element.nombreEstablecimiento}</option>`);
    	})
    	
    }).catch(e => {
        // Imprimir error en consola
        console.log(e);

        // Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: '¡Algo ha salido mal!, por favor intente más tarde.',
        });
    });
});