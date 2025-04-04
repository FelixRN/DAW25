package com.project05.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project05.model.entities.User;
import com.project05.model.repository.DatabaseConnection;
import com.project05.model.entities.Rol;

public class Model {
	

	
    public List<User> listU() {
    	
    	public List<User> listU() throws Exception {
            List<User> users = new ArrayList<>();
            try (Connection connection = DatabaseConnection.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {

                while (resultSet.next()) {
                    User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password")
                    );
                    users.add(user);
                }
            } catch (SQLException e) {
                throw new Exception("Error al listar usuarios: " + e.getMessage());
            }
            return users;
        }
    	
    
    	
    	 return new ArrayList<>(); // Devuelve una lista vacía en lugar de null
	}
    public List<Rol> listR() {
    	 return new ArrayList<>(); // También aplica a listR()
	}

    
    public User add(User user) throws Exception {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO user (name, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            return user;

        } catch (SQLException e) {
            throw new Exception("Error al añadir usuario: " + e.getMessage());
        }
    }
    public Rol add(Rol rol) {
		return null;
	}

    public User findById(int idForEdit) {
		return null;
	} 
    public Rol findByIdRol(int id) {
		return null;
	}
    
    public void editUser(int idForEdit, User modifiedUser) throws Exception {
	}
    public void editRol(int idForEdit, Rol modifiedRol) throws Exception {
	}
    
    public void removeUser(User userForRemove) throws Exception {
	}
    public void removeRol(Rol rolForRemove) throws Exception {
	}
}
