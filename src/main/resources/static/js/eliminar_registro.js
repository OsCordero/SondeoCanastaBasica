$(document).ready(function() {
    //alert($.urlParam("nombre"));
    //alert($(".help-block").html());
	
    if($.urlParam("save") == 1) {
      Swal.fire(
        'Registro:',
        "Eliminado con éxito!",
        'success'
      ).then(function(){
    	  window.location.href = "/registrossondeos?periodo_id="+$.urlParam("periodo_id");
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