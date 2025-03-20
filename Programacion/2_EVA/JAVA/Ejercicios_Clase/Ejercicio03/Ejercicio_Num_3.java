public class Ejercicio_Num_3 {

    public static void main(String[] args) {
        // Crear una instancia de un ordenador de mi casa
        Computer homeComputer;
        Computer SchoolComputer;

        // Y asignar en la variable anterior la instancia del ordenador de mi casa
        //() Indica que es un método
        homeComputer = new Computer();
        homeComputer.cpuName = "Intel";
        System.out.println("Características del ordenador de casa ");
        System.out.println(homeComputer.toString());
        System.out.println(ImprimirInformacionOrdenador(homeComputer));

        SchoolComputer = new Computer();
        SchoolComputer.cpuName = "AMD";
        System.out.println("Características del ordenador del insti");
        System.out.println(SchoolComputer.toString());
        System.out.println(ImprimirInformacionOrdenador(SchoolComputer));
    }

    public static String ImprimirInformacionOrdenador(Computer computer) {
        String result;
        result = "ImprimirInformacionOrdenador - cpuName: " + computer.cpuName
                + ", motherboardName: " + computer.MotherBoard
                + ", graphicCardName: " + computer.GraphicCard
                + ", powerSupplyWs: " + computer.PowerSupplyWs;
        return result;
    }
}

class Computer {
    String cpuName = "Casa";
    String RamGB = "16Gb G.Skill Trident Z RGB DDR4 3200 PC4-25600 16GB 2x8GB CL16";
    String GraphicCard = "AMD Radeon RX 570";
    String HardDisk = "1TB";
    String Processor = "I5 2.9GHz";
    String MotherBoard = "Msi Z390 - A PRO";
    String MouseName = "Razer DeathAdder Essential";
    String KeyboardName = "Razer BlackWidow V3";    
    String PowerSupplyWs = "650W";

public String toString(){
    String result = "toString - cpuName: " + this.cpuName
            + ", motherboardName: " + this.MotherBoard
            + ", graphicCardName: " + this.GraphicCard
            + ", powerSupplyWs: " + this.PowerSupplyWs;
        return result;
}
}

class SchoolComputer {
        String cpuName = "Intel";
        String RamGB = "16GB";
        String GraphicCard = "NVIDIA GTX 1080";
        String HardDisk = "1TB SSD";
        String Processor = "Intel";
        String MotherBoard = "ASUS ROG";
        String MouseName = "Logitech MX";
        String KeyboardName = "Mechanical Keyboard";
        String PowerSupplyWs = "650W";

public String toString() {
    String result = "toString - cpuName: " + this.cpuName
            + ", motherboardName: " + this.MotherBoard
            + ", graphicCardName: " + this.GraphicCard
            + ", powerSupplyWs: " + this.PowerSupplyWs;
        return result;
}
}