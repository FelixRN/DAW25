package com.project04.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project04.model.IModel;
import com.project04.model.entities.Personal;
import com.project04.model.entities.Room;


public class ModelDatabase implements IModel {

    public List<Personal> list() {
        List<Personal> personal = new ArrayList<>();
        String sql = "SELECT * FROM personal";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Personal newPersonal = new Personal(
                	rs.getInt(1),
        			rs.getString(2),
        			rs.getString(3),
        			rs.getInt(4)
                );
                personal.add(newPersonal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personal;
    }

    public Personal add(Personal personal) {
        String sql = "INSERT INTO personal (id_personal, name, occupation, id_room) VALUES (?, ?, ?, ?)";
        String sqlId = "ALTER TABLE personal CHANGE id_personal id_personal int AUTO_INCREMENT";
        String sqlCheckRoom = "SELECT COUNT(*) FROM room WHERE id_room = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlId, PreparedStatement.NO_GENERATED_KEYS)) {
           } catch (SQLException e) {
               e.printStackTrace();
           }
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, personal.getId_personal());
            pstmt.setString(2, personal.getName());
            pstmt.setString(3, personal.getOccupation());
            pstmt.setInt(4, personal.getId_room());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	personal.setId_personal(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new Exception("Error al verificar el room: " + e.getMessage());
        }
        return personal;
    }

    public Personal findById(int idForEdit) {
        String sql = "SELECT * FROM personal WHERE Id = ?";
        Personal personal = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idForEdit);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    personal = new Personal(
                    	rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3),
                		rs.getInt(4)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personal;
    }

    public void removePersonal(Personal personalForRemove) {
        String sql = "DELETE FROM personal WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, personalForRemove.getId_personal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteList() {
        String sql = "DELETE FROM personal";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	@Override
	public void editPersonal(int idForEdit, Personal modifiedPersonal) throws Exception {
		String sql = "UPDATE personal SET Id_personal = ?, Nombre = ?, Ocupación = ?, id_room = ? WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, modifiedPersonal.getId_personal());
            pstmt.setString(2, modifiedPersonal.getName());
            pstmt.setString(3, modifiedPersonal.getOccupation());
            pstmt.setInt(4, modifiedPersonal.getId_room());
            pstmt.setInt(5, idForEdit);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
	public Room findByIdRoom(int idForEdit) {
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