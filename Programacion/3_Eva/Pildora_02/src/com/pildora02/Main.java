package com.pildora02;

import java.util.Scanner;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
       
        System.out.println("Ingrese una contraseña para cifrar:");
        String password = scanner.nextLine();
       
        //Cifrar la contraseña
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        System.out.println("Contraseña cifrada: " + encryptedPassword);
       
        //Verificar la contraseña correcta
        System.out.println("Ingrese la contraseña nuevamente para verificar:");
        String passwordToVerify = scanner.nextLine();
       
        if (passwordEncryptor.checkPassword(passwordToVerify, encryptedPassword)) {
            System.out.println("La contraseña es correcta.");
        } else {
            System.out.println("La contraseña es incorrecta.");
        }
       
        //Crear una contraseña parecida y verificar que es incorrecta
        System.out.println("Ingrese una contraseña parecida para verificar que sea incorrecta:");
        String similarPassword = scanner.nextLine();
       
        if (passwordEncryptor.checkPassword(similarPassword, encryptedPassword)) {
            System.out.println("ERROR: La contraseña parecida fue aceptada (esto no debería suceder).");
        } else {
            System.out.println("Correcto: La contraseña parecida fue rechazada.");
        }
       
        scanner.close();
    }
}