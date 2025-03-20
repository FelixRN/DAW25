Aquí tienes un formato más vistoso para Markdown:

# Modelo-Vista-Controlador (MVC)

Modelo de arquitectura con la función de separar las distintas funcionalidades del programa.

## Componentes principales

* **Vista**: Permite mostrar datos al usuario y recoger los datos de la terminal (teclado).
* **Controlador**: Manipula los datos / Hace de intermediario entre la vista y el modelo.
* **Modelo**: Guarda la información y la manipula.

## Interfaz

Contrato que define un conjunto de métodos (normas y reglas) que una clase (o más) deben/o no implementar. Tiene métodos incompletos.

- El elemento(1) que implementa la interfaz da un comportamiento a los métodos (cómo funcionan)
- El elemento(2) que usa la interfaz solo puede utilizar los métodos expuestos a ella

---

## Visibilidad y retorno

- **public/private**: Tipo de visibilidad
- **static/void**: Valor de retorno

## Características de las clases

Las propiedades son las características que tiene una clase

- **Lista**: Es una interfaz → `List<> nombre = new ArrayList<>();`
- **()**: Parámetro de entrada

## Clase abstracta

Una clase que tiene un método vacío/incompleto

- No se puede instanciar, porque tiene al menos un método "incompleto"
- Reutiliza el código y evita repetirlo, cuando dos o más clases tienen propiedades y métodos con el mismo valor o comportamiento
- Nos permite hacer listas de la clase abstracta con la implementación de la concreta
- Extendemos las propiedades de una clase (padre) + las clases suyas (hijo)

## Interface vs clase abstracta

### Similitudes
- Ambas tienen métodos incompletos

### Diferencias
- La clase abstracta tiene propiedades y la interfaz no
- Las clases abstractas pueden extender a varias clases, pero no heredar de ningún padre (porque no existe)
- Las interfaces no pueden heredar más de una clase abstracta