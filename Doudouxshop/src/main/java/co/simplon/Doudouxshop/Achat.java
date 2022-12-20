package co.simplon.Doudouxshop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "achat")
public class Achat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idproduit")
    private Produit idproduit;

    @Column(name = "fournisseur", length = 30)
    private String fournisseur;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "nbrachat")
    private int nbrachat;

    @Column(name = "livré", columnDefinition = "boolean default false")
    private boolean livre;

  
    
	/**
	 * @param idproduit
	 * @param fournisseur
	 * @param date
	 * @param nbrachat
	 */
	public Achat(Produit idproduit, String fournisseur, Date date, int nbrachat) {
		super();
		this.idproduit = idproduit;
		this.fournisseur = fournisseur;
		this.date = date;
		this.nbrachat = nbrachat;
	}

	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the livre
	 */
	public boolean isLivre() {
		return livre;
	}

	/**
	 * @param livre the livre to set
	 */
	public void setLivre(boolean livre) {
		this.livre = livre;
	}

   
    
    
}
