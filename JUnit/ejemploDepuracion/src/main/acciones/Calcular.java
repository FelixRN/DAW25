package main.acciones;

public class Calcular {

	public Calcular() {
		super();
	}

	public String queHago(String tiempo) {

		String resultado ="andando";
		if (tiempo.equalsIgnoreCase("1") && tiempo.equalsIgnoreCase("3") ) {
			resultado = "en coche";
		} else if (tiempo.equalsIgnoreCase("2")){
			resultado="en bicicleta";
		}
		
		return resultado;
	}

}
