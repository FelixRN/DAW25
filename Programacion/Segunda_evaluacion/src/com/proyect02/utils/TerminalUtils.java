package com.proyect02.utils;

import java.util.Scanner;

import com.proyect02.view.IMainView;

public class TerminalUtils{
	private static Scanner scanner = new Scanner(System.in);
	
		
	public static String inputText() {
		String result = scanner.nextLine();
		return result;
	}
	
	public static void output(String text) {
		System.out.println(text);
	}
	
	public static int inputInt() {
		int result = Integer.parseInt(scanner.nextLine());
		return result;
	}
}

