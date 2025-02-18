alert("¡Hola Mundo 1!");

let nombre = prompt("Introduce tu nombre:");
//Verificamos si el campo está vacio !
if (!nombre) {
    console.error("No se ha introducido un nombre");
    alert("No has escrito ningun nombre");

} else {
    let confirmacion = confirm("¿Realmente te llamas " + nombre + "?");

    if (confirmacion) {
        console.log("El nombre es correcto");
        alert("Bienvenido sea");
    
    } else {
        console.warn("No es su nombre");
        alert("Adiós");
    }
}


/*function gestionarUsuario() {
    let nombre = prompt("Introduzca su nombre, por favor");

    switch (nombre = null) {
        case 1:
            console.warn("Que introduzcas tu nombre" )
            break;
    
        case 2:
            console.alert("NO HAS ESCRITO TU NOMBRE")
            break;

        case 3:
            console.alert("NO HAS ESCRITO TU NOMBRE")
            break;
    }

//}
//function confirmacion() {
// confirm("Confirmar");
//}*/
