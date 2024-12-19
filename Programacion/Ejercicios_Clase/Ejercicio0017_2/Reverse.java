public class Reverse {
    public static void main(String[] args) {

		String input1 = "A B C";
		StringBuilder inputText1 = new StringBuilder(input1);
		System.out.println("reverse(" + inputText1 + ") = " + inputText1.reverse());

		String input2 = "0 1 2 2 3 3 3";
		StringBuilder inputText2 = new StringBuilder(input2);
		System.out.println("reverse(" + inputText2 + ") = " + inputText2.reverse());

		String input3 = "Monday";
		StringBuilder inputText3 = new StringBuilder(input3);
		System.out.println("reverse(" + inputText3 + ") = " + inputText3.reverse());

		String input4 = "I love CodeGym!";
		StringBuilder inputText4 = new StringBuilder(input4);
		System.out.println("reverse(" + inputText4 + ") = " + inputText4.reverse());

		StringBuilder inputText5 = new StringBuilder("Reverse this String using StringBuilder Class.");
		System.out.println("reverse(" + inputText5 + ") = " + inputText5.reverse());

		StringBuffer inputText6 = new StringBuffer("Reverse this String using StringBuffer Class.");
		System.out.println("reverse(" + inputText6 + ") = " + inputText6.reverse());
	}
}
