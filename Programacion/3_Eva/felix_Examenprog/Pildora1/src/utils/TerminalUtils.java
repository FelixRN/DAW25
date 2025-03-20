package utils;

import java.util.Scanner;

public class TerminalUtils {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String input() {
        return scanner.nextLine();
    }
    
    public static void output(String text) {
        System.out.println(text);
    }
}