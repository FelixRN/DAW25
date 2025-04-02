function mostrarTextoComoActuar() {
    let divTexto = document.getElementById("divComoActuar");
    let fiebre = document.getElementById("fiebre");
    let tos = document.getElementById("tos");
    let respirar = document.getElementById("respirar");
    let grave = document.getElementById("grave");

if (fiebre|| tos & (respirar || grave) ) {
    divTexto.innerHTML ="Llama al teléfono 112. Se trata de un teléfono de URGENCIAS. Su buen uso depende de todos. No llames si no es totalmente necesario"
} else if(fiebre || tos){
    divTexto.innerHTML = "Quédate en casa y llama al teléfono habilitado en tu Comunidad Autónoma"
} else {
    divTexto.innerHTML = "";
}

divTexto.setAttribute("class", "azulOscuroNegrita");
//o
//divTexto.classList.add("azulOscuroNegrita");
}

function cargarTexto() {

    let divParaTodos = document.getElementById("paraTodos");
    let encabezadoParaTodos = document.createElement("h2");

    encabezadoParaTodos.innerText = "¿Como puedo protegerme?";
    encabezadoParaTodos.setAttribute("onmouseover", "generarContenido()");
    divParaTodos.appendChild(encabezadoParaTodos);
}

function generarContenido() {

    const p1 = document.createElement("p");
    const p2 = document.createElement("p");
    const p3 = document.createElement("p");

    p1.innerText = "Lávate las manos frecuentemente con agua y jabón";
    p2.innerText = " Al toser o estornudar, cúbrete la boca y la nariz con el codo flexionado o con un pañuelo desechable y tíralo a la basura";
    p3.innerText = "Evita tocarte los ojos, la nariz y la boca, y que las manos facilitan la transmisión.";
    
    document.body.appendChild(p1,p2,p3);
}

