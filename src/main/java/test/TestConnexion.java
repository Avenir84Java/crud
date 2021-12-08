package test;

import java.sql.Connection;
import modeles.SingletonConnexion;

public class TestConnexion {

	public static void main(String[] args) {

		Connection connexion = SingletonConnexion.getConnexion();
		System.out.println(SingletonConnexion.class);

	}

}
