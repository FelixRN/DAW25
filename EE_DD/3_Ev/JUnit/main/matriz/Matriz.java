package main.matriz;

import excepciones.MatrizException;

public class Matriz {

    private int matriz[][];
    private boolean matrizRellena = false;

	public Matriz() {
		this.setMatriz(new int[4][4]);
	}
 
    /**
     * Suma los valores de una determinada fila
     * @param fila
     * @return
     * @throws MatrizException 
     */
    public int sumaFila(int fila) throws MatrizException {
 
        int suma = 0;
 
        if (isMatrizRellena()) {
        	if (fila > 0 && fila <= this.getLongitud()) {
        		for (int j = 0; j < this.matriz.length; j++) {
                    suma += this.matriz[fila-1][j];
                }
        	} else {
        		throw new MatrizException(2);
        	}
        } else {
        	throw new MatrizException(1);
        }
 
        return suma;
 
    }
 
    /**
     * Suma los valores de una determinada columna
     * @param columna
     * @return
     * @throws MatrizException 
     */
    public int sumaColumna(int columna) throws MatrizException {
 
    	int suma = 0;
    	 
        if (isMatrizRellena()) {
        	if (columna > 0 && columna <= this.getLongitud()) {
	        	for (int i = 0; i < matriz.length; i++) {
	                suma += matriz[i][columna-1];
	            }
        	}else {
        		throw new MatrizException(3);
        	}
        } else {
        	throw new MatrizException(1);
        }
 
        return suma;
    }
 
    /**
     * Media de todos los elementos de la matriz
     * @return
     * @throws MatrizException
     */
    public double calcularMedia() throws MatrizException {
 
        double suma = 0, media = 0;
 
        if (isMatrizRellena()) {
	        for (int i = 0; i < this.matriz.length; i++) {
	            for (int j = 0; j < this.matriz[0].length; j++) {
	                suma += this.matriz[i][j];
	            }
	        }
	        media = suma / (this.matriz.length * this.matriz.length);
        } else {
        	throw new MatrizException(1);
        }
        return media;
 
    }
    
    /**
     * Método que devuelve el valor almacenado en una posición concreta
     * @param fila
     * @param columna
     * @return
     * @throws MatrizException
     */
    public int getValorConcreto(int fila, int columna) throws MatrizException {
    	
    	 if (isMatrizRellena()) {
	    	if (fila < 0 || fila >= this.getLongitud()) {
	    		throw new MatrizException(2);
	    	} else {
	    		if (columna < 0 || columna >= this.getLongitud()) {
	    			throw new MatrizException(3);	
	    		} else {
	    			return this.matriz[fila][columna];
	    		}
	    	}
    	 } else {
    		 throw new MatrizException(1);
    	 }
    }
    
	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int matriz[][]) {
		this.matriz = matriz;
	}

	public int getLongitud() {
		return this.matriz.length;
	}

	public void setValor(int i, int j, int valor) {
		this.matriz[i][j] = valor;
	}

	public boolean isMatrizRellena() {
		return matrizRellena;
	}

	public void setMatrizRellena(boolean matrizRellena) {
		this.matrizRellena = matrizRellena;
	}    
}
