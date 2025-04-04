package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ConcatenarTest {

	@Test
	public void testConcatenar() {
		Concatenar conc = new Concatenar();
		
		String resultado = conc.concatenar("Sonia", "Elena");
		assertNotNull(resultado);
		assertEquals("SoniaElena", resultado);
	}

}
