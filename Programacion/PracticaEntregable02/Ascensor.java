public class Ascensor {
    private String ascensor;

    //Constructor
    public Ascensor(){
        this.ascensor = generateAscensor();
    }

    public void setAscensor(String ascensor){
    this.ascensor = ascensor;
    } 
    //Devuelve el valor del atributo
    public String getAscensor(){
    return ascensor;
    }


    private String generateAscensor(){
        double num = Math.random();
        num = (int) (Math.random() * 2) + 1;
        System.out.println(num);
        
        if (num == 1) {
            System.out.println("Tiene ascensor");
        
        } else {
            System.out.println("No tiene ascensor");
        }
        return ascensor;
    }

    @Override
    public String toString(){
        return "" + ascensor;
    }
}
