//Variables globales

let listaOrdenada;
let item3;
let item4;
let parrafo;

function agregarLista() {
    listaOrdenada = document.createElement("ol");

    const item1 = document.createElement("li");
    const item2 = document.createElement("li");
    item3 = document.createElement("li");

    item1.innerText = "Uno";
    item2.innerText = "Dos";
    item3.innerText = "Tres";

    listaOrdenada.appendChild(item1);
    listaOrdenada.appendChild(item2);
    listaOrdenada.appendChild(item3);

    //Agregar al documento
    document.body.appendChild(listaOrdenada);
}
function sustituir() {
    const item4 = document.createElement("li");
    item4.innerText = "Cuatro";
    listaOrdenada.replaceChild(item4, item3);

    const newChild = document.createElement("p");
    newChild.innerText = "Soy hijo de cuatro";
    item4.appendChild(newChild);

    //var newTitle = document.getElementsByTagName('h1')
    //newTitle.textContent = "He creado una lista"; //No se puede usar textContent directamente en el resultado

    document.getElementById("titulo").textContent = "He creado una lista";
}

function addParrafo() {
    parrafo = document.createElement('p')
    parrafo.setAttribute("class", "cambiarNegro")
    parrafo.innerText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
    document.body.appendChild(parrafo);
}

////////////////////////////

function cambiarColor() {
    //document.getElementsByTagName('p')[0];
    if (parrafo) {
        
        if (parrafo.classList.contains("cambiarNegro")) {
            parrafo.classList.remove("cambiarNegro")
            parrafo.classList.add("cambiarRojo")

        } else {
            parrafo.classList.remove("cambiarRojo")
            parrafo.classList.add("cambiarNegro")
        }
    }

    /*if(parrafo){
        parrafo.classList.toggle("cambiarRojo");
    }

    */
}