package com.p01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import com.p01.view.MainView;

public class Main {
	public static void main(String[] args) {
		String configPath= "C:\\Users\\USUARIO\\Desktop\\book.config";
		loadConfig(configPath);
		MainView mainView = new MainView();
		mainView.run();
	}
	private static String loadConfig(String configPath) {
		Map<String,String> config = new HashMap<String,String>();
		try {
		Scanner scanner = new Scanner(new File(configPath));
		
		while (scanner.hasNextLine()) {
		String line = scanner.nextLine(); //model_type=memory
		String[] args = line.split("=");
		config.put(args[0], args[1]);
}
		scanner.close();
		}catch  (FileNotFoundException e) {
			e.printStackTrace();
			if(!config.containsKey("model_type")) {
			config.put("model_type","memory");
		}
		return value;
	}
