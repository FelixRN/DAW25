package armario;

public class armario {

}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

public class ArmarioTest {

    private Armario armario;

    @BeforeEach
    public void setUp() {
        armario = new Armario();
    }

    // Pruebas para el método put()
    @Test
    public void testPut_PrendaNueva_DevuelveTrue() {
        assertTrue(armario.put("camisa"));
    }

    @Test
    public void testPut_PrendaExistente_DevuelveFalse() {
        armario.put("pantalón");
        assertFalse(armario.put("pantalón")); // No se puede añadir dos veces
    }

    @Test
    public void testPut_PrendaNull_DevuelveFalse() {
        assertFalse(armario.put(null));
    }

    @Test
    public void testPut_MultiplesPrendas_TodasSeAñaden() {
        armario.put("camisa");
        armario.put("pantalón");
        armario.put("chaqueta");
        
        assertTrue(armario.contains("camisa"));
        assertTrue(armario.contains("pantalón"));
        assertTrue(armario.contains("chaqueta"));
    }

    // Pruebas para el método contains()
    @Test
    public void testContains_PrendaExistente_DevuelveTrue() {
        armario.put("vestido");
        assertTrue(armario.contains("vestido"));
    }

    @Test
    public void testContains_PrendaNoExistente_DevuelveFalse() {
        assertFalse(armario.contains("abrigo"));
    }

    @Test
    public void testContains_PrendaNull_DevuelveFalse() {
        assertFalse(armario.contains(null));
    }

    @Test
    public void testContains_DespuesDeTake_DevuelveFalse() throws NoSuchItemException {
        armario.put("bufanda");
        armario.take("bufanda");
        assertFalse(armario.contains("bufanda"));
    }

    // Pruebas para el método take()
    @Test
    public void testTake_PrendaExistente_EliminaPrenda() throws NoSuchItemException {
        armario.put("sombrero");
        armario.take("sombrero");
        assertFalse(armario.contains("sombrero"));
    }

    @Test
    public void testTake_PrendaNoExistente_LanzaExcepcion() {
        assertThrows(NoSuchItemException.class, () -> {
            armario.take("cinturón");
        });
    }

    @Test
    public void testTake_PrendaNull_LanzaExcepcion() {
        assertThrows(NoSuchItemException.class, () -> {
            armario.take(null);
        });
    }

    @Test
    public void testTake_MensajeExcepcionEsCorrecto() {
        Exception exception = assertThrows(NoSuchItemException.class, () -> {
            armario.take("zapatos");
        });
        
        assertEquals("zapatos no se encuentra en el armario", exception.getMessage());
    }

    // Pruebas de integración entre métodos
    @Test
    public void testPutTakeContains_FlujoCompleto() throws NoSuchItemException {
        assertFalse(armario.contains("suéter"));
        
        assertTrue(armario.put("suéter"));
        assertTrue(armario.contains("suéter"));
        
        armario.take("suéter");
        assertFalse(armario.contains("suéter"));
    }

    // Prueba para verificar la colección subyacente
    @Test
    public void testColeccionRopaNoEsAccesibleExternamente() {
        armario.put("camiseta");
        Collection<String> ropa = armario.getRopa(); // Asumiendo que existe un getter
        
        assertThrows(UnsupportedOperationException.class, () -> {
            ropa.add("intruso"); // Debería fallar si es un Collections.unmodifiableCollection
        });
    }
}