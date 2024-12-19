public class Main {
    public static void main(String[] args) {
        // Para cada tipo de bucle vamos a
        // imprimir desde el -2 al 7
        loopFor();
        loopWhile();
        loopDoWhile();
    }

    public static void loopFor() {
        int min = -2;
        int max = 7;
        System.out.println("Bucle for de " + min + " a "+ max);
        for(int i = min; i <= max; i++) {
            System.out.println(i+"");
        }
    }
    
    public static void loopWhile() {
        int min = -2;
        int max = 7;
        System.out.println("Bucle while de " + min + " a "+ max);
        
        int i = min;
        while (i >= min && i <= max) {
            System.out.println(i+"");
            i++;
        }
    }
    
    public static void loopDoWhile() {
        int min = -2;
        int max = 7;
        System.out.println("Bucle do-while de " + min + " a "+ max);
        
        int i = min;
        do {
            System.out.println(i+"");
            i++;
        } while (i >= min && i <= max);
    }
}
