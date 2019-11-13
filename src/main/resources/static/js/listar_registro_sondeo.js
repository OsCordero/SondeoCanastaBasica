$(document).ready(function() {
	//alert("Hola mundo!");
})

// Declarar variables globales
var lenguaje_datatable;

$(document).ready(function(){
    // Variable del idioma para la datatable
    lenguaje_datatable = {
        "decimal": "",
        "emptyTable": "No hay información",
        "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
        "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
        "infoFiltered": "(Filtrado de _MAX_ total entradas)",
        "infoPostFix": "",
        "thousands": ",",
        "lengthMenu": "Mostrar _MENU_ Entradas",
        "loadingRecords": "Cargando...",
        "processing": "Procesando...",
        "search": "Buscar:",
        "zeroRecords": "Sin resultados encontrados",
        "paginate": {
            "first": "Primero",
            "last": "Ultimo",
            "next": "Siguiente",
            "previous": "Anterior"
        }
    };

    // Al cargar la página que la tabla esté sin información
    cargarDataTable();
      

    // Cargar datos a la tabla
    //cargarDatosTdg();
});

$(document).on("change", "#select-periodo", function() {
	//alert($(this).val());
	
	var periodo_id = $(this).val();
	
	var params = {
		periodo_id: periodo_id,
	}
	
    axios.get('/todosregistrosajax', {
        params: params
    }).then(response => {
    	
    	console.log(response.data);
    	if(response.data.length > 0){
            // Llenar la tabla con los resultados traidos de la peticion
            $("#dataTable").DataTable({
        
                "destroy": true,
                "processing": true,
                "data": response.data,
                "ordering": false,
                "pageLength": 10,
                "columns": [
                    { 'data': 'precio' },
                    { 'data': 'precio' },
                    { 'data': 'peso' },
            ],
            "columnDefs": [
                { "width": "10%", "targets": 0 },
                { "width": "65%", "targets": 1 },
                { "width": "10%", "targets": 2 },
                ],
            "info": false,
            "searching": false,
            "ordering": false,
            "lengthChange": false,
            "language": lenguaje_datatable,
        });
    } else if(response.data.length == 0) {
        cargarDataTable();
    }
}).catch(e => {
    // Imprimir error en consola
    console.log(e);
    
    // En caso de que no hayan resultados, siempre pasasr la configuración a la tabla
    cargarDataTable()

    // Mostrar mensaje de error en caso de que algo haya salido mal con la consulta
    Swal.fire({
        type: 'error',
        title: 'Oops...',
        text: '¡Algo ha salido mal!, por favor intente más tarde.',
    });
})
});


function cargarDataTable(){
    var table = $("#dataTable").DataTable({
        "destroy": true,
        "processing": true,
        "ordering": false,
        "pageLength": 10,
        "info": false,
        "searching": false,
        "ordering": false,
        "lengthChange": false,
        "language": lenguaje_datatable,
    });

    table
        .clear()
        .draw();
}