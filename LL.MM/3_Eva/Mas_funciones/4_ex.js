// DECLARAMOS LA VARIABLE SUMA
var suma = 0;

do {

    var numero = prompt("Introduce números. Presiona cancelar para acabar");
    
    if (Number(numero) == numero) {
        
        numero = Number(numero);
        
        suma = suma + numero;
    }
    
    else {
        // SI SE PULSÓ ACEPTAR SIN PONER UN NÚMERO VÁLIDO
        if (numero != undefined) {
            alert(numero + " No es un numero");
        }
    }
// VOLVEMOS ARRIBA MIENTRAS NO SE PULSE CANCELAR
} while (numero != undefined);
// SI SE PULSÓ CANCELAR SALE DEL BUCLE E IMPRIME EL RESULTADO
alert(suma);