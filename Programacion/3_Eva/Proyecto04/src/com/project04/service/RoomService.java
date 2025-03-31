package com.project04.service;

import com.project04.model.entities.Room;
//import com.project04.model.repository.RoomRepository; // Asumo que tienes esta clase de repositorio
import com.project04.model.repository.RoomRepository;

public class RoomService {
    private RoomRepository roomRepository;
    
    public interface IRoomService {
        Room addNewRoom(int roomId);
    }
   
    // Constructor para inyección de dependencias
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addNewRoom(int roomId) {
        // Lógica para crear un nuevo room con valores predeterminados
        Room newRoom = new Room(roomId, "Nuevo Room", "Descripción predeterminada", roomId);
        
        // Validaciones adicionales (opcional)
        if (roomRepository.findByIdRoom(roomId) != null) {
            throw new IllegalArgumentException("Ya existe un room con este ID");
        }
        
        // Guardar en el repositorio
        return roomRepository.add(newRoom);
    }

    // Otros métodos de servicio que necesites
    public Room updateRoom(Room room) {
        // Lógica de validación antes de actualizar
        return roomRepository.update(room);
    }

    public void deleteRoom(int roomId) {
        // Lógica de validación antes de eliminar
        roomRepository.delete(roomId);
    }
}
