package testsjpa;

import entities.ClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class TestRechCliNom {
    private static final String PERSISTENCE_UNIT_NAME = "magasinUnit";
    private static EntityManagerFactory factory;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        System.out.println("nom recherché :");
        String nom=sc.nextLine();
        Query q = em.createQuery("select c from ClientEntity c where c.nom= :nom");
        q.setParameter("nom",nom);
        List<ClientEntity> result= q.getResultList();
        if(result.isEmpty()) System.out.println("aucun record trouvé");
        for(ClientEntity cl:result){
            System.out.println(cl.getPrenom());
        }
        em.close();
    }
}
