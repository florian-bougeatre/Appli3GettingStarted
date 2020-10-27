package testsjpa;

import entities.ClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TestCreaCli {
    private static final String PERSISTENCE_UNIT_NAME = "magasinUnit";
    private static EntityManagerFactory factory;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        System.out.println("nom :");
        String nom=sc.nextLine();
        System.out.println("prénom :");
        String prenom=sc.nextLine();
        System.out.println("tel :");
        String tel=sc.nextLine();
        //autres infos
        ClientEntity cl = new ClientEntity();
        cl.setNom(nom);
        cl.setPrenom(prenom);
        cl.setTel(tel);
        try {
            em.getTransaction().begin();
            em.persist(cl);
            em.getTransaction().commit();
            System.out.println("numéro de client = "+cl.getIdclient());
        } catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("erreur : "+e);
        }
        em.close();
    }
}