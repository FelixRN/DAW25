function crearLista() {
    let lista = document.createElement("ol");

    let elemento1 = document.createElement("li");
    elemento1.innerText ="Uno";
    lista.appendChild(elemento1);

    let elemento2 = document.createElement("li");
    elemento2.innerText ="Dos";
    lista.appendChild(elemento2);

    let elemento3 = document.createElement("li");
    elemento3.innerText ="Tres";
    lista.appendChild(elemento3);

    document.body.appendChild(lista);
    
}

function modificar() {
    var elemento_4 = document.getElementById("li").innerHTML;

    
}
