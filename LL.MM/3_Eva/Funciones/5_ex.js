function arrayNumero () {
    let numeros = [];

    for (let i = 0; i < 3 ; i++) {
        const numerosNew = prompt("Introduce 3 números: ");

        let usuario={
            numeros: numerosNew
        }
        numeros.push(usuario);
    }
    alert(numeros.length);
}

arrayNumero();