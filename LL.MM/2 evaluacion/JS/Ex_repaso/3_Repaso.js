function esPrimo(numero){
numero = Number(numero); //Lo convertimos a números

//Verificar la entrada
if(isNaN(numero) || numero <=1){
    return false;
}
    for(let i =2; i<=Math.sqrt(numero); i++){ //ejemplo: Math.sqrt(9) = 3 *no es primo
        if (numero % i === 0 ){
            return false;
        }
    }
return true;
}

function encontrarPrimos(inicio) {
    inicio = Number(inicio);
    
    if (isNaN(inicio) || inicio <= 1) {
        console.log("Por favor, introduzca un número válido mayor que 1.");
        return;
    }

    if (inicio > 100) {
        console.log("El número de inicio es mayor que 100. Mostrando primos hasta 100.");
        inicio = 100;
    }

//Busqueda de los primos
    for (let num = Math.max(2, inicio); num <= 100; num++) { //Math.max devuelve el valor más alto 
        if (esPrimo(num)) {
            console.log(num);
        }
    }
}

let numPrimo = prompt("Introduzca un número para saber si es primo: ") ;

alert(`Su núm es: Number(${encontrarPrimos(numPrimo)})`);
