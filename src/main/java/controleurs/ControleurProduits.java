package controleurs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeles.dao.IProduitDAO;
import modeles.dao.ProduitDAO;
import modeles.entites.Produit;


@WebServlet(name="cp", urlPatterns={"/Produits", "*.do"})
public class ControleurProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IProduitDAO pdao;
	
	@Override
	public void init() throws ServletException {
		pdao = new ProduitDAO();
	}
	
    public ControleurProduits() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		if (path.equals("/index.do")) {

			request.getRequestDispatcher("vues/produits.jsp").forward(request, response);
		}
		else if  (path.equals("/chercher.do")) {
			
			String motCle = request.getParameter("motCle");
			ProduitWeb pw = new ProduitWeb();
			pw.setMotCle(motCle);
			List<Produit> produits = pdao.produitsParMotCle(motCle);
			pw.setProduits(produits);
			request.setAttribute("data", pw);
			request.getRequestDispatcher("vues/produits.jsp").forward(request, response);
			
		}
		else
			response.getWriter().println(path);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		doGet(request, response);
	}

}
