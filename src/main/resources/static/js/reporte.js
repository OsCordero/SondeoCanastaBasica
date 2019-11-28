$(document).ready(function() {
    //alert($.urlParam("nombre"));
    //alert($(".help-block").html());
	
    if($.urlParam("save") == 1) {
      Swal.fire(
        'Reporte:',
        "Generado con éxito!",
        'success'
      ).then(function(){
    	  window.location.href = "/listarperiodosondeo";
      });
    }
});

//Función para saber el valor de los parametros get
$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null) {
        return null;
    }
    return decodeURI(results[1]) || 0;
}