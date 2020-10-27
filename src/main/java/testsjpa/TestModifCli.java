package testsjpa;

import entities.ClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TestModifCli {
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
            System.out.println("nom ="+cl.getNom());
            System.out.println("nouveau nom :");
            String nom = sc.nextLine();
            try {
                em.getTransaction().begin();
                cl.setNom(nom);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.clear();
                System.out.println("erreur de mise à jour : "+e.getMessage());
            }
            cl= em.find(ClientEntity.class, id);
            System.out.println("nom ="+cl.getNom());
        }
        em.close();
    }
}
