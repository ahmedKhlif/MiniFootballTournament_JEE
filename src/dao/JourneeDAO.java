package dao;

import entities.Journee;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JourneeDAO {
    private Connection connection;

    public JourneeDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public Journee findById(Long id) {
        String query = "SELECT * FROM journee WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long tournoiId = resultSet.getLong("tournoi_id");
                LocalDate dateJournee = resultSet.getDate("date_journee").toLocalDate();

                // Create and return the Journee object
                return new Journee(id, tournoiId, dateJournee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Journee journee) {
        String query = "INSERT INTO journee (tournoi_id, date_journee) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, journee.getTournoiId());
            statement.setDate(2, Date.valueOf(journee.getDateJournee()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Journee journee) {
        String query = "UPDATE journee SET tournoi_id = ?, date_journee = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, journee.getTournoiId());
            statement.setDate(2, Date.valueOf(journee.getDateJournee()));
            statement.setLong(3, journee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Journee journee) {
        String query = "DELETE FROM journee WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, journee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
