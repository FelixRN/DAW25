function comprobarEdad() {
    if (confirm("¿Eres mayor de edad?")) {
        let etiquetaNumCuenta = document.createElement("label");
        etiquetaNumCuenta.innerText = "Nº de cuenta";

        let inputNumCuenta = document.createElement("input")
        inputNumCuenta.setAttribute("type, text");

        let inputEdad = document.getElementById("edad");
        let formulario = documentty.getElementsByName("form")[0];
        formulario.insertBefore(inputNumCuenta, inputEdad.nextSibling);
    } else {
        
    }
}