package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcatenarTest {

	@Test
	void testConcatenar() {
		Concatenar claseConcatenar = new Concatenar();
		String resultadoConcatenar = claseConcatenar.concatenar("Sonia", "Elena");
		assertQquals("Sonia Elena", resultadoConcatenar);
		assertNotNull(resultadoConcatenar);
	}

}
