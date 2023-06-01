<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
    <style>
              body {
            margin: 0;
            padding: 0;
            background-image: url('https://img.freepik.com/photos-gratuite/smartphone-concept-interface-utilisateur_52683-104212.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }
        

        h1 {
            color: #333;
        }

        .navbar {
            background-color: #333;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            color: #fff;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 18px;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: #333;
        }

        .form-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 5px;
        }

        .form-container h2 {
            margin-top: 0;
            color: #333;
        }

        .form-container label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        .form-container input[type="text"],
        .form-container input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        .form-container button {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }

        .form-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="tournoi.jsp">Accueil</a>
        <a href="tournoi-form.jsp">Tournois</a>
        <a href="create-tournoi.jsp">Create Tournoi</a>
         <a href="UserList.jsp">Create Tournoi</a>
                  <a href=".jsp">Create user</a>
                  <a href="UserList.jsp">Create Tournoi</a>
         
        
    </div>

    <div class="form-container">
        <h2>Create Tournoi</h2>

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
    </div>
</body>
</html>
