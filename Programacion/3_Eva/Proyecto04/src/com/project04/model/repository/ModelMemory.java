package com.project04.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.project04.model.IModel;
import com.project04.model.entities.Personal;
import com.project04.model.entities.Room;



public class ModelMemory implements IModel {

    private List<Personal> list;
    private int autoIncrementId;

    public ModelMemory() {
        list = new ArrayList<>();
        autoIncrementId = 1;
    }

    @Override
    public List<Personal> list() {
        return list;
    }

    @Override
    public Personal add(Personal personal) {
        list.add(personal);
        personal.setId_personal(autoIncrementId);
        return personal;
    }

    @Override
    public Personal findById(int idForEdit) {
        Personal personal = null;

        for(Personal i : list) {
            if(i.getId_personal() == idForEdit) {
                personal = i.clone();
            }
        }

        return personal;
    }

    @Override
    public void editPersonal(int idForEdit, Personal modifiedPersonal) throws Exception {
        Personal findPersonal = null;
        for(Personal personal : list) {
            if(personal.getId_personal() == idForEdit) {
                findPersonal = personal;
            }
        }

        if(findPersonal == null) {
            throw new Exception("Personal not found");
        }

        int indexOfPersonal = list.indexOf(findPersonal);

        list.set(indexOfPersonal, modifiedPersonal);
    }

    @Override
    public void removePersonal(Personal personalForRemove) throws Exception {
        int indexOfPersonal = -1;
        for(Personal personal : list) {
            if(personal.equals(personalForRemove)) {
                indexOfPersonal = list.indexOf(personal);
            }
        }

        if(indexOfPersonal == -1) {
            throw new Exception("Personal not found");
        }

        list.remove(indexOfPersonal);
    }

	@Override
	public List<Room> listR() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room add(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room findByIdRoom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editRoom(int idForEdit, Room modifiedRoom) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoom(Room roomForRemove) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
