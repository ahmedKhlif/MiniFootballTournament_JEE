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
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
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

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            color: #337ab7;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .create-link {
            display: inline-block;
            margin-top: 10px;
            background-color: #337ab7;
            color: #fff;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
        }

        .create-link:hover {
            background-color: #265f92;
        }
    </style>
</head>
<body>
    <h1>Tournois</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Date Début</th>
            <th>Date Fin</th>
            <th>Action</th>
        </tr>
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
                <td>
                    <a href="edit-tournoi.jsp?id=<%= tournoi.getId() %>">Edit</a>
                    <a href="tournoi?action=delete&id=<%= tournoi.getId() %>">Delete</a>
                </td>
            </tr>
        <% } %>
    </table>

    <a href="create-tournoi.jsp" class="create-link">Create New Tournoi</a>
</body>
</html>
