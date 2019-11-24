$(document).ready(function() {
	$(document).on("click", "#finalizar", function(e) {
        e.preventDefault();
       
        Swal.fire({
            type: 'warning',
            title: '¿Está seguro que quiere finalizar el período?',
            text: '¡Ésta acción no puede deshacerse!',
            showCancelButton: true,
            cancelButtonText:'Cancelar',
            cancelButtonColor: '#d33',
            confirmButtonText: 'si, finalizar período',
            
          })
          .then((willDelete) => {
              console.log(willDelete);
            if (willDelete.value) {
                var url = $(this).attr("href");
                console.log(url);
                
                axios.get(url, {
                }).then(responsee => {
                    
                    console.log(responsee);
                    
                    // Mostrar mensaje de éxito de que todo ha sido registrado
                    Swal.fire({
                        type: 'success',
                        title: 'periodo:',
                        text: 'Finalizado con éxito!:',
                    })
                    .then(function(){
                        window.location.href = "/listarperiodos";
                    });
                    
                }).catch(eee => {
                    Swal.fire({
                        type: 'error',
                        title: '¡Alto!',
                        text: 'Hubo un error en la actulización.',
                    });
                    console.log(eee);
                    
                });
            } else {
               
            }
        });
         
          });
       
    });
