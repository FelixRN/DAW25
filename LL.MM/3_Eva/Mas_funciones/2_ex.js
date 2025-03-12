do {
    while (true) {
        let nota = prompt("Ingresa una nota (o escribe 'salir' para terminar): ");
    
        if (nota === "salir") {
            alert("Nos vemos!");
            break;
        }

    if (!Number(nota) && nota !== "" && nota != undefined) {
        alert("Valor incorrecto");
    } else if(Number(nota) == nota) {

    if (nota > 0 && nota <= 10 ) {
        if (nota < 3) {
            alert("Muy deficiente");
        }
        else if (nota < 5) {
            alert("Insuficiete");
        } else if (nota < 6) {
            alert("Suficiente");
        } else if (nota < 7) {
            alert("Bien");
        } else if (nota < 9) {
            alert("Notable"); 5
        } else if (nota >= 9) {
            alert("Sobresaliente");
        }
    }
    }
}
}
while (nota != undefined); // Undefined es cuando se pulsa Cancelar.