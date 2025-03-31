package com.project04.service;

import com.project04.model.entities.Room;
//import com.project04.model.repository.RoomRepository; // Asumo que tienes esta clase de repositorio
import com.project04.model.repository.RoomRepository;


public class RoomService implements RoomService{ 
    private RoomRepository roomRepository;
    
    
    public interface IRoomService {
        Room addNewRoom(int roomId);
    }
   
    
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addNewRoom(int roomId) {
        
        Room newRoom = new Room(roomId, "Nuevo Room", "Descripción predeterminada", roomId);
        
        
        if (roomRepository.findByIdRoom(roomId) != null) {
            throw new IllegalArgumentException("Ya existe un room con este ID");
        }
        
        
        return roomRepository.add(newRoom);
    }

    
    public Room updateRoom(Room room) {
        
        return roomRepository.update(room);
    }

    public void deleteRoom(int roomId) {
        
        roomRepository.delete(roomId);
    }
}
