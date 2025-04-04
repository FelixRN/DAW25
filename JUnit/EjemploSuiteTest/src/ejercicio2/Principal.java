package ejercicio2;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String nombre1 = JOptionPane.showInputDialog("Introduzca un nombre");
		String nombre2 = JOptionPane.showInputDialog("Introduzca otro nombre");
		
		Concatenar claseConc = new Concatenar();
		
		claseConc.concatenar(nombre1, nombre2);

	}

}
