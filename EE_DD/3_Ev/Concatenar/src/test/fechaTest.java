package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.Fecha;

public class fechaTest {

	@Test
	void testDevuelveFecha() {
		
		Fecha fecha = new Fecha ();
		String resultado = fecha.devuelveFecha(0);
		
		Object testDevuelveFecha = null;
		assertEquals("2025/03",testDevuelveFecha );
	}
}
