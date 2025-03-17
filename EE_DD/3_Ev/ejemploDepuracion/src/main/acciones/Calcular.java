package main.acciones;

public class Calcular {

	public Calcular() {
		super();
		// TODO Apéndice de constructor generado automáticamente
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
