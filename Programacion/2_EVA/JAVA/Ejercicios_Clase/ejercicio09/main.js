
console.log("Hola desde java script")

const minimo = -2;
const maximo = 7;

loopFor(minimo, maximo);
loopWhile(minimo, maximo);
loopDoWhile(minimo, maximo);

function loopFor(min, max) {
    console.log("Bucle for de " + min + " a "+ max);
    for(let i = min; i <= max; i++) {
        console.log(i+"");
    }
}

function loopWhile(min, max) {
    console.log("Bucle while de " + min + " a "+ max);
    
    let i = min;
    while (i >= min && i <= max) {
        console.log(i+"");
        i++;
    }
}

function loopDoWhile(min, max) {
    console.log("Bucle do-while de " + min + " a "+ max);
    
    let i = min;
    do {
        console.log(i+"");
        i++;
    } while (i >= min && i <= max);
}

console.log("adios")
