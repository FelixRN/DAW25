package test.conversor.numerico;


public class ConversorNumericoTest {

    // Pruebas de conversión correcta
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "-1", "12345", "-54321", " 42 ", "2147483647", "-2147483648"})
    public void testConversionesCorrectas(String input) {
        assertDoesNotThrow(() -> {
            int resultado = ConversorNumerico.stringAInt(input);
            assertEquals(Integer.parseInt(input.trim()), resultado);
        });
    }

    // Pruebas de valores nulos o vacíos
    @Test
    public void testStringNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ConversorNumerico.stringAInt(null);
        });
        
        assertEquals("El valor no puede ser nulo", exception.getMessage());
    }

    @Test
    public void testStringVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ConversorNumerico.stringAInt("");
        });
        
        assertEquals("El string no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testStringSoloEspacios() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ConversorNumerico.stringAInt("   ");
        });
        
        assertEquals("El string no puede estar vacío", exception.getMessage());
    }

    // Pruebas de números reales
    @ParameterizedTest
    @ValueSource(strings = {"3.14", "2,5", "-123.456", "0.0", "1."})
    public void testNumerosReales(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ConversorNumerico.stringAInt(input);
        });
        
        assertEquals("No se admiten números reales", exception.getMessage());
    }

    // Pruebas de formatos incorrectos
    @ParameterizedTest
    @ValueSource(strings = {"abc", "123a", "1-2-3", "", "  ", "++1", "--1", "1.2.3"})
    public void testFormatosInvalidos(String input) {
        assertThrows(NumberFormatException.class, () -> {
            ConversorNumerico.stringAInt(input);
        });
    }

    // Prueba de límites de int
    @Test
    public void testNumeroDemasiadoGrande() {
        assertThrows(NumberFormatException.class, () -> {
            ConversorNumerico.stringAInt("2147483648"); // INT_MAX + 1
        });
    }

    @Test
    public void testNumeroDemasiadoPequeno() {
        assertThrows(NumberFormatException.class, () -> {
            ConversorNumerico.stringAInt("-2147483649"); // INT_MIN - 1
        });
    }
}
