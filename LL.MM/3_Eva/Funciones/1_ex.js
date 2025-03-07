

let nombre = prompt("Introduzca su nombre: ");


if (!nombre || !isNaN(Number(nombre))) {
    alert("No se ha introducido un valor correcto")
} else {
    if (confirm(`¿Realmente te llamas: ${nombre}?`)) {
        alert("Bienvenido " +  nombre);
    } else {
        alert("Chao pescao")
    }
}
