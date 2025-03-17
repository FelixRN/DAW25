function ejercicio1() {
    let N = parseInt(prompt("Introduce un número: "));;

    let arrayPersonas = [];

    for (let i = 0; i < N; i++) {
        //arrayPersonas[i]
        let input = prompt("Introduce " + (i+1) + " nombres: " );
        arrayPersonas.push(input);
}

    console.log(arrayPersonas);

    //Mientras no quende nombres en el array // while (arrayPersonas != 0)
while (arrayPersonas.length > 0) {
    var P = parseInt(prompt("Introduce un número entre 0 y " + N + ":" ));//Preguntar

    if (P > arrayPersonas.length ) {
        arrayPersonas.splice(P,1);
    } else {
        
    }
}

}