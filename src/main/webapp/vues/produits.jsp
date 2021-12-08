<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controleurs.ProduitWeb"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<!--  
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">-->	
	
	<link rel="stylesheet" href="vues/css/bootstrap.min.css" />
	<link rel="stylesheet" href="vues/css/style.css" />

</head>
<body>
	<div class="container bordure">
		<div class="card bordure">
			<div class="card-header bordure">
				Rechercher des produits
			</div>
			<div class="card-body bordure">
				<form action="chercher.do" method="get" >
					<label for="motCle">Mot clé : </label>
					<input type="text" name="motCle" id="motCle" value="" />
					<button type="submit" class="btn btn-primary mb-2">Chercher</button>
				</form>
				<table class="table table-striped">
					<tr>
						<th>ID</th><th>Nom produit</th><th>Prix HT</th><th>TVA</th><th>Prix TTC</th>
					</tr>
				
					
				
				
				</table>
				<% 
					ProduitWeb pw = (ProduitWeb)request.getAttribute("data");
					out.print(pw); 
				%>
				
			</div>
		</div>
	</div>
</body>
</html>