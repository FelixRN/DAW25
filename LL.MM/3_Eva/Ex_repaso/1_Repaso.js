var num = prompt("Introduzca el número (positivo/negativo/neutro)");

if (!num) {
    console.error("No se ha introducido un número");

}else if(num < 0){
        console.log("El número es negatio");
        confirm("El número es negativo");

}else if(num > 0){
        console.log("El número es positivo");
        confirm("El número es negativo");
} else{
    console.log("El número es neutro");
    confirm("El número es neutro");
}

    