function ejercicio1() {
    // Pedir al usuario un número N
    let N = parseInt(prompt("Introduce un número de personas: "));
    
    // Crear un array para almacenar N nombres
    let personas = [];
    
    // Pedir N nombres al usuario
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


function ejercicio2() {
    let numbers = []; // Array para almacenar números/ Acumulara la suma de todos los números
    
    // Solicitar 10 números (no 3 como estaba en tu código)
    for (let i = 0; i < 10; i++) {
        let input = prompt("Introduzca un número: ");
        // Convertir a número y guardar directamente (no como objeto)
        numbers.push(Number(input));
    }
    
    // Calcular la media correctamente
    let suma = 0;
    for (let i = 0; i < numbers.length; i++) {
        suma += numbers[i];
    }
    let media = suma / numbers.length;
    
    // Pedir confirmación al usuario
    let confirmacion = confirm("¿La media de los números introducidos es " + media + "?");
    
    // Devolver true o false según confirmación (no solo mostrar en consola)
    return confirmacion;
}

// La función ahora devuelve el resultado
let resultado = ejercicio2();
console.log(resultado);