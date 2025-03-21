package calculos;

public class Calculadora {
	
	public Calculadora() {
	}
	
	public int suma (int numero1, int numero2) {
		int resultado = numero1 + numero2;
		return 	resultado;
	}
	
	public int resta (int numero1, int numero2) {
		int resultado = numero1 - numero2;
		return 	resultado;
	}
	
	public int multiplica (int numero1, int numero2) {
		int resultado = numero1 * numero2;
		return 	resultado;
	}
	
	public float divide (int numero1, int numero2) {
		float resultado = 0;
		resultado = numero1 / numero2;
		return 	resultado;
	}
}
