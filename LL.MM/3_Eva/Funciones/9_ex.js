function gestionPersonas(){
    let arrayUsuarios =[];

    for (let i = 0; i < 3; i++) {
        const nombreUser = prompt("Itroduzca un nombre");
        const edadUser = prompt("Introduzca su edad");
        const ciudadUser = prompt("Introduzca una ciudad");

        let usuario ={
            nombre: nombreUser,
            edad: edadUser,
            ciudad: ciudadUser,
        };

        arrayUsuarios.push(usuario);
    }
    console.log(arrayUsuarios);

    //2º parte
    let ciudades ="";
    for(let i=0; i<arrayUsuarios.length; i++){
        ciudades += arrayUsuarios [i].ciudad;
    }

    //3º parte
    let ciudadElegida = prompt(`Elija una ciudad ${ciudades}`);
    for (let i=0; i<arrayUsuarios; i++){
        if (arrayUsuarios[i].edad > 25) {
            console.log(arrayUsuarios[i].nombre);
        }
    }
}

gestionPersonas();