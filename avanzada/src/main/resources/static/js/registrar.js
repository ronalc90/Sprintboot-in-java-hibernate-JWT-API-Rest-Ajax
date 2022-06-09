// Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready

});
async function registrarUsuario(){
   let datos ={};
   datos.nombre=document.getElementById('txtNombre').value;
   datos.apellido=document.getElementById('txtApellido').value;
   datos.email=document.getElementById('txtEmail').value;
   datos.password=document.getElementById('txtPassword').value;

   let repetirPassword=document.getElementById('txtRepetirPassword').value;


   if(repetirPassword != datos.password){
   alert("la contraseña que escribiste es diferente.");
   return;
   }


  const request = await fetch('api/usuarios', {
  //POST SE UTILIZA mas cuando toca insertar o crear una entidad en la base de datos
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    // agarrar cualquier objeto de javascrip y convertirlo un string de json
    body: JSON.stringify(datos)
  });
  alert("su registro fue exitoso");
  window.location.href = 'login.html'

}

