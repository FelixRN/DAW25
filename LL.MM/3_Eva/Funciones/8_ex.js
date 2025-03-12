function numRandom() {
  let num = parseInt(Math.random() * 100) + 1; // Número que genera un número hasta 100
  //Agregado:
    console.log("Número generado (para pruebas):", num);

    while (true) {
    let guess = prompt("Intenta adivinar el número generado entre 1 y 100: ");

    //Verificar que sea un número
    if (!Number(guess) && gues !== "") {
        alert("Eso no es un número. Inténtalo de nuevo.");
        continue;
    }

    guess = Number(guess); //Convertir a un número

    if (guess === num) {
        alert("Acertaste!");
        break;
    } else if (guess < num) {
        alert("Más alto!");
    } else {
        alert("Más bajo");
    }
    }
}
numRandom();
