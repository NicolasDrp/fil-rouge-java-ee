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

			System.out.println(
					"Que voulez vous faire?" + "\r1. Afficher les produit disponible" + "\r2. Rechercher un produit"
							+ "\r3. Ajouter un produit" + "\r4. Modifier un produit" + "\r5. Supprimer un produit"
							+ "\r6. Ajouter du stock" + "\r7. Afficher l'historique des livraisons de stock "
							+ "\r8. Retour au menu de connexion" + "\r9. Quitter");
			selection = 0;
			while (selection == 0 || selection < 1 || selection > 9) {
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
			case 1:// Afficher les produit disponible // marche
				Produit list = new Produit();
				list.getProduits();
				//main(null);
				break;
			case 2:// chercher un produit en particulier // marche
				Produit prod = new Produit();
				String nomprod = "t-shirt j-m";
				prod.getProduit(nomprod);
				//main(null);
				break;
			case 3:// Ajouter un produit // marche
				System.out.println("Nom du produit: ");
				String nom = scan.nextLine();

				System.out.println("Le prix: ");
				double prix = scan.nextDouble();

				System.out.println("Quantité disponible");
				int quantite = scan.nextInt();

				Produit produit = new Produit(nom, prix, quantite);
				produit.ajoutProduit();
				break;
			case 4:// modifier un produit // marche
				System.out.println("Nom du produit: ");
				String nommodif = scan.nextLine();
				
				Produit modif = new Produit();
				
				System.out.println("Nouveau nom du produit: ");
				String nvnom = scan.nextLine();

				modif.changerNom(nommodif, nvnom);
				break;
			case 5:// Supprimer un produit // marche
				System.out.println("Quel produit souhaitez vous supprimer ?");
				String nomsup = scan.nextLine();

				Produit sup = new Produit();
				sup.supprimerProduit(nomsup);
				break;
			case 6:// Ajouter du stock à un produit // marche
				Achat stock = new Achat();
				stock.ajouterStock(1, "Oracle.com", 22);
				break;
			case 7:// Afficher l'historique des achat
				Achat achat = new Achat(1,"oracle",10);
				achat.ajoutAchat();
				break;

			case 8:// Retour au menu de connexion
				main(null);
				break;

			case 9:// Quitter
				System.out.println("Au revoir !");
				System.exit(0);
				break;

			default:
				break;

			}

			break;
		case 2:// CONNEXION CLIENT
			//Achat.registerPurchase(1, "jajajaaj", 22);
			Achat achat = new Achat();
			//achat.ajouterStock2(1, "test", 21);
			achat.test();
			
			System.out.println("ss");
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
