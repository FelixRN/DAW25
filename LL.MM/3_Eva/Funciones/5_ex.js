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

