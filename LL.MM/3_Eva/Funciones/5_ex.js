function arrayNumber() {
    const numbers = [];

    while (true) { //Bucle hasta que el usuario introduzca una letra
        let newNumber = prompt("Introduce un número (y una letra para terminar): ") ;

        //Para verificar que el newNumber sea un número
        if (!isNaN(newNumber) && newNumber !== "") {
            numbers.push(Number(newNumber));
        } else {
            break;
        }
    }
    
    //Recorrer el array
    numbers.forEach(num => {
        if (num % 2 == 0 ){
            console.warn(num);
        }
    });
    console.log("Array completo", numbers);
}

arrayNumber();



/** Tenemos una funcion que compara la cantidad de letras de 2 palabras almacenadas en
 * la variable "palabra1" y "palabra2".
 *Primero se le pide al usuario que introduzca una plabra que sera almacenada en -const palabra 1- y
 * seguidamente se le pedira una segunda palabra que se almacenara en -const palabra2-
*/