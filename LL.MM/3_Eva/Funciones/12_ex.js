function piedraPapelTijera() {
    let opciones = ["Piedra", "Papel", "Tijera"];
    let victoriasUsuario = 0;
    let victoriasOrdenador = 0;

    while (victoriasUsuario < 2 && victoriasOrdenador < 2) {
        let eleccionUsuario = prompt("Elige: P para Piedra, Pa para Papel, T para Tijera:").toLowerCase();
        let eleccionOrdenador = opciones[Math.floor(Math.random() * 3)];

        let resultado;
        if (
            (eleccionUsuario === "p" && eleccionOrdenador === "Tijera") ||
            (eleccionUsuario === "pa" && eleccionOrdenador === "Piedra") ||
            (eleccionUsuario === "t" && eleccionOrdenador === "Papel")
        ) {
            resultado = "Ganaste";
            victoriasUsuario++;
        } else if (
            (eleccionUsuario === "p" && eleccionOrdenador === "Papel") ||
            (eleccionUsuario === "pa" && eleccionOrdenador === "Tijera") ||
            (eleccionUsuario === "t" && eleccionOrdenador === "Piedra")
        ) {
            resultado = "Perdiste";
            victoriasOrdenador++;
        } else {
            resultado = "Empate";
        }

        alert(`Elegiste: ${eleccionUsuario}\nEl ordenador eligió: ${eleccionOrdenador}\nResultado: ${resultado}`);
    }

    alert(`Resultado final:\nTus victorias: ${victoriasUsuario}\nVictorias del ordenador: ${victoriasOrdenador}`);
}

piedraPapelTijera();