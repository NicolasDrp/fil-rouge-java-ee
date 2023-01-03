package co.simplon.Doudouxshop;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.Table;

@Entity
@Table(name = "achat")

public class Achatnul {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idachat", unique = true)
	private int idachat;

	@ManyToOne
	@JoinColumn(name = "idproduit")
	private Produit idproduit;

	@Column(name = "fournisseur", length = 30)
	private String fournisseur;

	@Column(name = "date")
	private Date date;

	@Column(name = "nbrachat")
	private int nbrachat;

	/**
	 * @param idproduit
	 * @param fournisseur
	 * @param nbrachat
	 */
	/*public Achat(Produit idproduit, String fournisseur, int nbrachat) {
		this.idproduit = idproduit;
		this.fournisseur = fournisseur;
		this.nbrachat = nbrachat;
	}*/


	public Achatnul() {

	}
	
	public Achatnul(int idproduit, String fournisseur, int nbrachat,Date date) {

	}
	

	public void ajouterStock(int idproduit, String fournisseur, int nbrachat) {

		try {
			EntityManager em = utils.JPA.getEntityManager();

			em.getTransaction().begin();

			Produit produitMaj = em.find(Produit.class, idproduit);
			produitMaj.setQuantite(produitMaj.getQuantite() + nbrachat);

			em.getTransaction().commit();
			em.close();
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("Le produit n'existe pas");
		}
	}

	
	
	
	
	
	/**
	 * @return the produit
	 */
	public Produit getIdproduit() {
		return idproduit;
	}

	/**
	 * @param produit the produit to set
	 */
	public void setIdproduit(Produit idproduit) {
		this.idproduit = idproduit;
	}

	/**
	 * @return the fournisseur
	 */
	public String getFournisseur() {
		return fournisseur;
	}

	/**
	 * @param fournisseur the fournisseur to set
	 */
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the nbrachat
	 */
	public int getNbrachat() {
		return nbrachat;
	}

	/**
	 * @param nbrachat the nbrachat to set
	 */
	public void setNbrachat(int nbrachat) {
		this.nbrachat = nbrachat;
	}

}
