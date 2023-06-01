package dao;

import entities.Joueur;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JoueurDAO {
    private Connection connection;

    public JoueurDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public Joueur findById(Long id) {
        String query = "SELECT * FROM joueur WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                LocalDate dateNaissance = resultSet.getDate("date_naissance").toLocalDate();
                String pays = resultSet.getString("pays");
                double salaire = resultSet.getDouble("salaire");
                int matchsJoues = resultSet.getInt("matchs_joues");
                int avertissementsTotal = resultSet.getInt("avertissements_total");
                int avertissementsActifs = resultSet.getInt("avertissements_actifs");
                int expulsionsTotal = resultSet.getInt("expulsions_total");
                int matchsSuspendus = resultSet.getInt("matchs_suspendus");
                boolean competitif = resultSet.getBoolean("competitif");

                // Create and return the Joueur object
                return new Joueur(id, nom, prenom, dateNaissance, pays, salaire, matchsJoues,
                        avertissementsTotal, avertissementsActifs, expulsionsTotal, matchsSuspendus, competitif);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Joueur joueur) {
        String query = "INSERT INTO joueur (nom, prenom, date_naissance, pays, salaire, matchs_joues, " +
                "avertissements_total, avertissements_actifs, expulsions_total, matchs_suspendus, competitif) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, joueur.getNom());
            statement.setString(2, joueur.getPrenom());
            statement.setDate(3, Date.valueOf(joueur.getDateNaissance()));
            statement.setString(4, joueur.getPays());
            statement.setDouble(5, joueur.getSalaire());
            statement.setInt(6, joueur.getMatchsJoues());
            statement.setInt(7, joueur.getAvertissementsTotal());
            statement.setInt(8, joueur.getAvertissementsActifs());
            statement.setInt(9, joueur.getExpulsionsTotal());
            statement.setInt(10, joueur.getMatchsSuspendus());
            statement.setBoolean(11, joueur.isCompetitif());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Joueur joueur) {
        String query = "UPDATE joueur SET nom = ?, prenom = ?, date_naissance = ?, pays = ?, salaire = ?, " +
                "matchs_joues = ?, avertissements_total = ?, avertissements_actifs = ?, expulsions_total = ?, " +
                "matchs_suspendus = ?, competitif = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, joueur.getNom());
            statement.setString(2, joueur.getPrenom());
            statement.setDate(3, Date.valueOf(joueur.getDateNaissance()));
            statement.setString(4, joueur.getPays());
            statement.setDouble(5, joueur.getSalaire());
            statement.setInt(6, joueur.getMatchsJoues());
            statement.setInt(7, joueur.getAvertissementsTotal());
            statement.setInt(8, joueur.getAvertissementsActifs());
            statement.setInt(9, joueur.getExpulsionsTotal());
            statement.setInt(10, joueur.getMatchsSuspendus());
            statement.setBoolean(11, joueur.isCompetitif());
            statement.setLong(12, joueur.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Joueur joueur) {
        String query = "DELETE FROM joueur WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, joueur.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
