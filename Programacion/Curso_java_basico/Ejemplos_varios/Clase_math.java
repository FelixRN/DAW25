public class Clase_math {
    public static void main(java.lang.String[] args){
        System.out.println(Math.abs(-15)); //Nos devuelve el valor absoluto
        System.out.println(Math.ceil(10.1)); //Nos redondea para arriba
        System.out.println(Math.floor(10.999)); //Nos redondea para abajo

        System.out.println(Math.max(15, 25)); //Nos indica el número más alto
        System.out.println(Math.min(15, 25)); //Nos indica el número más bajo

        System.out.println(Math.round(55.4)); //Nos redondea al número más cercano

        double random = Math.random();
        System.out.println((int)(random * 100) ); //Nos da un número entre 0 y 1 (agregarle el número máximo que quieres multiplicando, en este caso 100
    }
}
