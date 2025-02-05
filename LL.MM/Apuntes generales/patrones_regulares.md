# Expresiones Regulares

## Patrones y su significado

| Patrón   | Significado |
|----------|------------|
| .        | Cualquier carácter |
| \w       | Cualquier carácter alfanumérico |
| \d       | Un dígito |
| \D       | Cualquier carácter no dígito |
| \s       | Cualquier carácter de espacio |
| \S       | Cualquier carácter de no espacio |
| \d{n}    | n dígitos exactamente. Ej: `\d{4}` indica 4 dígitos |
| \d{n,m}  | De n a m dígitos |
| \d{n,}   | n o más dígitos |
| [xyz]    | Uno de los caracteres x, y o z |
| [A-Z]    | Uno de los caracteres de la A a la Z |
| [^abc]   | Negación de un grupo de caracteres |
| [F-J-[H]]| Sustracción de un carácter de un rango |
| (a|b)    | Alternativa entre dos expresiones |
| (cd)     | Una cadena |

## Cuantificadores

| Cuantificador | Significado |
|--------------|-------------|
| ?           | 0 o 1 ocurrencias |
| *           | 0 o más ocurrencias |
| +           | 1 o más ocurrencias |
| ^           | Ninguno de los caracteres indicados |
| {n}         | n ocurrencias exactas |
| {n,m}       | De n a m ocurrencias |
| {n,}        | n o más ocurrencias |

## Ejemplos de uso

### Ejemplos comunes

1. **Validación de un número de teléfono (formato simple)**  
   ```regex
   \d{9}
   ```
   Esto coincide con un número de 9 dígitos.

2. **Validación de un correo electrónico básico**  
   ```regex
   \w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}
   ```
   Coincide con correos electrónicos como `usuario@example.com`.

3. **Buscar palabras que comiencen con mayúscula**  
   ```regex
   \b[A-Z][a-z]*\b
   ```
   Encuentra palabras que empiezan con mayúscula seguidas de letras minúsculas.

### Ejemplos más complejos

1. **Validación de un número de tarjeta de crédito (Visa, Mastercard, etc.)**  
   ```regex
   ^4[0-9]{12}(?:[0-9]{3})?$
   ```
   Para tarjetas Visa que comiencen con 4 y tengan 13 o 16 dígitos.

2. **Validar una dirección IPv4**  
   ```regex
   \b(?:\d{1,3}\.){3}\d{1,3}\b
   ```
   Coincide con direcciones IP en formato `192.168.0.1`.

3. **Extraer etiquetas HTML**  
   ```regex
   <([^\s>]+)[^>]*>.*?</\1>
   ```
   Encuentra etiquetas HTML con su contenido.

### Formatos específicos

1. **Formato: 8 dígitos y una letra mayúscula (ej. 12345678A)**  
   ```regex
   ^\d{8}[A-Z]$
   ```

2. **Formato: C/NombreCalle Nº1 PA**  
   ```regex
   ^C/\w+\s+Nº\d+\s+PA$
   ```

3. **Formato: Máximo 7 letras, 5 letras o 2 números, y 2 números**  
   ```regex
   ^[A-Za-z]{1,7}(?:[A-Za-z]{5}|\d{2})\d{2}$
   ```

4. **Formato: Que empiece con 2 letras mayúsculas, que contenga números y termine con una minúscula, máximo 5 caracteres y un mínimo de 2**  
   ```regex
   ^[A-Z]{2}\d*[a-z]$

5. **Formato de correo**
[A-Za-z\d]+@[A-Za-z]+\.es