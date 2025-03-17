package main.principal;

import javax.swing.JOptionPane;

import main.acciones.Calcular;

public class Principal {

	public static void main(String[] args) {
		
		Calcular calcular = new Calcular();
		String tiempo = JOptionPane.showInputDialog( "Introduzca 1 si llueve, 2 si hace sol o 3 si nieva:" );
		String resultado = calcular.queHago(tiempo);
		
		//Si llueve o nieva que vaya en metro, si no en bicicleta
        System.out.println ("Hoy vete a trabajar " + resultado); 

	}

}
