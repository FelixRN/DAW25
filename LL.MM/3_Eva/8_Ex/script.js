var fact = prompt("Introduzca el número del cual se quiere obtener el factorial:");
    Number(num);
if (!num) {
    console.error("No se ha introducido un número");
}else
    do {
        var num = 1;
        for (i=1; i<=fact; i++) {
            num = num * i;
        }
        console.log("Factorial de " + fact + ": " + num);
    fact--;
    } while (fact > 0);
console.log(fact);