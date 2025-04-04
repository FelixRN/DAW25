package ejercicios3_4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FechaTest {

	private static Fecha fecha;
	
	/**
	 * En este método de inicilaizar se podrían inicializar variables que contuvieran
	 * el formato esperado para la fecha actual y no tener que cambiar las pruebas cada día que 
	 * se vayan a probar.
	 */
	@BeforeAll
	public static void inicialiar() {
		fecha = new Fecha();
	}
	
	@Test
	public  void testDevuelveFecha1() throws Exception {
		String resultado = fecha.devuelveFecha(1);
		assertEquals("2020/05", resultado);
	}
	
	@Test
	public  void testDevuelveFecha2() throws Exception {
		String resultado = fecha.devuelveFecha(2);
		assertEquals("05/2020", resultado);
	}
	
	@Test
	public  void testDevuelveFecha3() throws Exception {
		String resultado = fecha.devuelveFecha(3);
		assertEquals("05/20", resultado);
	}
	
	@Test
	public  void testDevuelveFechaException() throws Exception {
		assertThrows(Exception.class, () -> fecha.devuelveFecha(4));
	}

}
