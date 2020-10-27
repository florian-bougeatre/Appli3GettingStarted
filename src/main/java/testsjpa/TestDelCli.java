package testsjpa;

import entities.ClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TestDelCli {
    private static final String PERSISTENCE_UNIT_NAME = "magasinUnit";
    private static EntityManagerFactory factory;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        System.out.println("numéro recherché :");
        int id = sc.nextInt();
        sc.skip("\n");
        ClientEntity cl = em.find(ClientEntity.class, id);
        if(cl==null) System.out.println("identifiant client inconnu");
        else {
            try {
                em.getTransaction().begin();
                em.remove(cl);
                em.getTransaction().commit();
                System.out.println("record effacé");
            } catch (Exception e) {
                em.clear();
                System.out.println("erreur d'effacement : "+e.getMessage());
            }
            cl= em.find(ClientEntity.class, id);
            if(cl!=null) System.out.println("Record non effacé nom ="+cl.getNom());
            else System.out.println("confirmation de l'effacement");
        }
        em.close();
    }
}
