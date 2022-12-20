package co.simplon.Doudouxshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

        System.out.println("--- Connexion ---"
        		+ "\r1. Compte employé"
        		+ "\r2. Compte client");


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
                System.out.println("Option 1 Ajouter un produit");
                //ajouter un produit
                break;
            case 2:
                System.out.println("Option 2Afficher les produits");
                //fficher les produits
                break;
            case 3:
                System.out.println("Option 3 Quitter");
                //quitter
                break;
            default:
                System.out.println("quitter");
                main(null);
                break;
        }
		
		
        scan.close();
	}

}
