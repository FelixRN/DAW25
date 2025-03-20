function ejercicio1() {
    var numero = Number(prompt("Escriba un número: "));
    var personas = [];

    for (let N = 0; N < 3; N++) {
        personas[N] = prompt("Introduzca 3 nombres: ");
        personas.push(N);
    }
    alert(personas);

    while (personas != 0) {
        var numero2 = Number(prompt("Escriba un número entre 0 y " + numero));
        if (numero2 == personas.length) {
            personas.splice(numero2);
            console.warn("Quedan " + personas.length + "nombres");
        } else {
            console.error("No hay ningún nombre almacenado en la posicion " + numero2);
        }
    } if (personas == 0) {
        alert("Se han eliminado todos los nombres")
    }
}
ejercicio1();


//
function ejercicio1() {
    let N = parseInt(prompt("Introduce un número de personas: "));
    let personas = [];
    
    for (let i = 0; i < N; i++) {
        let nombre = prompt("Introduce nombre " + (i+1) + ": ");
        personas.push(nombre);
    }
    
    // Mostrar el array por consola
    console.log(personas);
    
    // Mientras queden nombres en el array
    while (personas.length > 0) {
        // Pedir posición P
        let P = parseInt(prompt("Elija un número entre 0 y " + (personas.length-1) + ": "));
        
        // Comprobar si la posición P existe
        if (P >= 0 && P < personas.length) {
            // Eliminar la posición P
            personas.splice(P, 1);
            
            // Mostrar warning con los nombres que quedan
            console.warn("Quedan " + personas.length + " nombres");
        } else {
            // Mostrar error si la posición no existe
            console.error("No hay ningún nombre almacenado en la posición " + P);
        }
    }
    
    // Informar cuando se han eliminado todos los nombres
    console.log("Se han eliminado todos los nombres");
}

ejercicio1();