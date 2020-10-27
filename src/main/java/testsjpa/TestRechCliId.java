package testsjpa;

import entities.ClientEntity;
import entities.ComfactEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TestRechCliId {
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
        else{
            System.out.println("nom ="+cl.getNom());
            for(ComfactEntity co : cl.getComfactsByIdclient()){
                System.out.println(co.getNumcommande());
            }
        }
        em.close();
    }
}
