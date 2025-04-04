package armario;

public class Armario {
private Collection<String> ropa = new HashSet<String>();
public Armario() {
super();
}
/**
* Método que introuce la prenda que se le pasa por parámetro en el
armario.
* @param prenda
* @return
*/
public boolean put(String prenda) {
return ropa.add(prenda);
}
/**
* Método que comprueba si en el armario está la prenda que se le pasa
como parámetro
* @param prenda
* @return
*/
public boolean contains(String prenda) {
return ropa.contains(prenda);
}
/**
* Método que saca del armario la prenda que se le pasa como parámetro.
* En caso de que no esté en el armario esa prenda lanzará una excepción.
* @param prenda
* @throws NoSuchItemException
*/
public void take(String prenda) throws NoSuchItemException {
boolean result = ropa.remove(prenda);
if (!result) {
throw new NoSuchItemException(prenda + " no se encuentra en el
armario");
}
}
}
public class NoSuchItemException extends Exception {
public NoSuchItemException(String message) {
super(message);
}
}
