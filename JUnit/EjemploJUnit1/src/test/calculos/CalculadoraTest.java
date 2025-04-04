package test.calculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import calculos.Calculadora;

class CalculadoraTest {

	static Calculadora calc;
	
	@BeforeAll
	static void inicializar() {
		calc = new Calculadora();
	}
	
	@Test
	void testSuma() {
		int resultado = calc.suma(8,3);
		assertEquals(resultado,11);
	}

	@Test
	void testResta() {
		int resultado = calc.resta(10,5);
		assertEquals(resultado,5);
	}

	@Test
	void testMultiplica() {
		float resultado = calc.multiplica(5,6);
		assertEquals(resultado, 30);
	}

	@Test
	void testMultiplica2() {
		float resultado = calc.multiplica(1,1);
		assertNotNull(resultado);
	}
	
	
	@Test
	void testDivide() {
		float resultado = calc.divide(150,3);
		assertEquals(resultado, 50);
	}

}
