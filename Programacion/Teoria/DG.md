MVC: Modelo de arquitectura con la funcion de separa las distintas funcionalidades del programa.

Vista: Permite mostrar datos al usuario y recoger los datos de la terminal(teclado) .
Controlador: Manipula los datos / Hace de intermediario entre la vista y el modelo.
Modelo: Guarda la información y manipular.

Interfaz: Contrato que define un conjunto de métodos(normas y reglas) que una clase (o más) deben/o no de implementar. Tiene métodos incompletos

    -El elemento(1) que implementa la interfaz da un comportamiento métodos(como funciona)
    -El elemento(2) que usa la interfaz solo puede utilizar los métodos expuestos a ella

-------------------------------------------------------------------------------------------------------
public/private: Tipo de visibilidad

static/void: Valor de retorno

Las propiedades son las caracteristicas que tiene una clase

Lista: Es una interfaz -> List <> nombre = new ArrayList<>();
(): Parametro de entrada

Clase abstracta: Una clase que tiene un método vacio/incompleto
    -No se puede instanciar, porque tiene al menos un método "incompleto"
    -Reutilizar el código y no repetirlo, cuando dos o más clases tiene propiedades y métodos con el mismo valor o comportamiento. 
    -Nos permite hacer listas de la clase abstracta con la implementación de la concreta.
    -Extendemos las propiedades de una clase(padre) + las clases suyas(hijo).

Interface y clase abstractas:
    Similitudes: Ambas tienen métodos incompletos

    Diferencias:
        La clase abstracta tiene propiedades y la interfaz no
        Las clases abstractas pueden extender a varias clases, pero no heredar de ningún padre(porque no existe) y las interfaces no pueden heredar más de una clase abstracta
