<%@ page language="java" import="java.util.*, metier.User" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 20px;
        }

        h1 {
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
        .form-container input[type="password"] {
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

        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
Veuillez saisir les propriétés de l'utilisateur...
		<hr>
		
		<%
		
	      //gestion des erreurs
			ArrayList erreurs = (ArrayList) request.getAttribute("err");
			if (erreurs != null) 
			{
				%>
				<div class="erreur">
				<%
				out.println("<ul>");
				for (int i = 0; i < erreurs.size(); i++) {
					out.println("<li> " + (String) erreurs.get(i) + "</li>");
				}
				out.println("</ul>");
				%>
				</div>
			<%
			}
			
			
			// gestion de la saisie de  l'utilisateur en cours
			String login =null;
			String password =null;
			String nom =null;
			String prenom =null;
			int id =0;
			User u = (User)request.getAttribute("user");
			if (u!=null)
			{
			 id=u.getId();
			 login = u.getLogin();
			 password = u.getPassword();
			 nom = u.getNom();
			 prenom = u.getPrenom();
			}
			
			// Correction des  valleurs nulles
			if (login==null)login="";
			if (password==null)password="";
			if (nom==null)nom="";
			if (prenom==null)prenom="";
		%>
		
		<form action="UserEditionController" method="POST">
			<table>
			<tr>
				<td><input type="hidden" name="id" value ="<%=id%>"/></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" value ="<%=login%>"/></td>
			</tr>
			<tr>
				<td>Mot de passe:</td>
				<td><input type="password" name="password" value ="<%=password%>"/></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><input type="text" name="nom" value ="<%=nom%>"/></td>
			</tr>
			<tr>
				<td>Prénom:</td>
				<td><input type="text" name="prenom" value ="<%=prenom%>"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="ok" />
					<input type="reset" value="Annuler" /></td>
			</tr>

		</table>
	</form>
</body>
</html>