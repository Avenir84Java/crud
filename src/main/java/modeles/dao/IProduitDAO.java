package modeles.dao;

import java.sql.SQLException;
import java.util.List;
import modeles.entites.Produit;

public interface IProduitDAO {
	public Produit save(Produit p);
	public List<Produit> produitsParMotCle(String motCle);	
	public Produit getProduit(Long id)  throws SQLException;
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long id);	
}
