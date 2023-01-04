package co.simplon.Doudouxshop;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Commande {
    public void passerCommande() {
        EntityManager em = utils.JPA.getEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            // Insert data into the vente table
            em.createNativeQuery("INSERT INTO vente (idproduit, dateachat) SELECT idproduit, CURRENT_DATE FROM panier")
                .executeUpdate();

            // Update the quantite field in the produit table
            em.createNativeQuery("UPDATE produit p SET quantite = quantite - v.count FROM (SELECT idproduit, COUNT(*) as count FROM panier GROUP BY idproduit) v WHERE v.idproduit = p.idproduit")
                .executeUpdate();

            // Truncate the panier table
            em.createNativeQuery("TRUNCATE TABLE panier").executeUpdate();

            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}

