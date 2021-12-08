package modeles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modeles.SingletonConnexion;
import modeles.entites.Produit;

// DAO : Data Access Objects
public class ProduitDAO implements IProduitDAO {

	@Override
	public Produit save(Produit p)  {
		System.out.println(p);
		Connection connect = SingletonConnexion.getConnexion();

		try {

			PreparedStatement ps = connect.prepareStatement("INSERT INTO produits (nom, prix, montant_tva, prix_ttc) VALUES (?, ?, ?, ?);");
			ps.setString(1, p.getNom());
			if (p.getPrix()==0)
				ps.setNull(2, Types.DECIMAL);
			else
				ps.setDouble(2, p.getPrix());

			if (p.getMontantTVA()==0)
				ps.setNull(3, Types.DECIMAL);
			else
				ps.setDouble(3, p.getMontantTVA());			
			
			if (p.getPrixTTC()==0)
				ps.setNull(4, Types.DECIMAL);
			else
				ps.setDouble(4, p.getPrixTTC());
			
			ps.executeUpdate();
			
			// Good practice !
			ps.close();
						
			ps = connect.prepareStatement("SELECT MAX(id) AS MAX_ID FROM produits");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			
			// Good practice !
			ps.close();
			
			
			/* A éviter en raison du risque d'injection SQL
			Statement st = connect.createStatement();
			st.execute("INSERT INTO produits (nom, prix) VALUES ('" + p.getNom() + "', " + p.getPrix() + ");");
			*/
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		
		return p;
	}

	@Override
	public List<Produit> produitsParMotCle(String motCle) {

		Connection connect = SingletonConnexion.getConnexion();
		PreparedStatement ps = null;
		
		List<Produit> produits = new ArrayList<Produit>();
		
		try {
			if (motCle==null || motCle.isEmpty() || motCle.isBlank())
				ps = connect.prepareStatement("SELECT * FROM produits;");
			else {
				ps = connect.prepareStatement("SELECT * FROM produits WHERE nom LIKE ? ;");
				ps.setString(1, "%"+motCle+"%");
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p = new Produit(rs.getLong("id"), rs.getString("nom"), rs.getDouble("prix"));
				produits.add(p);
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return produits;
	}

	@Override
    public Produit getProduit(Long id) throws SQLException {
		Connection connect = SingletonConnexion.getConnexion();
        
		PreparedStatement ps = null;
        Produit p = null;

        try {

            ps = connect.prepareStatement("SELECT * FROM produits WHERE id = ?;");
            ps.setDouble(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Produit(rs.getLong("id"), rs.getString("nom"), rs.getDouble("prix"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
        
        return p;
    }

	@Override
    public Produit updateProduit(Produit p) {
        Connection connect = SingletonConnexion.getConnexion();
        Produit pretour = null;
        try {
            PreparedStatement ps = connect.prepareStatement("UPDATE produits SET nom = ?, prix = ? WHERE id = ?;");
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setLong(3, p.getId());
            ps.executeUpdate();
                       
            ps.close();
            pretour = getProduit(p.getId());
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pretour;
    }
	
	@Override
	public void deleteProduit(Long id) {
		
	    Connection connect = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connect.prepareStatement("DELETE FROM Produits WHERE id = ?;");
			ps.setLong(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

} 
