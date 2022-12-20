package co.simplon.Doudouxshop;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "nbrachat")
    private int nbrachat;

    @Column(name = "livré", columnDefinition = "boolean default false")
    private boolean livre;
  
    
	/**
	 * @param idproduit
	 * @param fournisseur
	 * @param nbrachat
	 */
    public Achat(Produit idproduit, String fournisseur, int nbrachat) {
        this.idproduit = idproduit;
        this.fournisseur = fournisseur;
        this.nbrachat = nbrachat;
    }
    

	public void ajouterStock() {
        if (idproduit == null) {
            throw new NullPointerException("L'achat ne possède pas de produit associé");
        }

        EntityManager em = utils.JPA.getEntityManager();
        if (em == null) {
            throw new NullPointerException("L'objet EntityManager n'est pas initialisé");
        }

        em.getTransaction().begin();

        idproduit = em.find(Produit.class, idproduit.getId());
        idproduit.setQuantite(idproduit.getQuantite() + nbrachat);

        em.getTransaction().commit();
        em.close();
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
