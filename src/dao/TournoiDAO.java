package dao;

import entities.Tournoi;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TournoiDAO {
    private Connection connection;

    public TournoiDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
        public Tournoi getTournoiById(int id) {
            String query = "SELECT * FROM tournoi WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    long tournoiId = resultSet.getLong("id");
                    String nom = resultSet.getString("nom");
                    LocalDate dateDebut = resultSet.getDate("date_debut").toLocalDate();
                    LocalDate dateFin = resultSet.getDate("date_fin").toLocalDate();

                    // Create and return the Tournoi object
                    return new Tournoi(tournoiId, nom, dateDebut, dateFin);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    public Tournoi findById(Long id) {
        String query = "SELECT * FROM tournoi WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                LocalDate dateDebut = resultSet.getDate("date_debut").toLocalDate();
                LocalDate dateFin = resultSet.getDate("date_fin").toLocalDate();

                // Create and return the Tournoi object
                return new Tournoi(id, nom, dateDebut, dateFin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Tournoi tournoi) {
        String query = "INSERT INTO tournoi (nom, date_debut, date_fin) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tournoi.getNom());
            statement.setDate(2, java.sql.Date.valueOf(tournoi.getDateDebut()));
            statement.setDate(3, java.sql.Date.valueOf(tournoi.getDateFin()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Tournoi tournoi) {
        String query = "UPDATE tournoi SET nom = ?, date_debut = ?, date_fin = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tournoi.getNom());
            statement.setDate(2, java.sql.Date.valueOf(tournoi.getDateDebut()));
            statement.setDate(3, java.sql.Date.valueOf(tournoi.getDateFin()));
            statement.setLong(4, tournoi.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Tournoi tournoi) {
        String query = "DELETE FROM tournoi WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, tournoi.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tournoi> getAllTournois() {
        List<Tournoi> tournois = new ArrayList<>();
        String query = "SELECT * FROM tournoi";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nom = resultSet.getString("nom");
                LocalDate dateDebut = resultSet.getDate("date_debut").toLocalDate();
                LocalDate dateFin = resultSet.getDate("date_fin").toLocalDate();

                Tournoi tournoi = new Tournoi(id, nom, dateDebut, dateFin);
                tournois.add(tournoi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tournois;
    }
}
