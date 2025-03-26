function agregarLista(){

var listaOrdenada = document.createElement('ol');

var item1 = document.createElement('li');
var item2 = document.createElement('li');
var item3 = document.createElement('li');

item1.innerText = 'Uno';
item2.innerText = 'Dos';
item3.innerText = 'Tres';

listaOrdenada.appendChild(item1);
listaOrdenada.appendChild(item2);
listaOrdenada.appendChild(item3);

//Agregar al documento
document.body.appendChild(listaOrdenada);


}
function sustituir(listaOrdenada) {

    var item4 = document.createElement('li')
    item4.innerText = 'cuatro';
    listaOrdenada.replaceChild(item4, item3);

    var newChild = document.createElement('p');
    newChild.innerText= 'Soy hijo de cuatro';
    item4.appendChild(newChild);

    var newTitle = document.getElementsByTagName('h1')
    newTitle.textContent = "He creado una lista";

}


//for (let i = 0; i < 3; i++) {
 //   li = document.createElement("li");
   // li.innerText = arrayTextos[i];
    //listaOrdenada.appendChild(li);
//}