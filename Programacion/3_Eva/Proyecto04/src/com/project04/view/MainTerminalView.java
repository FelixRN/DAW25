package com.project04.view;

import java.util.List;

import com.project04.model.entities.Personal;
import com.project04.model.entities.Room;
import com.project04.utils.TerminalUtils;


public class MainTerminalView implements IMainView {
	public void listRooms(List<Room> rooms) {
		for (Room room : rooms) {
			System.out.println(room);
		}
	}
	
	public int selectRoomById() {
		System.out.print("Ingrese el ID del room: ");
		return TerminalUtils.inputInt();
	}
	
	public void showRoom(Room room) {
		System.out.println("Detalles del Room");
		System.out.println(room);
	}

	@Override
	public int mainMenu() {
		int option;
		
		TerminalUtils.output("Menú del personal");
		TerminalUtils.output("================");

		TerminalUtils.output("1.- Listar personal");
		TerminalUtils.output("2.- Añadir personal");
		TerminalUtils.output("3.- Editar personal");
		TerminalUtils.output("4.- Eliminar personal");
		TerminalUtils.output("0.- Salir");
		
		try {
			option = TerminalUtils.inputInt();
		} catch (Exception e) {
			option = -1;
		}
		
		return option;
	}
	
	@Override
    public int customerMenu() {
        int option;
        
        TerminalUtils.output("\n===== Gestion room =====");
        TerminalUtils.output("1.- Ver todos los rooms disponibles");
        TerminalUtils.output("2.- Seleccionar un room");
        TerminalUtils.output("0.- Salir");
        TerminalUtils.output("Seleccione una opción: ");
        
        try {
            option = TerminalUtils.inputInt();
        } catch (Exception e) {
            option = -1;
        }
        
        return option;
    }
	
	
	

	public void exit() {
		TerminalUtils.output("Adios");
	}

	@Override
	public void list(List<Personal> list) {
		TerminalUtils.output("Lista de personal");
		TerminalUtils.output("id_personal - Nombre - Ocupación - Id_room");
		
		for(Personal personal : list) {
			TerminalUtils.output(personal.toString());
		}
	}
	
	@Override
	public Personal add() {
		TerminalUtils.output("Nuevo personal");
		TerminalUtils.output("================");

		TerminalUtils.output("Introduzca el id");
		int id_personal = TerminalUtils.inputInt();
		
		TerminalUtils.output("Introduzca la nombre");
		String name = TerminalUtils.inputText();
		
		TerminalUtils.output("Introduzca la ocupacion");
		String occupation = TerminalUtils.inputText();
		
		TerminalUtils.output("Introduzca la id_room");
		int id_room = TerminalUtils.inputInt();
		
		Personal personal = new Personal (0, name, occupation, id_room);
		return personal;
	}
	
	@Override
	public int selectIdPersonal() {
		TerminalUtils.output("Introduzca el id:");
		int id = TerminalUtils.inputInt();
		return id;
	}

	@Override
	public Personal editPersonal(Personal personalForEdit) {
		TerminalUtils.output("Editar Personal");
		TerminalUtils.output("================");

		TerminalUtils.output("Introduzca un nuevo nombre (si lo deja vacío no se modificará)");
		String name = TerminalUtils.inputText();
		if(isValidString(name)) {
			personalForEdit.setName(name);
		}

		TerminalUtils.output("Introduzca una nueva ocupación (si lo deja vacío no se modificará)");
		String occupation = TerminalUtils.inputText();
			personalForEdit.setOccupation(occupation);
			
		TerminalUtils.output("Introduzca el nuevo id_room (si lo deja vacío no se modificará)");
		int id_room = TerminalUtils.inputInt();
			personalForEdit.setId_room(id_room);
		
		
		return personalForEdit;
	}
	
	public boolean isValidString(String value) {
		return value != null && !value.isEmpty() && !value.isBlank();
	}

	@Override
	public void showError(Exception e) {
		TerminalUtils.output(e.getMessage());
	}

	@Override
	public int inventoryMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Room addR() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room editRoom(Room roomForEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editR() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteR() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectIdRoom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectElementRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectRoomToDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean confirmDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmInventory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showRoomDetails(Room selectedRoom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmPurchase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void completePurchase(Room selectedRoom) {
		// TODO Auto-generated method stub
		
	}
}
