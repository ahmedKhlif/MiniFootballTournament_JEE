<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Tournoi" %>
<%@ page import="dao.TournoiDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Tournoi</title>
    <style>
        /* CSS code for styling the form */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 4px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        button[type="submit"] {
            background-color: #337ab7;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #265f92;
        }

        .back-link {
            display: block;
            margin-top: 10px;
            color: #337ab7;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Create Tournoi</h1>
    
    <form action="tournoi" method="post">
        <input type="hidden" name="action" value="create">
        
        <label for="nom">Nom:</label>
        <input type="text" name="nom" id="nom" required>
        
        <label for="dateDebut">Date Début:</label>
        <input type="date" name="dateDebut" id="dateDebut" required>
        
        <label for="dateFin">Date Fin:</label>
        <input type="date" name="dateFin" id="dateFin" required>
        
        <button type="submit">Create</button>
    </form>
    
    <a href="tournoi" class="back-link">Back to Tournois</a>
</body>
</html>
