package dao;

import entities.Entraineur;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntraineurDAO {
    private Connection connection;

    public EntraineurDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public Entraineur findById(Long id) {
        String query = "SELECT * FROM entraineur WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                LocalDate dateNaissance = resultSet.getDate("date_naissance").toLocalDate();
                String pays = resultSet.getString("pays");

                // Create and return the Entraineur object
                return new Entraineur(id, nom, prenom, dateNaissance, pays);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Entraineur entraineur) {
        String query = "INSERT INTO entraineur (nom, prenom, date_naissance, pays) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entraineur.getNom());
            statement.setString(2, entraineur.getPrenom());
            statement.setDate(3, Date.valueOf(entraineur.getDateNaissance()));
            statement.setString(4, entraineur.getPays());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Entraineur entraineur) {
        String query = "UPDATE entraineur SET nom = ?, prenom = ?, date_naissance = ?, pays = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entraineur.getNom());
            statement.setString(2, entraineur.getPrenom());
            statement.setDate(3, Date.valueOf(entraineur.getDateNaissance()));
            statement.setString(4, entraineur.getPays());
            statement.setLong(5, entraineur.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Entraineur entraineur) {
        String query = "DELETE FROM entraineur WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, entraineur.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
