package calculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	static Calculadora calc;
	
	@BeforeAll
	static void inicializar() {
		calc = new Calculadora();
	}
	
	@Test
	void testSuma() {
		
	}

	@Test
	void testResta() {
	}

	@Test
	void testMultiplica() {
		float resultado = calc.multiplica(5,6);
		assertEquals(resultado, 30);
		assertNull(resultado);
	}

	@Test
	void testDivide() {
		float resultado = calc.divide(150,3);
		assertEquals(resultado, 50);
	}
}
