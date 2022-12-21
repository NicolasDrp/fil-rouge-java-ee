package co.simplon.Doudouxshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("--- Connexion ---" + "\r1. Compte employé" + "\r2. Compte client" + "\r3. Quitter");

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
		case 1:// CONNEXION EMPLOYE
			/*
			 * achat // produit //
			 */
			
			System.out.println("Que voulez vous faire?" + "\r1. Afficher les produit disponible"
					+ "\r2. Ajouter un produit" + "\r3. Ajouter du stock à un produit" + "\r4. Supprimer un produit"
					+ "\r5. J'ajouterais peut etre un truc ici" + "\r6. Retour au menu de connexion" + "\r7. Quitter");
			selection = 0;
			while (selection == 0 || selection <1 ||selection >9) {
				try {
					System.out.print("\rIndiquez votre choix : ");
					selection = scan.nextInt();
					scan.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Veuillez entrer un chiffre.");
					scan.nextLine();
				}
			}
			switch (selection) {
			case 1:// Afficher les produit disponible  // marche
				Produit list = new Produit();
				list.getProduits();
				break;
			case 2:// Ajouter un produit // marche
				System.out.println("Nom du produit: ");
				String nom = scan.nextLine();
				
				System.out.println("Le prix: ");
				double prix = scan.nextDouble();
				
				System.out.println("Quantité disponible");
				int quantite = scan.nextInt();
				
				Produit produit = new Produit(nom, prix, quantite);
				produit.ajoutProduit();
				break;
			case 3:// Ajouter du stock à un produit // marche pas
				//Achat stock = new Achat(1, "Oracle.com", 22)
				break;
			case 4:// Supprimer un produit
				System.out.println("Quel produit souhaitez vous supprimer ?");
				String nomsup = scan.nextLine();
				
				Produit sup = new Produit();
				sup.supprimerProduit(nomsup);
				break;
			case 5:// Afficher l'historique des achat

				break;
			case 8://chercher un produit en particulier // marche (Attention les espaces!!)
				Produit prod = new Produit();
				String nomprod = "Champion ";
				prod.getProduit(nomprod);
				break;
			case 9://modifier un produit // marche pas
				Produit modif = new Produit();
				String nommodif = "Champion ";
				String nvnom = "champion2";
				
				modif.changerNom(nommodif, nvnom);
				break;
			case 6:// Retour au menu de connexion

				break;
			case 7:// Quitter
				System.out.println("au revoir !");
				break;

			default:
				
				break;
			}

			break;
		case 2:// CONNEXION CLIENT
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
			// quitter
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
