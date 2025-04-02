package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.matriz.Matriz;

public class confirmTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@test
	void testSumaColumna() {
		Matriz.matriz = new Matriz();
		matriz.setMatriz(newint[][]) {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		matriz.setMatrizReellena(tru);
		
		assertEquials(4, matriz.sumaColumna(1));
	}

}
