package com.project04.model.repository;

import com.project04.model.entities.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    // Lista para almacenar rooms (en un escenario real, esto sería una conexión a base de datos)
    private List<Room> rooms = new ArrayList<>();

    public Room add(Room room) {
        // Verificar si ya existe un room con el mismo ID
        if (findByIdRoom(room.getId_room()) != null) {
            throw new IllegalArgumentException("Ya existe un room con este ID");
        }
        rooms.add(room);
        return room;
    }

    public List<Room> list() {
        return new ArrayList<>(rooms); // Devolver una copia para evitar modificaciones directas
    }

    public Room findByIdRoom(int id) {
        return rooms.stream()
                .filter(room -> room.getId_room() == id)
                .findFirst()
                .orElse(null);
    }

    public Room update(Room room) {
        // Eliminar el room existente con el mismo ID
        rooms.removeIf(r -> r.getId_room() == room.getId_room());
        // Añadir el room actualizado
        rooms.add(room);
		return room;
    }

    public void delete(int id) {
        rooms.removeIf(room -> room.getId_room() == id);
    }
}