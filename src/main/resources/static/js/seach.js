
window.alert("a");
var search = $('#search');
console.log("Hola")

searchInput.on('input', function() {
    var searchTerm = searchInput.val();
    
    // Realizar la solicitud AJAX al servidor utilizando jQuery
    $.ajax({
      url: '/admin/',
      data: { search: searchTerm },
      success: function(response) {
        // Actualizar los resultados de búsqueda en el contenedor
        
      },
      error: function() {
        // Manejar el caso de error
        console.error('Error en la solicitud de búsqueda');
      }
    });
  });