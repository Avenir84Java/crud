package test;

import java.sql.SQLException;
import java.util.List;

import modeles.dao.ProduitDAO;
import modeles.entites.Produit;

public class TestProduitDAO {

	public static void main(String[] args) throws SQLException {
		
		ProduitDAO pdao = new ProduitDAO();
		//Produit p = new Produit("Ordinateur à 125.50 Euros", 1250.99);
		
		pdao.deleteProduit(4L);
		//System.out.println(liste);
		
		//if (!liste.isEmpty())
		//	liste.forEach(produit -> {System.out.println(produit);});
		

		
		//pdao.produitsParMotCle("Test");
		//pdao.getProduit(10L);
		//pdao.updateProduit(p);
		//pdao.deleteProduit(10L);
		
	}

}
