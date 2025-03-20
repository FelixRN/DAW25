public class RecursividadFibonachi {
    public static int fibonacci(int MAX) {

		
		if (MAX <= 1) {
			return MAX;
		}

		
		else {
			
			return fibonacci(MAX - 2) + fibonacci(MAX - 1);
		}
	}

	public static void main(String[] args) {

		System.out.println("Recursión Fibonachi");

		int MAX = 10;
		for (int i = 0; i < MAX; i++) {
		System.out.print(fibonacci(i) + " ");
		}
	}
}
