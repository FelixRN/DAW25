function ejercicio1() {

    var personas = [];

    var numero = prompt("Introduce un número: ");

    for (let i = 0; i < 5; i++) {
        var input = prompt("Itroduzce nombres: ");

        let usuario ={
            newPersonas: input,
        };
        personas.push(usuario);
    }
    console.log(personas);

    var eliminar = prompt("Elija un número del 1 al 5: ")

    switch (personas) {
        case 1:
            eliminar = "1";
            personas.splice(0);
            console.warn("Quedan " + personas.lenght + "nombres");
            break;
        case 2:
            eliminar = "2";
            personas.splice(1);
            console.warn("Quedan " + personas.lenght + "nombres");
            break;
        case 3:
            eliminar = "3";
            personas.splice(2);
            console.warn("Quedan " + personas.lenght + "nombres");
            break;
        case 4:
            eliminar = "4";
            personas.splice(3);
            console.warn("Quedan " + personas.lenght + "nombres");
            break;
        case 5:
            eliminar = "5";
            personas.splice(4);
            console.warn("Quedan " + personas.lenght + "nombres");
            break;
        default:
            // SI NO ES UN NÚMERO ENTRE 0 Y 22 MOSTRAMOS UN ERROR
            console.warn("No hay ningún nombre almacenado en la posición " + eliminar);
    }

}
ejercicio1()



function ejercicio2() {
    
    let number =[]; //Almacenar en array
    //Solicitar 10 números
    for (let i = 0; i < 3; i++) {
        var input = prompt("Itroduzca un número: ");

        let usuario ={
            newNumber: input,
        };
        number.push(usuario);
    }

    var input = Number(input);
    media =  (input) / number.length;

console.log(media);

confirm("¿La media de los números introducidos es: " + media);
if (confirm == "Aceptar") {
    console.log(true);
} else {
    console.log(false);
}
    //alert("La media de los números es: " + media);
}
ejercicio2();



/** Tenemos una funcion que compara la cantidad de letras de 2 palabras almacenadas en
 * la variable "palabra1" y "palabra2".
 *Primero se le pide al usuario que introduzca una plabra que sera almacenada en -const palabra 1- y
 * seguidamente se le pedira una segunda palabra que se almacenara en -const palabra2-
 * 
 * Luego habra una variable llamada -const palabraMayor- en donde contendra una función en donde tendra
 * palabra 1 y palabra 2.
 * Seguidamente mediante un bcucle if else se comprobara que palabra tiene mas letras usando la propiedad
 * lenght que te devuelve la cantidad de elementos, de esa manera se comprueba cual palabra contiene más letras 
 * que la otra. 
 * y por último se llama a la función "palabraMayor"
*/