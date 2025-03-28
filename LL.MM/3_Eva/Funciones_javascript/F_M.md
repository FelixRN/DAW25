### 1. Interacción con el usuario

#### .1. Mensajes de alerta

**alert()**  
Mediante el método `alert()` se mostrará un mensaje por pantalla al usuario. La alerta mostrada quita el foco de la ventana del navegador, por lo que el usuario no podrá acceder a otras partes de la página hasta que no acepte el mensaje mostrado. Este método no devuelve ningún valor.

**prompt()**  
Utilizando este método se mostrará al usuario un mensaje en una ventana modal solicitando información. De la misma forma que el método `alert`, el foco pasa a la nueva ventana y no se puede continuar accediendo a otras partes de la página.  
`prompt()` devuelve el valor introducido, en forma de cadena, si el usuario pulsa Aceptar, o `null` en caso contrario:
```javascript
let dato = prompt("Introduzca su nombre por favor");
```

**confirm()**  
Al utilizar este método se mostrará por pantalla un mensaje de alerta para su confirmación o cancelación, de nuevo en una ventana modal. Al igual que los dos métodos anteriores, el foco pasa a la ventana modal.  
Este método devuelve `true` si el usuario acepta el mensaje y `false` en caso contrario.

#### 1.2. Mensajes por consola

Con JavaScript es posible imprimir mensajes por la consola del navegador. Esto es muy útil en tiempo de desarrollo, aunque no es recomendable dejar mensajes informativos en producción (los errores sí). Los principales métodos que proporciona la consola son:

```javascript
console.log("Mensaje de consola.");
console.info("Mensaje informativo.");
console.warn("Mensaje de aviso.");
console.error("Mensaje de error.");
console.clear(); // Para limpiar la consola
```

### 1.3 Operadores

Un operador es básicamente un símbolo matemático que puede actuar sobre dos valores (o variables) y producir un resultado. Los tipos de operadores más comunes en JavaScript son:

- **Operadores aritméticos**: Sirven para realizar operaciones aritméticas con valores y/o variables.
- **Operadores comparativos**: Para establecer comparaciones entre valores y/o variables.
- **Operadores lógicos**: Se utilizan para establecer condiciones.

#### Operadores aritméticos

| Operador | Descripción |
|----------|------------|
| `+` | Adición: suma dos valores o concatena cadenas |
| `-` | Sustracción |
| `*` | Multiplicación |
| `/` | División |
| `%` | Módulo (resto de la división) |
| `++` | Incremento en una unidad |
| `--` | Decremento en una unidad |

El operador `+` tiene una función distinta de las aritméticas cuando se usa con cadenas, ya que en ese caso concatena en lugar de sumar.

#### Operadores comparativos

| Operador | Descripción |
|----------|------------|
| `>` | Mayor que |
| `<` | Menor que |
| `==` | Igual a |
| `!=` | Distinto de |
| `>=` | Mayor o igual a |
| `<=` | Menor o igual a |
| `===` | Idéntico a (mismo valor y tipo) |
| `!==` | No idéntico a (diferente valor o tipo) |

#### Operadores lógicos

| Operador | Descripción |
|----------|------------|
| `!` | NOT: true si no se cumple la condición |
| `&&` | AND: true si se cumplen ambas condiciones |
| `||` | OR: true si se cumple una de las dos condiciones |

### Arrays

Un array es un tipo especial de `object` que se utiliza para almacenar más de un valor en una sola variable. Se accede a cada valor mediante un índice numérico.

Ejemplo de declaración de arrays:
```javascript
var variables = ["var1", "var2", "var3", "var4"];
var variables = new Array("var1", "var2", "var3", "var4");
```

Para acceder a un elemento del array:
```javascript
var num3 = variables[2];
alert(num3);
```

Un array puede contener diferentes tipos de datos:
```javascript
var array1 = [1,2,3,4,5];
array1[1] = ["cadena1","cadena2", "cadena3"];
array1[2] = "pepito";
```

#### Métodos útiles en Arrays

**length, sort, push, pop**

- `length`: Devuelve el número de elementos de un array.
- `sort()`: Ordena un array alfabéticamente.
- `push()`: Agrega un nuevo elemento al final del array.
- `pop()`: Elimina el último elemento del array y lo devuelve.

