package com.diginamic.entity;

import jakarta.persistence.*;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestBibliothequeexécutable {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa");
             EntityManager entityManager = entityManagerFactory.createEntityManager();
        ) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            String jpql = "from CompoEntity where idEmp = 2";
            Query query = entityManager.createQuery(jpql);
            List<CompoEntity> compos = query.getResultList();
            for (CompoEntity ce: compos
                 ) {
                LivreEntity livre = entityManager.find(LivreEntity.class,ce.getIdLiv());
                System.out.println(livre);
            }
            System.out.println("*********************************************");

            ClientEntity client = entityManager.find(ClientEntity.class,1);
            Set<EmpruntEntity> emprunts = client.getEmprunts();
            for (EmpruntEntity ee: emprunts
                 ) {
                System.out.println(ee);
            }
            System.out.println("***************************************************");

            tx.commit();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
