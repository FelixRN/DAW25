function calculadora() {
    let num1 = parseFloat(prompt("Ingresa el primer número:"));
    let num2 = parseFloat(prompt("Ingresa el segundo número:"));
    let operacion = prompt("Ingresa la operación (suma, resta, multiplicacion, division):");

    let resultado;
    switch (operacion) {
        case "suma":
            resultado = num1 + num2;
            break;
        case "resta":
            resultado = num1 - num2;
            break;
        case "multiplicacion":
            resultado = num1 * num2;
            break;
        case "division":
            resultado = num1 / num2;
            break;
        default:
            resultado = "Operación no válida";
    }

    alert("El resultado es: " + resultado);
}

calculadora();