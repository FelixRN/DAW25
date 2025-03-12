//Crea una función que pida un número al usuario y 
//le indique si éste es par o impar.

/*function getNumber() {

    while (true) {
    let input = prompt("Ingresa un número (o escribe 'salir' para terminar): ");

    //Verificar si el usuario quiere salir
    if (input.toLowerCase() === "salir") {
        alert("Nos vemos!");
        break;
    }
    //Verificar que sea un número:
        if (!isNaN(input) && input !== "") {
            let number = Number(input); //Lo convertimos a número

    // Verificamos si el número es par o impar
    if (number % 2 === 0) {
        alert("El número " + number + " es par.");
    } else {
        alert("El número " + number + " es impar.");
    }

        } else{
            alert("No es un número válido, Try again.");
        }
}
}
getNumber();
*/
function getNumber() {

    while (true) {
    let input = prompt("Ingresa un número (o escribe 'salir' para terminar): ");

    //Verificar si el usuario quiere salir
    if (input === "salir") {
        alert("Nos vemos!");
        break;
    }

    //Verificar que sea un número:
    let number = Number(input); // Convertimos el input a número

    if (!Number(number) && number !== "") {
        alert("No es un número válido")
    } else {
        //Verificar si es par o impar
        if (number % 2 === 0 ) {
            alert("Es par");
            
        } else {
            alert("Es impar")
        }
    }
}
}

getNumber();