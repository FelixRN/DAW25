package ejercicio5;

import java.util.NoSuchElementException;

public class Comprobaciones {

	private Integer[] enteros;
	
	Comprobaciones (Integer[] enteros){
		if(enteros == null || enteros.length == 0) {
			throw new IllegalArgumentException("No hay elementos");
		}
		this.enteros = enteros;
	}
	
	public int sumaEnteros() {
		int resultado = 0;
		for(int cont=0; cont< enteros.length; cont++) {
			resultado = resultado + enteros[cont];
		}
		return resultado;
	}
	
	public int mayorValor() {
		int mayor = -999;
		for(int cont=0; cont< enteros.length; cont++) {
			if (enteros[cont] > mayor) {
				mayor = enteros[cont];
			}
		}
		return mayor;
	}
	
	public int posicionValor(int valor) {
		for(int cont=0; cont< enteros.length; cont++) {
			if (enteros[cont] == valor) {
				return cont+1;
			}
		}
		throw new NoSuchElementException("El valor "+valor+" no se encuentra en la tabla");
	}

	public Integer[] getEnteros() {
		return enteros;
	}

	public void setEnteros(Integer[] enteros) {
		this.enteros = enteros;
	}	
}
