//Implementa un programa que pida al usuario el nombre, edad y ciudad de nacimiento de
//10 personas. Esta información se almacenará en un array de objetos (cada objeto
//representa a una persona con las propiedades nombre, edad y ciudad). Se mostrará al
//usuario, mediante un alert, todas las ciudades del array y se le pedirá que elija una. Se
//sacará por consola el nombre de todas las personas mayores de 25 años que viven en
//dicha ciudad.

function programaPersonas() {
    let personas = [];

    // Solicitar los datos de 10 personas
    for (let i = 1; i <= 2; i++) {
        let nombre = prompt(`Ingresa el nombre de la persona ${i}:`);
        let edad = parseInt(prompt(`Ingresa la edad de ${nombre}:`));
        let ciudad = prompt(`Ingresa la ciudad de nacimiento de ${nombre}:`);

        // Crear un objeto para la persona y agregarlo al array
        personas.push({ nombre, edad, ciudad });
    }

    // Obtener todas las ciudades únicas
    //let ciudades = [...new Set(personas.map(persona => persona.ciudad))];

    // Mostrar las ciudades al usuario y pedirle que elija una
    let ciudadElegida = prompt(`Las ciudades disponibles son:\n${ciudades.join(", ")}\n\nElige una ciudad:`);

    // Filtrar las personas mayores de 25 años que viven en la ciudad elegida
    let personasFiltradas = personas.filter(persona => persona.edad > 25 && persona.ciudad === ciudadElegida);

    // Mostrar los nombres de las personas filtradas por consola
    if (personasFiltradas.length > 0) {
        console.log(`Personas mayores de 25 años en ${ciudadElegida}:`);
        personasFiltradas.forEach(persona => console.log(persona.nombre));
    } else {
        console.log(`No hay personas mayores de 25 años en ${ciudadElegida}.`);
    }
}

// Llamar a la función para ejecutar el programa
programaPersonas();