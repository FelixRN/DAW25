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
    void listRooms(List<Room> listR);
    void showRoom(Room room);

    Personal add();
    Room addR();


    int selectIdPersonal();

    Personal editPersonal(Personal personalForEdit);
    Room editRoom(Room roomForEdit);

    void showError(Exception e);
    
    void showMessage(String message);
    
    void editR();

	void deleteR();
	
    int selectIdRoom();
    int selectRoomById();
	
	String selectElementRoom();

	String getText();

	String selectRoomToDelete();
	boolean confirmDelete();
	
	
	
    boolean confirmInventory();  
    void showRoomDetails(Room selectedRoom);  
    boolean confirmPurchase();   
    void completePurchase(Room selectedRoom);
    
	boolean confirmCreateRoom(int roomId);
}
