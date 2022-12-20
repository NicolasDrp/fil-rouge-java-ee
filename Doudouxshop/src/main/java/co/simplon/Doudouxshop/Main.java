package co.simplon.Doudouxshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

        System.out.println("--- Connexion ---"
        		+ "\r1. Compte employé"
        		+ "\r2. Compte client"
        		+ "\r3. Quitter");


        int selection = 0;
        while (selection == 0) {
            try {
                System.out.print("\rIndiquez votre choix : ");
                selection = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un chiffre.");
                scan.nextLine();
            }
        }
        
        switch (selection) {
            case 1:
                /*
                *achat //
                *produit //
                */
            	String nom = "livre java";
            	double prix = 25.99;
            	int quantite = 12;
            	
            	
            	
            	Produit produit = new Produit(nom, prix, quantite);
            	produit.ajoutProduit();
            	
                break;
            case 2:
            	String nom2 = "livre java";
            	double prix2 = 25.99;
            	int quantite2 = 12;
            	
            	
            	
            	Produit produit2 = new Produit(nom2, prix2, quantite2);
            	
            	String nomAchat = "le java de michmich";
            	int quantiteAchat = 12;
            	
                Achat achat = new Achat(produit2, nomAchat, quantiteAchat);
                achat.ajouterStock();
                break;
            case 3:
                System.out.println("Au revoir !");
                //quitter
                System.exit(0);
                break;
            default:
                System.out.println("entrée invalide , entrez un chiffre entre 1 et 3 ");
                main(null);
                break;
        }
		
		
        scan.close();
	}

}
