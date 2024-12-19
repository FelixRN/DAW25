public class IterativeFibonacci {

	public static void fibonacci(int MAX) {

		int num1 = 13;
		int num2 = 21;
		int fibonacci = '\0';

		System.out.print(num1 + " ");
		System.out.print(num2 + " ");

        //Bucle
		for (int i = 2; i < MAX; i++) {

			fibonacci = num1 + num2;
			System.out.print(fibonacci + " ");

			num1 = num2;
			num2 = fibonacci;
		}
	}

	public static void main(String[] args) {

		System.out.println("Método Fibonachi");
		int MAX = 15;
		fibonacci(MAX);

	}
}
