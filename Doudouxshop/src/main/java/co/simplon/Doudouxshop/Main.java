package co.simplon.Doudouxshop;


import java.util.Date;
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
				System.out.println("Entrez l'id du produit");
				int id = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Entrez le nom du fournisseur du produit");
				String nomfour = scan.nextLine();
				
				System.out.println("Entrez le nombre de produit livré du produit");
				int nbrprod = scan.nextInt();
				scan.nextLine();
				
				Achat stock = new Achat();
				stock.ajouterStock(id,nomfour,nbrprod);
				break;
			case 7:// Afficher l'historique des achat

				Achat achat = new Achat();
				System.out.println(achat.getFournisseur());
				//achat.ajoutAchat(1,"oracle",10,new Date());
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
			
			Achat achat = new Achat();
			achat.ajoutProduit("oracle",10);
			System.out.println(achat.getNbrachat());
			achat.setFournisseur("tonpere");
			System.out.println(achat.getFournisseur());
			
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
