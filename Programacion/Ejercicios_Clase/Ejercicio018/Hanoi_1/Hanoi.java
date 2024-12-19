package Hanoi_1;

public class Hanoi {
    public void resolver(int numeroDisc, String origen, String auxiliar, String destino) {
        if (numeroDisc == 1) {
            System.out.println("- Mover disco de " + origen + " a " + destino);
        } else {
            resolver(numeroDisc - 1, origen, destino, auxiliar); // Paso 1
            System.out.println("- Mover disco de " + origen + " a " + destino); // Paso 2
            resolver(numeroDisc - 1, auxiliar, origen, destino); // Paso 3
        }
    }
}

