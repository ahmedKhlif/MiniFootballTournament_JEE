package util;

import java.time.LocalDate;
import java.util.List;

import dao.TournoiDAO;
import entities.Tournoi;

public class TournoiDAOTest {
    public static void main(String[] args) {
        // Test findById
        TournoiDAO tournoiDAO = new TournoiDAO();
        Tournoi tournoi = tournoiDAO.findById(1L);
        System.out.println("Tournoi found by id 1: " + tournoi);

        // Test save
        Tournoi newTournoi = new Tournoi((long) 4, "New Tournament", LocalDate.now(), LocalDate.now().plusDays(7));
        tournoiDAO.save(newTournoi);
        System.out.println("New tournament saved: " + newTournoi);

        // Test update
        tournoi.setNom("Updated Tournament");
        tournoi.setDateFin(tournoi.getDateFin().plusDays(3));
        tournoiDAO.update(tournoi);
        System.out.println("Tournoi updated: " + tournoi);

        // Test delete
        tournoiDAO.delete(newTournoi);
        System.out.println("New tournament deleted");

        // Test getAllTournois
        System.out.println("All Tournois:");
        List<Tournoi> tournois = tournoiDAO.getAllTournois();
        for (Tournoi t : tournois) {
            System.out.println(t);
        }
    }
}
