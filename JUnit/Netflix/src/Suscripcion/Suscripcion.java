package Suscripcion;

public class Suscripcion {
	private int precio;
	private int periodo;

	public Suscripcion(int p, int n) {
		precio = p;
		periodo = n;
	}

	/**
	 * Calcular precio mensual de la suscripción.
	 */
	public double precioPorMes() {
		if (periodo <= 0 || precio <= 0) {
			return 0;
		}
		double r = (double) precio / (double) periodo;
		double resto = r % 1;
		if (resto > 0)
			return r + 1;
		else
			return r;
	}

	/**
	 * Cancelar la suscripción.
	 */
	public void cancel() {
		periodo = 0;
	}
}
