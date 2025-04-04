public class SuscripcionTest {

    // Pruebas para el constructor
    @Test
    public void testConstructorValoresPositivos() {
        Suscripcion s = new Suscripcion(100, 2);
        assertEquals(100, s.getPrecio());
        assertEquals(2, s.getPeriodo());
    }

    @Test
    public void testConstructorValoresNegativos() {
        Suscripcion s = new Suscripcion(-50, -1);
        assertEquals(-50, s.getPrecio());
        assertEquals(-1, s.getPeriodo());
    }

    @Test
    public void testConstructorValorCero() {
        Suscripcion s = new Suscripcion(0, 0);
        assertEquals(0, s.getPrecio());
        assertEquals(0, s.getPeriodo());
    }

    // Pruebas para precioPorMes()
    @ParameterizedTest
    @CsvSource({
        "120, 12, 10.0",    // División exacta
        "100, 3, 34.0",      // División con decimales (33.333... se redondea a 34)
        "99, 3, 33.0",       // División exacta
        "1, 1, 1.0",         // Mínimo valor posible
        "100, 1, 100.0",     // Un solo mes
        "2147483647, 1, 2147483647.0", // Valor máximo int
        "2147483647, 2147483647, 1.0"  // Valor máximo ambos
    })
    public void testPrecioPorMesCasosValidos(int precio, int periodo, double esperado) {
        Suscripcion s = new Suscripcion(precio, periodo);
        assertEquals(esperado, s.precioPorMes());
    }

    @ParameterizedTest
    @CsvSource({
        "0, 12",    // Precio cero
        "100, 0",    // Periodo cero
        "0, 0",      // Ambos cero
        "-100, 12",  // Precio negativo
        "100, -3",    // Periodo negativo
        "-50, -2"    // Ambos negativos
    })
    public void testPrecioPorMesCasosInvalidos(int precio, int periodo) {
        Suscripcion s = new Suscripcion(precio, periodo);
        assertEquals(0.0, s.precioPorMes());
    }

    // Pruebas para cancel()
    @Test
    public void testCancel() {
        Suscripcion s = new Suscripcion(100, 12);
        s.cancel();
        assertEquals(0, s.getPeriodo());
        // Verificar que el precio se mantiene igual
        assertEquals(100, s.getPrecio());
    }

    @Test
    public void testPrecioPorMesDespuesDeCancel() {
        Suscripcion s = new Suscripcion(120, 12);
        s.cancel();
        assertEquals(0.0, s.precioPorMes());
    }

    // Pruebas de redondeo
    @ParameterizedTest
    @CsvSource({
        "100, 3, 34.0",    // 33.333... → 34
        "200, 3, 67.0",    // 66.666... → 67
        "10, 3, 4.0",      // 3.333... → 4
        "1, 2, 1.0"        // 0.5 → 1
    })
    public void testPrecioPorMesRedondeo(int precio, int periodo, double esperado) {
        Suscripcion s = new Suscripcion(precio, periodo);
        assertEquals(esperado, s.precioPorMes());
    }

    // Prueba de precisión decimal
    @Test
    public void testPrecioPorMesSinRedondeo() {
        Suscripcion s = new Suscripcion(100, 2);
        assertEquals(50.0, s.precioPorMes());
    }

    // Prueba con valores grandes
    @Test
    public void testPrecioPorMesValoresExtremos() {
        Suscripcion s1 = new Suscripcion(Integer.MAX_VALUE, 1);
        assertEquals((double)Integer.MAX_VALUE, s1.precioPorMes());

        Suscripcion s2 = new Suscripcion(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(1.0, s2.precioPorMes());
    }
}