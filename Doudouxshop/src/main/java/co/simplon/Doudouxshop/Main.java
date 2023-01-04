package co.simplon.Doudouxshop;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("\r\r--- Connexion ---" + "\r1. Compte employé" + "\r2. Compte client" + "\r3. Quitter");

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
				main(null);
				break;

			case 2:// chercher un produit en particulier // marche
				
				System.out.println("\rQuel produit rechercher vous ?");
				Produit prod = new Produit();
				String nomprod = scan.nextLine();
				prod.getProduit(nomprod);
				main(null);
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
				main(null);
				break;

			case 4:// modifier un produit // marche

				System.out.println("Nom du produit: ");
				String nommodif = scan.nextLine();

				Produit modif = new Produit();

				System.out.println("Nouveau nom du produit: ");
				String nvnom = scan.nextLine();

				modif.changerNom(nommodif, nvnom);
				main(null);
				break;

			case 5:// Supprimer un produit // marche

				System.out.println("Quel produit souhaitez vous supprimer ?");
				String nomsup = scan.nextLine();

				Produit sup = new Produit();
				sup.supprimerProduit(nomsup);
				main(null);
				break;

			case 6:// Ajouter du stock à un produit // marche

				System.out.println("Entrez l'id du produit");
				int id = scan.nextInt();
				scan.nextLine();

				Calendar date = Calendar.getInstance();
				Produit prodId = new Produit();
				prodId.setId(id);

				System.out.println("Entrez le nom du fournisseur du produit");
				String nomfour = scan.nextLine();

				int nbrprod = 0;
				while (nbrprod == 0 || nbrprod < 1) {
					try {
						System.out.println("Entrez le nombre de produit livré");
						nbrprod = scan.nextInt();
						scan.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Veuillez entrer un chiffre.");
						scan.nextLine();
					}
				}

				try {
					Achat achat = new Achat(prodId, nomfour, date, nbrprod);

					achat.ajouterStock(id, nomfour, nbrprod);

					achat.ajoutProduit();
				} catch (NullPointerException e) {
					System.out.println("Vous essayer d'ajouter du stock à un produit qui n'existe pas ou plus \n"
							+ "RETOUR AU MENU");
				}
				main(null);
				break;

			case 7:// Afficher l'historique des achat // afficher le nom des produit aussi
				Achat achat = new Achat();
				achat.AfficherHistorique();;

				main(null);
				break;

			case 8:// Retour au menu de connexion

				main(null);
				break;

			case 9:// Quitter

				System.out.println("Au revoir !");
				System.exit(0);
				main(null);
				break;

			default:// Quitter
				
				System.out.println("Au revoir !");
				System.exit(0);
				main(null);
				break;

			}

			break;

		case 2:// CONNEXION CLIENT
			/*
			 * vente // produit // panier
			 */

			System.out.println("Que voulez vous faire?" + "\r1. Afficher les produit disponible"
					+ "\r2. Rechercher un produit" + "\r3. Ajouter un produit au panier" + "\r4. Supprimer un produit"
					+ "\r5. Afficher le panier" + "\r6. Passer commande" + "\r7. Retour au menu de connexion"
					+ "\r8. Quitter");

			selection = 0;
			while (selection == 0 || selection < 1 || selection > 8) {
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

			case 1:

				// afficher la liste de tout les produit // marche
				Produit list = new Produit();
				list.getProduits();

				break;

			case 2:

				// rechercher un produit en particulier // marche
				System.out.println("\rQuel produit rechercher vous ?");
				Produit prod = new Produit();
				String nomprod = scan.nextLine();
				prod.getProduit(nomprod);
				main(null);
				break;

			case 3:
				
				// ajouter un produit au panier // marche pas encore
				System.out.println("\rQuel produit voulez vous ajouter au panier ?");
				Produit panierprod = new Produit();
				String nompanierprod = scan.nextLine();
				panierprod.getProduit(nompanierprod);
				
				System.out.println("\rConfirmer ajout au panier"
						+ "\r1. Oui"
						+ "\r2. Non");
				
				selection = 0;
				while (selection == 0 || selection < 1 || selection > 2) {
					try {
						System.out.print("\rIndiquez votre choix : ");
						selection = scan.nextInt();
						scan.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Veuillez entrer un chiffre.");
						scan.nextLine();
					}
				}
				
				if (selection==1) {
					Produit cartprod = new Produit();
					cartprod.getProduit(nompanierprod);

					Panier cart = new Panier();
					//récuperer l'id du produit
					cartprod.setId(cartprod.getProduitId(nompanierprod));
					// Ajouter le produit au panier
					cart.ajouterPanier(cartprod);
				}
					System.out.println("Retour au menu");
					main(null);
				
				break;

			case 4:

				// supprimer un produit du panier
				
				break;

			case 5:

				// afficher le panier
				Panier panier = new Panier();
				panier.printCartContents();
				
				break;

			case 6:

				// passer commande
				
				break;
			case 7:// Retour au menu de connexion

				main(null);
				break;

			case 8:// Quitter

				System.out.println("Au revoir !");
				System.exit(0);
				main(null);
				break;
			}

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
