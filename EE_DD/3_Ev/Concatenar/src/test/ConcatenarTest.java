package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Concatenar;

class ConcatenarTest {
	
	private Concatenar concatenar;
	
	@BeforeEach
	void setUp() {
		concatenar = new Concatenar();
	}
	
    @Test
    void testConcatenar1() {
        Concatenar claseConcatenar = new Concatenar();
        String resultadoConcatenar = claseConcatenar.concatenar("Sonia", "Elena");
        assertEquals("Sonia Elena", resultadoConcatenar);
        assertNotNull(resultadoConcatenar);
    }

    
    @Test
    void testConcatenar() {
    	String resultado = concatenar.concatenar("Sonia", "Elena");
    	assertEquals("Sonia Elena,", resultado);
    }
    
    
    
	private void assertNotNull(String resultadoConcatenar) {
		
		
	}

	private void assertEquals(String string, String resultadoConcatenar) {
		
		
	}
}
