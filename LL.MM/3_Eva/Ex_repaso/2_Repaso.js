var count = prompt("Si quiere convertir de euro -> dolares Elija 1 / si lo quiere de dolares -> euros Elija 2: ") ;

if (count == 1) {
    var cantidad = prompt("Introduzca la cantidad: ");
    var conversionD = cantidad * 1.07;
    confirm(`Su conversion a dolar es: ${conversionD.toFixed(2)}`);
}else if (count == 2){
    var cantidad = prompt("Introduzca la cantidad: ");
    var conversionE = cantidad * 0.94;
    confirm(`Su conversion a euro es: ${conversionE.toFixed(2)}`);
} else{
    alert("Opción no válida");
}