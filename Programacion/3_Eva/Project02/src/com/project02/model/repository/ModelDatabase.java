package com.project02.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project02.model.IModel;
import com.project02.model.entities.Car;

public class ModelDatabase implements IModel {

    public List<Car> list() {
        List<Car> coches = new ArrayList<>();
        String sql = "SELECT * FROM coches";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Car newCoche = new Car(
                	rs.getInt(1),
        			rs.getString(2),
        			rs.getString(3),
        			rs.getFloat(4),
        			rs.getInt(5),
        			rs.getString(6)
                );
                coches.add(newCoche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }

    public Car add(Car car) {
        String sql = "INSERT INTO coches (Id, Marca, Modelo, Consumo, Emisiones, Imagen) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlId = "ALTER TABLE coches CHANGE id id int AUTO_INCREMENT";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlId, PreparedStatement.NO_GENERATED_KEYS)) {
           } catch (SQLException e) {
               e.printStackTrace();
           }
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, car.getId());
            pstmt.setString(2, car.getBrand());
            pstmt.setString(3, car.getModel());
            pstmt.setFloat(4, car.getConsume());
            pstmt.setInt(5, car.getEmissions());
            pstmt.setString(6, car.getImagen());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	car.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public Car findById(int idForEdit) {
        String sql = "SELECT * FROM coches WHERE Id = ?";
        Car coches = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idForEdit);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    coches = new Car(
                    	rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3),
                		rs.getFloat(4),
            			rs.getInt(5),
                		rs.getString(6)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }

    public void removeCar(Car cochesForRemove) {
        String sql = "DELETE FROM coches WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cochesForRemove.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteList() {
        String sql = "DELETE FROM coches";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	@Override
	public void editCar(int idForEdit, Car modifiedCar) throws Exception {
		String sql = "UPDATE coches SET Id = ?, Marca = ?, Modelo = ?, Consumo = ?, Emisiones = ?, Imagen = ? WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, modifiedCar.getId());
            pstmt.setString(2, modifiedCar.getBrand());
            pstmt.setString(3, modifiedCar.getModel());
            pstmt.setFloat(4, modifiedCar.getConsume());
            pstmt.setInt(5, modifiedCar.getEmissions());
            pstmt.setString(6, modifiedCar.getImagen());
            pstmt.setInt(7, idForEdit);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
