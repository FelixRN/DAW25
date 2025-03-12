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

Ejemplo de `splice()`:
```javascript
deportes.splice(1, 2); // Elimina 2 elementos desde la posición 1
deportes.splice(3, 0, "frontón", "bailes de salón"); // Inserta elementos en la posición 3
deportes.splice(2, 1, "natación", "waterpolo"); // Reemplaza elementos en la posición 2
```

