<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Tournoi" %>
<%@ page import="dao.TournoiDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tournois</title>
   <style>
        /* CSS code for styling the table */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
            padding: 10px;
            font-size: 28px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            animation: fade-in 0.6s ease-in-out;
        }

        @keyframes fade-in {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f5f5f5;
        }

        tr:hover {
            background-color: #e9e9e9;
            animation: highlight-row 0.3s ease-in-out;
        }

        @keyframes highlight-row {
            0% {
                background-color: #e9e9e9;
            }
            50% {
                background-color: #ffefb3;
            }
            100% {
                background-color: #e9e9e9;
            }
        }

        a {
            color: #337ab7;
            text-decoration: none;
            transition: color 0.3s;
        }

        a:hover {
            color: #ff6f00;
        }

        .create-link {
            display: inline-block;
            margin-top: 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <h1>Tournois</h1>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Date de début</th>
                <th>Date de fin</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over the tournois and display them in the table rows --%>
            <% 
                TournoiDAO tournoiDAO = new TournoiDAO();
                List<Tournoi> tournois = tournoiDAO.getAllTournois();
                for (Tournoi tournoi : tournois) { 
            %>
                <tr>
                    <td><%= tournoi.getId() %></td>
                    <td><%= tournoi.getNom() %></td>
                    <td><%= tournoi.getDateDebut() %></td>
                    <td><%= tournoi.getDateFin() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
    <script>
        // JavaScript code goes here
    </script>
</body>
</html>
