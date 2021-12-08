package test;

import modeles.entites.Produit;

public class TestProduit {

	public static void main(String[] args) {
		
		Produit monProduit1 = new Produit();
		System.out.println(monProduit1);
	
		Produit monProduit2 = new Produit(10L, "Ordinateur HP", 1250.50);
		System.out.println(monProduit2);
	
	}

}
