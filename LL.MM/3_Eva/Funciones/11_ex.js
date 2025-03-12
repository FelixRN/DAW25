function juegoAdivinanzas() {
    let palabra = prompt("Usuario 1, introduce una palabra para que el Usuario 2 la adivine:").toLowerCase();
    let intentos = 10;
    let palabraAdivinada = "_".repeat(palabra.length).split("");

    while (intentos > 0) {
        let letra = prompt(`Usuario 2, adivina una letra (${intentos} intentos restantes):\n${palabraAdivinada.join(" ")}`).toLowerCase();

        if (palabra.includes(letra)) {
            for (let i = 0; i < palabra.length; i++) {
                if (palabra[i] === letra) {
                    palabraAdivinada[i] = letra;
                }
            }
        } else {
            alert("La letra no está en la palabra.");
        }

        if (palabraAdivinada.join("") === palabra) {
            alert("¡Felicidades! Adivinaste la palabra: " + palabra);
            return;
        }

        intentos--;
    }

    alert("Se acabaron los intentos. La palabra era: " + palabra);
}

juegoAdivinanzas();