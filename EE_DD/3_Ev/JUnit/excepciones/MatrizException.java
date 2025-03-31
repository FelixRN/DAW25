package excepciones;

public class MatrizException extends Exception {

	private int codigoError;
	
	public MatrizException(int codigo) {
		this.codigoError = codigo;
	}
	
	@Override
	public String getMessage() {
		
		String mensaje = "";
		switch (this.codigoError) {
		case 1:
			mensaje = "La matriz no está inicializada";
			break;
		case 2:
			mensaje = "No existe en la matriz la fila indicada";
			break;
		case 3:
			mensaje = "No existe en la matriz la columna indicada";
			break;
		case 4:
			mensaje = "El valor introducido no es del tipo correcto";
			break;
		default:
			mensaje = "Se desconoce la causa del error";
		}
		
		return mensaje;
	}
}
