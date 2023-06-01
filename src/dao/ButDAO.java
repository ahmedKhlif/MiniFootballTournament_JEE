package dao;

import entities.But;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ButDAO {
    private Connection connection;

    public ButDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public But findById(int id) {
        String query = "SELECT * FROM but WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int matchId = resultSet.getInt("match_id");
                int joueurMarqueurId = resultSet.getInt("joueur_marqueur_id");
                return new But(id, matchId, joueurMarqueurId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<But> findAll() {
        List<But> buts = new ArrayList<>();
        String query = "SELECT * FROM but";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int matchId = resultSet.getInt("match_id");
                int joueurMarqueurId = resultSet.getInt("joueur_marqueur_id");
                But but = new But(id, matchId, joueurMarqueurId);
                buts.add(but);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buts;
    }

    public void save(But but) {
        String query = "INSERT INTO but (id, match_id, joueur_marqueur_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, but.getId());
            statement.setInt(2, but.getMatchId());
            statement.setInt(3, but.getJoueurMarqueurId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(But but) {
        String query = "UPDATE but SET match_id = ?, joueur_marqueur_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, but.getMatchId());
            statement.setInt(2, but.getJoueurMarqueurId());
            statement.setInt(3, but.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(But but) {
        String query = "DELETE FROM but WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, but.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
