//Crea una página web que pida al usuario dos números y muestre su división, 
// pero sólo en caso de que el segundo no sea cero; si el segundo es cero, 
// deberá escribir "No se puede dividir entre cero"

var num1 = Number(prompt("Introduzca un número: "));
var num2 = Number(prompt("Introduzca el segundo número: "));

var div = num1/num2;

if (num2 != 0) {
    alert("El resultado de su división es: " + div);
} else {
    alert("No se puede dividir entre 0 rey");
}

//////////////////////////////////////////////
//Realiza un script que pida cadenas de texto  hasta que se pulse “cancelar”.
// Al salir con “cancelar”+
// deben mostrarse todas las cadenas concatenadas con un guión -.

let ct = "";

do {
    var cadena = prompt("Introduce una frase: ")
        if (cadena =="") {
            ct = cadena + ct;
        } else {
            ct = cadena + " - " + ct;
        }
} while (confirm("Desea continuar?"))
    alert(ct);


