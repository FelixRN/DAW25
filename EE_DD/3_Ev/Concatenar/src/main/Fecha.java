package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	SimpleDateFormat formato;
	Date hoy;
	
public Fecha() { hoy = new Date(); }

public String devuelveFecha(int tipo) {
	
	String cadena ="";
		switch (tipo) {
		case 1:
			formato = new SimpleDateFormat("yyyy/MM");

			cadena = formato.format(hoy);
			break;
		case 2:
			formato = new SimpleDateFormat("MM/yyyy");
			cadena = formato.format(hoy);
			break;
		case 3:
			formato = new SimpleDateFormat("MM/yy");
			cadena = formato.format(hoy);
			break;
		default: cadena="ERROR";
		}
		return cadena;
	}
}
