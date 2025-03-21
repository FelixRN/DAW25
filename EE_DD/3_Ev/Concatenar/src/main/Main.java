package main;

import java.util.Scanner;

public class Main {

		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nombre1 = sc.nextLine();
		String nombre2 = sc.nextLine();
		
		Concatenar concatenarCadenas = new Concatenar();
		concatenarCadenas.concatenar(nombre1, nombre2);
}
}