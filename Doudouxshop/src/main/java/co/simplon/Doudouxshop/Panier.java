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
@Table(name = "panier")
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
		// The EntityManager class allows operations such as create, read, update,
		// delete
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
			// em.close();
		}
	}

	public void supprimerArticle(int idproduit) {
		EntityManager em = utils.JPA.getEntityManager();
		EntityTransaction et = null;

		try {
			et = em.getTransaction();
			et.begin();

			// Find the Panier object with the given idproduit
			TypedQuery<Panier> query = em.createQuery("SELECT p FROM Panier p WHERE p.idproduit.idproduit = :idproduit",
					Panier.class);
			query.setParameter("idproduit", idproduit);
			List<Panier> paniers = query.getResultList();

			if (!paniers.isEmpty()) {
				Panier panier = paniers.get(0);
				em.remove(panier);
			}

			et.commit();

			System.out.println("Le produit a bien été supprimé du panier");
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void AfficherPanier() {
		EntityManager em = utils.JPA.getEntityManager();

		// the lowercase a refers to the Achat object
		String strQuery = "SELECT a FROM Panier a WHERE a.idproduit IS NOT NULL";

		// Issue the query and get a list of Achat objects
		TypedQuery<Panier> tq = em.createQuery(strQuery, Panier.class);
		List<Panier> achats;
		try {
			// Get the list of Achat objects and output the details of each purchase
			achats = tq.getResultList();
			achats.forEach(achat -> System.out.println("\rNom du produit: " + achat.getIdproduit().getNom()
					+ "\rPrix du produit: " + achat.getIdproduit().getPrix() + "€" + "\rProduit disponible: "
					+ achat.getIdproduit().getQuantite()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			// em.close();
		}
	}

	public void AfficherPanierAvecId() {
		EntityManager em = utils.JPA.getEntityManager();

		// the lowercase a refers to the Achat object
		String strQuery = "SELECT a FROM Panier a WHERE a.idproduit IS NOT NULL";

		// Issue the query and get a list of Achat objects
		TypedQuery<Panier> tq = em.createQuery(strQuery, Panier.class);
		List<Panier> achats;
		try {
			// Get the list of Achat objects and output the details of each purchase
			achats = tq.getResultList();
			achats.forEach(achat -> System.out.println("\rNom du produit: " + achat.getIdproduit().getNom()
					+ "\rPrix du produit: " + achat.getIdproduit().getPrix() + "€" + "\rProduit disponible: "
					+ achat.getIdproduit().getQuantite()+"\rId du produit: "+achat.getIdproduit().getId()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			// em.close();
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