package dao;

import entities.Changement;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangementDAO {
    private Connection connection;

    public ChangementDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public Changement findById(Long id) {
        String query = "SELECT * FROM changement WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long matchId = resultSet.getLong("match_id");
                Long joueurSortantId = resultSet.getLong("joueur_sortant_id");
                Long joueurEntrantId = resultSet.getLong("joueur_entrant_id");
                int minuteChangement = resultSet.getInt("minute_changement");

                // Create and return the Changement object
                return new Changement(id, matchId, joueurSortantId, joueurEntrantId, minuteChangement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Changement changement) {
        String query = "INSERT INTO changement (match_id, joueur_sortant_id, joueur_entrant_id, minute_changement) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, changement.getMatchId());
            statement.setLong(2, changement.getJoueurSortantId());
            statement.setLong(3, changement.getJoueurEntrantId());
            statement.setInt(4, changement.getMinuteChangement());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Changement changement) {
        String query = "UPDATE changement SET match_id = ?, joueur_sortant_id = ?, joueur_entrant_id = ?, " +
                "minute_changement = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, changement.getMatchId());
            statement.setLong(2, changement.getJoueurSortantId());
            statement.setLong(3, changement.getJoueurEntrantId());
            statement.setInt(4, changement.getMinuteChangement());
            statement.setLong(5, changement.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Changement changement) {
        String query = "DELETE FROM changement WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, changement.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
