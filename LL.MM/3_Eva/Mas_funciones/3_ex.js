// Inicializar la variable para almacenar el resultado
let resultado = "";

///////// Bucle para pedir cadenas
while (true) {
    let cadena = prompt("Ingresa una cadena de texto (o escribe 'cancelar' para terminar): ");
    
    // Verificar si el usuario canceló o escribió 'cancelar'
    if (cadena === null || cadena.toLowerCase() === "cancelar") {
        break;
    }
    
    // Concatenar la cadena con un guión, pero solo si no es la primera entrada
    if (resultado === "") {
        resultado = cadena;
    } else {
        resultado = resultado + "-" + cadena;
    }
}

// Mostrar el resultado final
if (resultado) {
    alert("Cadenas concatenadas: " + resultado);
} else {
    alert("No se ingresaron cadenas.");
}