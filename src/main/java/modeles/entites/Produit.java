package modeles.entites;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produit {
	private Long id;
	private String nom;
	private double prix;	
	
	public Produit() {
		super();
	}
	
	public Produit(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}

	public Produit(Long id, String nom, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", tva=" + getMontantTVA() + ", TTC=" + getPrixTTC() + "]";
	}	
	
	public Double getMontantTVA() {
		
		// Méthode 1
		BigDecimal bd = new BigDecimal(0.2*getPrix()).setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();		
		
	    // Méthode 2
	    //return (double)Math.round(20 * getPrix())/100;
	}

	public Double getPrixTTC() {
		
		// Méthode 1
		BigDecimal bd = new BigDecimal(1.2*getPrix()).setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();		
		
	    // Méthode 2
	    //return (double)Math.round(120 * getPrix())/100;
	}
}
