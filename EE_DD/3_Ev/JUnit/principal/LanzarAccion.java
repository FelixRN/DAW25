package principal;


import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.MatrizException;
import main.matriz.Matriz;

public class LanzarAccion {

	private Matriz matriz;
	private Scanner scanner;

	public LanzarAccion() {
		this.matriz = new Matriz();
	}
	
	public void inicializarAcciones() {
		this.scanner = new Scanner(System.in);	
	}

	public int recuperarValorEntrada() throws MatrizException {
		int valor;
		
		try {
			valor = this.scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new MatrizException(4);
		}
		
		return valor;
	}

	public void terminar() {
		this.scanner.close();	
	}
	
	public String rellenarMatriz() {
		
		int valor;
		for (int i = 0; i < this.matriz.getLongitud(); i++) {
            for (int j = 0; j < this.matriz.getLongitud(); j++) {
 
                System.out.println("Escribe un numero en la posicion " + i + " " + j);
                try {
					valor = this.recuperarValorEntrada();
					this.matriz.setValor(i,j, valor); 
				} catch (MatrizException e) {
					return e.getMessage() + " la matriz no se ha rellenado.";
				}
            }
        }
		
		this.matriz.setMatrizRellena(true);
		
		return "matriz rellena";
	}
	
	public String sumarDatosFila () {
		int fila;
        int resultado;
		
        System.out.println("Elige una fila");

		try {
			fila = this.recuperarValorEntrada();
			resultado = this.matriz.sumaFila(fila);
		} catch (MatrizException e) {
			return e.getMessage();
		}
        
        return "La suma de los valores de la fila " + fila + " es: " + resultado;
	}

	public String sumarDatosColumna() {
		int columna;
        int resultado;
        
        System.out.println("Elige una columna");
        
		try {
			columna = this.recuperarValorEntrada();
			resultado = this.matriz.sumaColumna(columna);
		} catch (MatrizException e) {
			return e.getMessage();
		}
        
        return "La suma de los valores de la columna " + columna + " es: " + resultado;
	}

	public String calcularMediaValores() {
		double resultado;
		
		try {
			resultado = this.matriz.calcularMedia();
		} catch (MatrizException e) {
			return e.getMessage();
		}
		return "La media de los valores de la " + "matriz es de " + resultado;
	}

	public String recuperarCeldaMatriz() {
		int fila, columna, resultado;
        
        try {
        	System.out.println("Elige una fila");
            fila = this.recuperarValorEntrada();
            System.out.println("Elige una columna");
            columna = this.recuperarValorEntrada();
			resultado = this.matriz.getValorConcreto(fila, columna);
		} catch (MatrizException e) {
			return e.getMessage();
		}
        
        return "El valor almacenado en la fila " + fila + " columna " + columna + "es " + resultado;
	}
}
