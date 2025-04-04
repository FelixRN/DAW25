package conversor.numerico;

public class ConversorNumerico {
    
    /**
     * Convierte un String a int
     * @param numero String a convertir
     * @return valor entero
     * @throws IllegalArgumentException si el string no representa un entero válido
     * @throws NumberFormatException si el string contiene caracteres no numéricos
     */
    public static int stringAInt(String numero) {
        if (numero == null) {
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        
        if (numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El string no puede estar vacío");
        }
        
        // Verificar si es número real
        if (numero.contains(".") || numero.contains(",")) {
            throw new IllegalArgumentException("No se admiten números reales");
        }
        
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El string '" + numero + "' no es un número entero válido");
        }
    }
}
