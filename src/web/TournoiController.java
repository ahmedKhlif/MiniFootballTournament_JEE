package web;

import dao.TournoiDAO;
import entities.Tournoi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/tournoi")
public class TournoiController extends HttpServlet {
    private TournoiDAO tournoiDAO;

    public void init() {
        tournoiDAO = new TournoiDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tournoi> tournois = tournoiDAO.getAllTournois();
        request.setAttribute("tournois", tournois);
        request.getRequestDispatcher("/tournoi.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    createTournoi(request, response);
                    break;
                case "update":
                    updateTournoi(request, response);
                    break;
                case "delete":
                    deleteTournoi(request, response);
                    break;
                default:
                    // Invalid action
                    response.sendRedirect(request.getContextPath() + "/tournoi");
            }
        } else {
            // No action provided
            response.sendRedirect(request.getContextPath() + "/tournoi");
        }
    }

    private void createTournoi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String dateDebut = request.getParameter("dateDebut");
        String dateFin = request.getParameter("dateFin");

        // Create a new Tournoi object
        LocalDate dateDebutObj = LocalDate.parse(dateDebut);
        LocalDate dateFinObj = LocalDate.parse(dateFin);
        Tournoi tournoi = new Tournoi(null, nom, dateDebutObj, dateFinObj);

        // Save the tournoi using the TournoiDAO
        tournoiDAO.save(tournoi);

        // Redirect back to the tournoi list page
        response.sendRedirect(request.getContextPath() + "/tournoi");
    }


    private void updateTournoi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String dateDebut = request.getParameter("dateDebut");
        String dateFin = request.getParameter("dateFin");

        // Find the existing tournoi by id
        Tournoi tournoi = tournoiDAO.findById(id);

        if (tournoi != null) {
            // Update the tournoi object with new values
            tournoi.setNom(nom);
            tournoi.setDateDebut(LocalDate.parse(dateDebut));
            tournoi.setDateFin(LocalDate.parse(dateFin));

            // Save the updated tournoi using the TournoiDAO
            tournoiDAO.update(tournoi);
        }

        // Redirect back to the tournoi list page
        response.sendRedirect(request.getContextPath() + "/tournoi");
    }

    private void deleteTournoi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        // Find the existing tournoi by id
        Tournoi tournoi = tournoiDAO.findById(id);

        if (tournoi != null) {
            // Delete the tournoi using the TournoiDAO
            tournoiDAO.delete(tournoi);
        }

        // Redirect back to the tournoi list page
        response.sendRedirect(request.getContextPath() + "/tournoi");
    }
}