```javascript
var deportes = ["futbol", "baloncesto", "balonmano", "tenis"];
deportes.push("padel");
deportes.sort();
deportes.pop();
```

**slice, splice**

- `slice()`: Devuelve una porción del array en un nuevo array sin modificar el original.
- `splice()`: Permite eliminar elementos de un array o insertar nuevos.

Ejemplo de `slice()`:
```javascript
var deportes2 = deportes.slice(1,3);
var deportes3 = deportes.slice(-2);
```

```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
var masculinos = nombres.slice(1, 3);

console.log(masculinos); // ['Pedro', 'Miguel']
console.log(nombres);    // ['Rita', 'Pedro', 'Miguel', 'Ana', 'Vanesa'] (no se modifica)
```
Ejemplo 2: Extraer desde un índice hasta el final:

```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
var resto = nombres.slice(2);

console.log(resto); // ['Miguel', 'Ana', 'Vanesa']
```
Ejemplo 3: Extraer los últimos elementos:

```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
var ultimos = nombres.slice(-2);

console.log(ultimos); // ['Ana', 'Vanesa']
```
Ejemplo 4: Copiar un array completo

```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
var copia = nombres.slice();

console.log(copia); // ['Rita', 'Pedro', 'Miguel', 'Ana', 'Vanesa']
```


Ejemplo de `splice()`:

El método splice se utiliza para modificar un array eliminando, reemplazando o agregando elementos. Su sintaxis es:

```javascript
array.splice(inicio, cantidad, elemento1, elemento2, ...);
```
inicio: Índice donde comienza la modificación.

cantidad: Número de elementos a eliminar (si es 0, no se elimina ningún elemento).

elemento1, elemento2, ...: Elementos que se agregarán al array en la posición indicada.

```javascript
deportes.splice(1, 2); // Elimina 2 elementos desde la posición 1
deportes.splice(3, 0, "frontón", "bailes de salón"); // Inserta elementos en la posición 3
deportes.splice(2, 1, "natación", "waterpolo"); // Reemplaza elementos en la posición 2
```

Ejemplo 1: Eliminar elementos:
```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
var eliminados = nombres.splice(1, 2);

console.log(eliminados); // ['Pedro', 'Miguel']
console.log(nombres);    // ['Rita', 'Ana', 'Vanesa']
```

Ejemplo 2: Agregar elementos sin eliminar

```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
nombres.splice(2, 0, "Juan", "Lucía");

console.log(nombres); // ['Rita', 'Pedro', 'Juan', 'Lucía', 'Miguel', 'Ana', 'Vanesa']
```
Ejemplo 3: Reemplazar elementos
```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
nombres.splice(1, 2, "Carlos", "María");

console.log(nombres); // ['Rita', 'Carlos', 'María', 'Ana', 'Vanesa']
```
Ejemplo 4: Eliminar los últimos elementos
```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
var eliminados = nombres.splice(-2);

console.log(eliminados); // ['Ana', 'Vanesa']
console.log(nombres);    // ['Rita', 'Pedro', 'Miguel']
```
Ejemplo 5: Eliminar y agregar elementos al mismo tiempo
```javascript
var nombres = ["Rita", "Pedro", "Miguel", "Ana", "Vanesa"];
nombres.splice(1, 2, "Juan", "Lucía", "Pablo");

console.log(nombres); // ['Rita', 'Juan', 'Lucía', 'Pablo', 'Ana', 'Vanesa']
```

Ejercicio Práctico Combinado

```javascript
var frutas = ["Manzana", "Banana", "Cereza", "Dátil", "Fresa"];

// Usamos slice para extraer las frutas del 2 al 4
var extraidas = frutas.slice(1, 4);
console.log("Extraídas:", extraidas); // ['Banana', 'Cereza', 'Dátil']

// Usamos splice para reemplazar "Cereza" y "Dátil" con "Kiwi" y "Mango"
frutas.splice(2, 2, "Kiwi", "Mango");
console.log("Modificadas:", frutas); // ['Manzana', 'Banana', 'Kiwi', 'Mango', 'Fresa']
```