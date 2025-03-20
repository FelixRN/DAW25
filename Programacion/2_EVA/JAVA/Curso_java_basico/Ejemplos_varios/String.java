//String
public class String {
    public static void main(java.lang.String[] args) {
       java.lang.String text = "Hola Mundo!";

       int largo = text.length();
        System.out.println(largo);

        java.lang.String texto = text.replace("Hola", "Chao");
        System.out.println(texto);

        System.out.println(texto.endsWith("!"));
        System.out.println(texto.startsWith("Ch"));
        System.out.println(texto.contains("und"));
        System.out.println(texto.indexOf("o"));

        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());

        java.lang.String malo = "    chanchito  feliz   ";
        System.out.println(malo.trim());
        System.out.println(malo);
    }
}