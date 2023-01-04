package co.simplon.Doudouxshop;

import java.util.List;

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
import javax.persistence.TypedQuery;

@Entity
@Table(name = "name_like_this")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idproduit")
	private Produit idproduit;
	
	
	
	
	/**
	 * @param idproduit
	 */
	public Panier(Produit idproduit) {
		super();
		this.idproduit = idproduit;
	}
	
	public Panier() {
		super();
	}





	public void ajouterPanier(Produit prod) {
	    // The EntityManager class allows operations such as create, read, update, delete
	    EntityManager em = utils.JPA.getEntityManager();
	    // Used to issue transactions on the EntityManager
	    EntityTransaction et = null;

	    try {
	        // Get transaction and start
	        et = em.getTransaction();
	        et.begin();

	        // Create a new Panier object and set its idproduit field
	        Panier panier = new Panier();
	        panier.setIdproduit(prod);

	        // Save the Panier object
	        em.persist(panier);
	        et.commit();
	        
	        System.out.println("Le produit a bien été ajouté au panier");
	    } catch (Exception ex) {
	        // If there is an exception rollback changes
	        if (et != null) {
	            et.rollback();
	        }
	        ex.printStackTrace();
	    } finally {
	        // Close EntityManager
	        //em.close();
	    }
	}



	public void AfficherHistorique() {
	    EntityManager em = utils.JPA.getEntityManager();

	    // the lowercase a refers to the Achat object
	    String strQuery = "SELECT a FROM Panier a WHERE a.idproduit IS NOT NULL";

	    // Issue the query and get a list of Achat objects
	    TypedQuery<Panier> tq = em.createQuery(strQuery, Panier.class);
	    List<Panier> achats;
	    try {
	        // Get the list of Achat objects and output the details of each purchase
	        achats = tq.getResultList();
	        achats.forEach(achat -> System.out.println("\rFournisseur: " + achat.getIdproduit()));
	    } catch (NoResultException ex) {
	        ex.printStackTrace();
	    } finally {
	        //em.close();
	    }
	}
	
	
	
	public void getProduits() {
		EntityManager em = utils.JPA.getEntityManager();

		// the lowercase p refers to the object
		String strQuery = "SELECT p FROM Panier p where p.id is not null";

		// Issue the query and get a matching Produit
		TypedQuery<Panier> tq = em.createQuery(strQuery, Panier.class);
		List<Panier> produit;
		try {
			// Get matching Produit object and output
			produit = tq.getResultList();
			produit.forEach(prod -> System.out.println(
					"\rNom: " + prod.getIdproduit()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			//em.close();
		}
	}
	

	public void printCartContents() {
	    EntityManager em = utils.JPA.getEntityManager();

	    // Create a TypedQuery to execute the query
	    String query = "SELECT p FROM Panier p WHERE p.idproduit IS NOT NULL";
	    TypedQuery<Panier> tq = em.createQuery(query, Panier.class);

	    // Execute the query and get the result list
	    List<Panier> cartContents = tq.getResultList();

	    // Iterate through the list of Panier objects and print their details
	    for (Panier item : cartContents) {
	        System.out.println("ID: " + item.getId());
	        System.out.println("Produit ID: " + item.getIdproduit().getId());
	    }
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
	 * @return the idproduit
	 */
	public Produit getIdproduit() {
		return idproduit;
	}

	/**
	 * @param idproduit the idproduit to set
	 */
	public void setIdproduit(Produit idproduit) {
		this.idproduit = idproduit;
	}

}