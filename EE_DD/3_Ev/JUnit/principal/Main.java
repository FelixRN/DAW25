package principal;

import excepciones.MatrizException;

public class Main {
	
	public static void main(String[] args) {
		 
		int opcion;
        String mensaje;
        boolean salir = false;
        
        LanzarAccion lanzarAccion = new LanzarAccion();
        lanzarAccion.inicializarAcciones();

        do {
            System.out.println("Menu");
            System.out.println("1. Rellenar Matriz");
            System.out.println("2. Sumar fila");
            System.out.println("3. Sumar columna");
            System.out.println("4. Calcular media");
            System.out.println("5. Recuperar valor concreto");
            System.out.println("6. Salir");
            System.out.println("Elije una opcion");
            
            try {
				opcion = lanzarAccion.recuperarValorEntrada();
				mensaje = realizarAccion(opcion, lanzarAccion);
	            if (mensaje != "salir") {
	            	System.out.println(mensaje);
	            } else {
	            	salir = true;
	            }
			} catch (MatrizException e) {
				System.out.println(e.getMessage() + " El programa finalizará");
				salir = true;
			}
 
        } while (!salir);
 
        System.out.println("FIN");
        lanzarAccion.terminar();
    }

	public static String realizarAccion(int opcion, LanzarAccion lanzarAccion) {
		
		String mensaje = "";
        
		switch (opcion) {
	        case 1:
	        	mensaje = lanzarAccion.rellenarMatriz();
	            break;
	        case 2:
	            mensaje = lanzarAccion.sumarDatosFila();
	            break;
	        case 3:
	        	mensaje = lanzarAccion.sumarDatosColumna();
	            break;
	        case 4:
	        	mensaje = lanzarAccion.calcularMediaValores();
	            break;
	        case 5:
	        	mensaje = lanzarAccion.recuperarCeldaMatriz();
	            break;
	        case 6:
	            mensaje = "salir";
	            break;
	        default:
	            mensaje = "Tienes que meter un valor entre 1 y 6";
       }
		
		return mensaje;
	}

}