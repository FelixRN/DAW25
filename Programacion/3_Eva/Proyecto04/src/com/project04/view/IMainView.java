package com.project04.view;

import java.util.List;

import com.project04.model.entities.Personal;
import com.project04.model.entities.Room;


public interface IMainView {

	int mainMenu();
	int inventoryMenu(); 
    int customerMenu();
    
    void exit();

    void list(List<Personal> list);

    Personal add();

    int selectIdPersonal();

    Personal editPersonal(Personal personalForEdit);

    void showError(Exception e);
    
    void showMessage(String message);

    

    Room addR();

    void editR();

	void deleteR();
	
    int selectIdRoom();

    Room editRoom(Room roomForEdit);
	
	String selectElementRoom();

	String getText();

	String selectRoomToDelete();
	boolean confirmDelete();
	
	
    boolean confirmInventory();  
    void showRoomDetails(Room room);  
    boolean confirmPurchase();   
    void completePurchase(Room room);
}
