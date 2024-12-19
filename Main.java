import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		String configPath= "C:\\Users\\USUARIO\\Desktop\\book.config";
		boolean resulti = saveConfig(configPath, "model_type=memory");
		System.out.println("El resultado de escribir el fichero: " + result);
        //String fileValue = loadConfig(configPath);
		//System.out.println("file value " + fileValue);
	}

	private static String loadConfig(String configPath) {
    String value = "";
	try {
		Scanner scanner = new Scanner (new File(configPath));

		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			value += line + "\n";
			
        //value.append(line.append("\n)"));
		}
		scanner.close();
    } catch  (FileNotFoundException e) {
	e.printStackTrace();
	value = "model_type=memory";
}
return value;
}

private static boolean saveConfig(String confiPath){
	try{
		FileOutputStream fout=new FileOutputStream(configPath);
		String s = "Welcome to javaTpoint";
		byte b[] = s.getBytes();//CONVERTING STRING INTO BYTE ARRAY
		fout.write(b);
		fout.close();
		System.out.println("Success");
		return true;
	} catch(Exception e){
		System.out.println(e);
		return false;
	}
}

}