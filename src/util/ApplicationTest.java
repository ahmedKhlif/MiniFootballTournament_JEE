package util;

import java.time.LocalDate;

import dao.JourneeDAO;
import dao.TournoiDAO;
import entities.Journee;
import entities.Tournoi;

public class ApplicationTest {
    public static void main(String[] args) {
        // Create instances of your ADO classes and other necessary dependencies
        TournoiDAO tournoiADO = new TournoiDAO();
        JourneeDAO journeeADO = new JourneeDAO();

        // Your test code goes here
        // Create sample data, perform operations, and test functionality

        // Example test code
        Tournoi tournoi = new Tournoi((long)2, "saybni", LocalDate.of(2023, 1, 5), LocalDate.of(2023, 1, 31));
        Journee journee = new Journee((long)2, (long)1, LocalDate.of(2023, 1, 5));

        // Save the Tournoi
        tournoiADO.save(tournoi);

        // Save the Journee
        journeeADO.save(journee);

        // Retrieve the saved Tournoi and Journee
        Tournoi retrievedTournoi = tournoiADO.findById((long)1);
        Journee retrievedJournee = journeeADO.findById((long)1);

        // Print the retrieved data
        System.out.println("Retrieved Tournoi:");
        System.out.println(retrievedTournoi);

        System.out.println("Retrieved Journee:");
        System.out.println(retrievedJournee);
    }
}
