<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Pseudo : ${model.utilisateur.pseudo}<br>
Nom : ${model.utilisateur.nom}<br>
Pr�nom :  ${model.utilisateur.prenom}<br>
Email :  ${model.utilisateur.email}<br>
T�l�phone : ${model.utilisateur.telephone}<br>
Rue :  ${model.utilisateur.rue}<br>
Code Postal :  ${model.utilisateur.codePostal}<br>
Ville :  ${model.utilisateur.ville} <br>

<input type="submit" value="Modifier"/>

</body>
</html>