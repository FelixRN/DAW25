package com.pildora02;

public class Main {
	public static void main(String[] args) {
		System.out.println("Pildora para la gestión de paquetes");
		System.out.println("-----------------------");
		
		
		Argon2 argon2 = Argon2Factory.create();
		
		char[] password = readPasswordFromUser();

		try {
		   
		    String hash = argon2.hash(10, 65536, 1, password);

		    // Verify password
		    if (argon2.verify(hash, password)) {
		        // Hash matches password
		    } else {
		        // Hash doesn't match password
		    }
		} finally {
		    // Wipe confidential data
		    argon2.wipeArray(password);
		}
		
		System.out.println("Paquete de cifrado");
		System.out.println("- Dada una contraseña, cifrarla");
		System.out.println("- Verificar que la contraseña es correcta");
		System.out.println("- Crear una contraseña parecida, y verificar que es incorrecta");
		
	}

	private static char[] readPasswordFromUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
