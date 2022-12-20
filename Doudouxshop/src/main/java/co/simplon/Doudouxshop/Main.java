package co.simplon.Doudouxshop;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	//private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Doudouxshop");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("test");
		Produit produit = new Produit("mug j-m", 12, 50);
		produit.ajoutProduit();
		
		
		
		//ENTITY_MANAGER_FACTORY.close();
	}

}
