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


function ejercicio2() {
    let numeros =[];
    for (let i = 0; i < 3; i++) {
        numeros[i] = Number(prompt("Introduzca un número: "));
    }

    if (numeros[0] == numeros[1] && numeros[1] == numeros[2]) {
        alert("Los tres números son iguales");
    
        //else if (numeros[0] == numeros[1] || numeros [1] == numeros[2] || numeros[0] == numeros[2])

    }else if (numeros[0] == numeros[1] && numeros[1] != numeros[2]){
    alert("Dos números son iguales");

    }else if (numeros[0] != numeros[1] && numeros[1] == numeros[2]){
        alert("Dos números son iguales");

    }else if (numeros[0]  == numeros[2]){
    alert("Dos números son iguales");

    }else {
    alert("Los tres números son diferentes");
}
}
