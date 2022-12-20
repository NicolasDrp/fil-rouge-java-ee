package co.simplon.Doudouxshop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")

public class Produit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduit", unique = true)
	private int id;

	@Column(name = "nomproduit",length = 30, nullable = false)
	private String nom;

	@Column(name = "prix", nullable = false)
	private double prix;

	@Column(name = "quantite", nullable = false)
	private int quantite;


	
	
	/**
	 * @param nom
	 * @param prix
	 * @param quantite
	 */
	public Produit(String nom, double prix, int quantite) {
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}


	public void ajoutProduit() {

		// The EntityManager class allows operations such as create, read, update,
		// delete
		EntityManager em = utils.JPA.getEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction et = null;

		try {
			// Get transaction and start
			et = em.getTransaction();
			et.begin();

			// Create and set values for new customer
			Produit produit = new Produit(this.nom, this.prix, this.quantite);

			// Save the customer object
			em.persist(produit);
			et.commit();
		} catch (Exception ex) {
			// If there is an exception rollback changes
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			// Close EntityManager
			em.close();
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
