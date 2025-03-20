# Caso Base
- Cuando en número sea menor que 10, la respuesta es 1 dígito

# Caso recursivo
- Dividir el numero entre 10
- Contar +1 dig
- Llamada recursiva, con el nuevo valor.

## Problemas al introducir el código: 

- No llamo correctamente al metodo "contarDigitos" de la clase "ContarDigitos" y necesito instanciar un objeto de esta clase par ausarlo ya que no es estático. 

```java
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa un número: ");
    int numero = scanner.nextInt();
    System.out.println(contarDigitos); //Mal ingresado
    }
    public class ContarDigitos {
        public int contarDigitos(int numero){ //Resivimos por parametro el número en cuestion
            int res;
            if (numero < 10) {
                res = 1;
            }else{
                numero = numero/10;
                res = 1+ contarDigitos(numero);
            }
        return res;
        }
    }
```
Para solucionarlo tenemos 2 maneras

### 1º: Convertir "ContarDigitos" en una clase independiente
```java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un número: ");
        int numero = scanner.nextInt();

        ContarDigitos contador = new ContarDigitos();//Crear una instancia de ContarDigitos
        int digitos = contador.contarDigitos(numero); // Llamar al método
        System.out.println("El número de dígitos es: " + digitos);
    }
}
// Clase independiente para contar los dígitos
class ContarDigitos {
    public int contarDigitos(int numero) {
        // Asegurar que funcione para números negativos
        numero = Math.abs(numero); 
        if (numero < 10) {
            return 1;
        } else {
            return 1 + contarDigitos(numero / 10);
        }
    }
}
```
### 2º: Hacer "ContarDigitos" una clase estática interna

```java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un número: ");
        int numero = scanner.nextInt();

        int digitos = ContarDigitos.contarDigitos(numero); // Llamar al método estático
        System.out.println("El número de dígitos es: " + digitos);
    }

    // Clase interna estática para que este anidada
    public static class ContarDigitos {
        public static int contarDigitos(int numero) {
            numero = Math.abs(numero); // Asegurar que funcione con negativos
            if (numero < 10) {
                return 1;
            } else {
                return 1 + contarDigitos(numero / 10);
            }
        }
    }
}

```