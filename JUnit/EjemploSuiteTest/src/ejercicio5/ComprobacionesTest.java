package ejercicio5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class ComprobacionesTest {

	@Test
	public void testComprobaciones() {
		Integer[] enteros = {4,5,6,7,8};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		assertEquals(enteros, comprobaciones.getEnteros());
	}
	@Test
	public void testComprobaciones2() {
		assertThrows(IllegalArgumentException.class, () -> {new Comprobaciones(null);});
	}
	@Test
	public void testComprobaciones3() {
		Integer[] enteros = {};
		assertThrows(IllegalArgumentException.class, () -> {new Comprobaciones(enteros);});
	}

	@Test
	public void testSumaEnteros() {
		Integer[] enteros = {1,2,3};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		int resultado = comprobaciones.sumaEnteros();
		assertEquals(6, resultado);
	}

	@Test
	public void testMayorValor() {
		Integer[] enteros = {5,7,2,55};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		int resultado = comprobaciones.mayorValor();
		assertEquals(55,resultado);
	}

	@Test
	public void testPosicionValor() {
		Integer[] enteros = {6,9,22,3,45,12};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		int resultado = comprobaciones.posicionValor(3);
		assertEquals(4, resultado);
	}
	
	@Test
	public void testPosicionValorPrimeraPosicion() {
		Integer[] enteros = {6,9,22,3,45,12};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		int resultado = comprobaciones.posicionValor(6);
		assertEquals(1, resultado);
	}
	
	@Test
	public void testPosicionValorUltimaPosicion() {
		Integer[] enteros = {6,9,22,3,45,12};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		int resultado = comprobaciones.posicionValor(12);
		assertEquals(6, resultado);
	}
	@Test
	public void testPosicionValor2() {
		Integer[] enteros = {6,9,22,3,45,12};
		Comprobaciones comprobaciones = new Comprobaciones(enteros);
		assertThrows(NoSuchElementException.class, () -> {comprobaciones.posicionValor(15);});
	}

}
