# Sentencias de control

## If-else

Estructura de control que ejecuta un bloque de código si se cumple una condición.
__Puede__ tener varios bloques con su condición que se van ejecutando en cascada si no se cumple la condición del bloque anterior.
Si no se cumple ninguna condición __puede__ ejecutarse un bloque llamado `else`.

### Estructura

```
if (condición) {
    // Si SI cumple la condición
}
// No es obligatorio
else if (condición2) {
    // Si SI cumple la condición2
}
// No es obligatorio
else {
    // Si NO cumple ninguna condición
}
```

## Switch

Estructura de control que ejecuta un bloque de código si se cumple un valor.
__Puede__ tener varios casos con sus bloques.
Si no se cumple ninguna condición __puede__ ejecutarse un bloque llamado `default`.
Después de cada bloque se usa `break` para indicar que termina el bloque (se puede no poner y ejecutaría el bloque siguiente).

### Estructura

```
switch(valor) {
    case valor1:
        // Si SI valor == valor1
        break;
    // No es obligatorio
    case valor2:
        // Si SI valor == valor2
        break;
    // No es obligatorio pero recomendable
    default:
        // Si ningún case es igual al valor
}
```

## Ternary



### Estructura

Estructura de control que asigna a una variable, dependiendo de una condición, un valor para el caso verdadero u otro valor para el caso falso.

```
variable variableName = (condición) ? valorSiVerdadero : valorSiFalso;
```
