import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear una lista
        List<PaintBucket> paintBucketList;
        paintBucketList = new ArrayList<PaintBucket>();

        // Instanciar y añadir a la lista cinco botes de pintura
        paintBucketList.add(new PaintBucket(1f, "Marca 1", "rojo"));
        paintBucketList.add(new PaintBucket(1.5f, "Marca 1", "azul"));
        paintBucketList.add(new PaintBucket(0.75f, "Marca 1", "gris"));
        paintBucketList.add(new PaintBucket(0.1f, "Marca 1", "blanco"));
        paintBucketList.add(new PaintBucket(5f, "Marca 1", "verde"));

        // recorrer la lista
        for(int i = 0; i < paintBucketList.size(); i++) {
            PaintBucket paintBucket = paintBucketList.get(i);
            // Conversación - Cliente
            System.out.println("Quiero un bote de la marca " + paintBucket.getBrand()
                + " de tamaño " + paintBucket.getLiters() + " y color " + paintBucket.getColorName());
            // Conversación - Vendedor:
            // Si es de más de un litro o igual, tamaño grande
            // Si no, de tamaño pequeño
            String size = paintBucket.getLiters() >= 1 ? "grande" : "pequeño";
            // variable color = ColorUtils.printColorFromName(String colorName)
            String color = ColorUtils.printColorFromName(paintBucket.getColorName());
            // la variable puede no existir
            if(color != null) {
                System.out.println("Para el bote de pintura de marca" + paintBucket.getBrand()
                + " de tamaño " + paintBucket.getLiters() + " y color " + paintBucket.getColorName()
                + " tenemos el código de color " + color + " de tamaño " + size);
            } else {
                System.out.println("No hay existencias para el bote de pintura de marca" + paintBucket.getBrand()
                + " de tamaño " + paintBucket.getLiters() + " y color " + paintBucket.getColorName());
            }
        }
    }
}
