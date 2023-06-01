<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Tournoi" %>
<%@ page import="dao.TournoiDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Tournoi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #f4f4f4;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 5px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }

        button[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        a {
            display: block;
            margin-top: 20px;
            text-align: center;
            color: #999;
            text-decoration: none;
        }

        a:hover {
            color: #333;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Edit Tournoi</h1>
    
    <% 
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            TournoiDAO tournoiDAO = new TournoiDAO();
            Tournoi tournoi = tournoiDAO.getTournoiById(id);
            if (tournoi != null) {
    %>
                <form action="tournoi" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="<%= tournoi.getId() %>">
                    
                    <label for="nom">Nom:</label>
                    <input type="text" name="nom" id="nom" value="<%= tournoi.getNom() %>" required>
                    
                    <label for="dateDebut">Date Début:</label>
                    <input type="date" name="dateDebut" id="dateDebut" value="<%= tournoi.getDateDebut() %>" required>
                    
                    <label for="dateFin">Date Fin:</label>
                    <input type="date" name="dateFin" id="dateFin" value="<%= tournoi.getDateFin() %>" required>
                    
                    <button type="submit">Update</button>
                </form>
    <% 
            } else {
                out.println("<p class='error'>Tournoi not found.</p>");
            }
        } else {
            out.println("<p class='error'>Invalid ID parameter.</p>");
        }
    %>
    
    <a href="tournoi">Back to Tournois</a>
</body>
</html>
