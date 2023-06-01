package dao;

import entities.Equipe;
import entities.Entraineur;
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

public class EquipeDAO {
    private Connection connection;

    public EquipeDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public Equipe findById(Long id) {
        String query = "SELECT * FROM equipe LEFT JOIN entraineur ON equipe.entraineur_id = entraineur.id WHERE equipe.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("equipe.nom");
                LocalDate dateCreation = resultSet.getDate("equipe.date_creation").toLocalDate();
                String pays = resultSet.getString("equipe.pays");
                Long entraineurId = resultSet.getLong("equipe.entraineur_id");
                String entraineurNom = resultSet.getString("entraineur.nom");
                String entraineurPrenom = resultSet.getString("entraineur.prenom");
                LocalDate entraineurDateNaissance = resultSet.getDate("entraineur.date_naissance").toLocalDate();
                String entraineurPays = resultSet.getString("entraineur.pays");
                Entraineur entraineur = new Entraineur(entraineurId, entraineurNom, entraineurPrenom, entraineurDateNaissance, entraineurPays);

                // Create the Equipe object
                Equipe equipe = new Equipe(id, nom, dateCreation, pays, entraineur);

                // Load the players for the team
                List<Joueur> joueurs = loadJoueursForEquipe(id);
                equipe.setJoueurs(joueurs);

                return equipe;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Joueur> loadJoueursForEquipe(Long equipeId) {
        List<Joueur> joueurs = new ArrayList<>();
        String query = "SELECT * FROM joueur WHERE equipe_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, equipeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long joueurId = resultSet.getLong("id");
                String joueurNom = resultSet.getString("nom");
                String joueurPrenom = resultSet.getString("prenom");
                LocalDate joueurDateNaissance = resultSet.getDate("date_naissance").toLocalDate();
                String joueurPays = resultSet.getString("pays");
                double joueurSalaire = resultSet.getDouble("salaire");
                int joueurMatchsJoues = resultSet.getInt("matchs_joues");
                int joueurAvertissementsTotal = resultSet.getInt("avertissements_total");
                int joueurAvertissementsActifs = resultSet.getInt("avertissements_actifs");
                int joueurExpulsionsTotal = resultSet.getInt("expulsions_total");
                int joueurMatchsSuspendus = resultSet.getInt("matchs_suspendus");
                boolean joueurCompetitif = resultSet.getBoolean("competitif");

                Joueur joueur = new Joueur(joueurId, joueurNom, joueurPrenom, joueurDateNaissance, joueurPays,joueurSalaire,joueurMatchsJoues,joueurAvertissementsTotal,joueurAvertissementsActifs,joueurExpulsionsTotal,joueurMatchsSuspendus,joueurCompetitif);
                
                
                
                joueur.setId(joueurId);
                joueur.setNom(joueurNom);
                joueur.setPrenom(joueurPrenom);
                joueur.setDateNaissance(joueurDateNaissance);
                joueur.setPays(joueurPays);
                joueur.setSalaire(joueurSalaire);
                joueur.setMatchsJoues(joueurMatchsJoues);
                joueur.setAvertissementsTotal(joueurAvertissementsTotal);
                joueur.setAvertissementsActifs(joueurAvertissementsActifs);
                joueur.setExpulsionsTotal(joueurExpulsionsTotal);
                joueur.setMatchsSuspendus(joueurMatchsSuspendus);
                joueur.setCompetitif(joueurCompetitif);
              
             

                joueurs.add(joueur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueurs;
    }


    public void save(Equipe equipe) {
        String query = "INSERT INTO equipe (nom, date_creation, pays, entraineur_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, equipe.getNom());
            statement.setDate(2, Date.valueOf(equipe.getDateCreation()));
            statement.setString(3, equipe.getPays());
            statement.setLong(4, equipe.getEntraineur().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Equipe equipe) {
        String query = "UPDATE equipe SET nom = ?, date_creation = ?, pays = ?, entraineur_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, equipe.getNom());
            statement.setDate(2, Date.valueOf(equipe.getDateCreation()));
            statement.setString(3, equipe.getPays());
            statement.setLong(4, equipe.getEntraineur().getId());
            statement.setLong(5, equipe.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Equipe equipe) {
        String query = "DELETE FROM equipe WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, equipe.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
