package dao;

import entities.Match;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDAO {
    private Connection connection;

    public MatchDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public Match findById(Long id) {
        String query = "SELECT * FROM `match` WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long journeeId = resultSet.getLong("journee_id");
                Long equipeDomicileId = resultSet.getLong("equipe_domicile_id");
                Long equipeVisiteurId = resultSet.getLong("equipe_visiteur_id");
                Integer scoreDomicile = resultSet.getInt("score_domicile");
                Integer scoreVisiteur = resultSet.getInt("score_visiteur");

                // Create and return the Match object
                return new Match(id, journeeId, equipeDomicileId, equipeVisiteurId, scoreDomicile, scoreVisiteur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Match match) {
        String query = "INSERT INTO `match` (journee_id, equipe_domicile_id, equipe_visiteur_id, score_domicile, score_visiteur) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, match.getJourneeId());
            statement.setLong(2, match.getEquipeDomicileId());
            statement.setLong(3, match.getEquipeVisiteurId());
            statement.setInt(4, match.getScoreDomicile());
            statement.setInt(5, match.getScoreVisiteur());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Match match) {
        String query = "UPDATE `match` SET journee_id = ?, equipe_domicile_id = ?, equipe_visiteur_id = ?, " +
                "score_domicile = ?, score_visiteur = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, match.getJourneeId());
            statement.setLong(2, match.getEquipeDomicileId());
            statement.setLong(3, match.getEquipeVisiteurId());
            statement.setInt(4, match.getScoreDomicile());
            statement.setInt(5, match.getScoreVisiteur());
            statement.setLong(6, match.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Match match) {
        String query = "DELETE FROM `match` WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, match.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
