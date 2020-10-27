package testsjpa;

import entities.ClientEntity;
import entities.ComfactEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TestCreaCom {
    private static final String PERSISTENCE_UNIT_NAME = "magasinUnit";
    private static EntityManagerFactory factory;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        System.out.println("numéro recherché :");
        int id = sc.nextInt();
        ClientEntity cl = em.find(ClientEntity.class, id);
        if(cl==null) System.out.println("identifiant client inconnu");
        else {
            System.out.println("nom ="+cl.getNom());
            ComfactEntity co = new ComfactEntity();
            co.setApiClientByIdclient(cl);
            co.setEtat("c");
            System.out.println("montant :");
            BigDecimal montant = sc.nextBigDecimal();
            co.setMontant(montant.setScale(2, RoundingMode.HALF_UP));
            try {
                em.getTransaction().begin();
                em.persist(co);
                em.getTransaction().commit();
            } catch(Exception e){
                em.getTransaction().rollback();
                System.out.println("erreur de création : "+e.getMessage());
            }
        }
        em.close();
    }
}
