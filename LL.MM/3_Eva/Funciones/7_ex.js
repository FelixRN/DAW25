//Implementa una función que muestre, por consola, la tabla de multiplicar de un número
//solicitado al usuario

function multipicacion() {
    
    while (true) {
        let input = prompt("Ingresa un número para mostrarte su tabla de multiplicacion (o escribe 'salir' para terminar): ");
    
        //Verificar si el usuario quiere salir
        if (input === "salir") {
            alert("Nos vemos!");
            break;
        }

    //Verificar que sea un número
    let number = Number(input);
    if (!Number(number) && input !== "") {
        alert("No es un número válido");
    } else {
        alert(`La tabla de ${number} es: `);
        for (let i = 0; i <= 10; i++) {
            alert(`${number} x ${i} = ${number * i}`)
        }
    }
}
}

multipicacion();