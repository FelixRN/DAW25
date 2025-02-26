function gestionarMerceria(params) {
    let arrayMerceria = ["tela", "bies," ,"hilo", "tijeras", "maquina de coser", "boton"];
    console.log(arrayMerceria);

    arrayMerceria.splice(1,1);
    console.log(arrayMerceria);

    arrayMerceria.splice(2,0, "hilo torzal");
    console.log(arrayMerceria);

    arrayMerceria.splice(3,0, "hilo torzal");

    arrayMerceria.splice(arrayMerceria.indexOf("tijeras"),1, "cúter rotatorio", "mesa de corte");

    const arrayMerceria2 = arrayMerceria.slice(0,3);
    const arrayMerceria3 = arrayMerceria.slice(3);
    console.log(arrayMerceria2);
    console.log(arrayMerceria3);

    arrayMerceria3.unshift("remalladora");
    //arrayMerceria3.splice(0,0,"remalladora");
    arrayMerceria3.splice(-1,0,"cinta metrica");
}