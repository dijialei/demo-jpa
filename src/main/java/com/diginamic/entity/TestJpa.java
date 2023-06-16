package com.diginamic.entity;

import jakarta.persistence.*;

import java.util.List;

public class TestJpa {
    public static void main(String[] args) {
        try (
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa");
                EntityManager entityManager = entityManagerFactory.createEntityManager();

        ) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            LivreEntity livre = new LivreEntity("Germinal NEW", "Emile Zola");

            entityManager.persist(livre);


            LivreEntity livreFind = entityManager.find(LivreEntity.class, 2);
            System.out.println(livreFind);
            System.out.println("******************************************************");

            LivreEntity livreUpdate = entityManager.find(LivreEntity.class, 5);
            livreUpdate.setTitre("Du plaisir dans la cuisine");

            LivreEntity livreDelete = entityManager.find(LivreEntity.class, 16);
            if (livreDelete != null) entityManager.remove(livreDelete);

            String jpql = "from LivreEntity where titre = 'Vingt mille lieues sous les mers'";
            Query query = entityManager.createQuery(jpql);
            List<LivreEntity> livreEntityList = query.getResultList();
            for (LivreEntity l:livreEntityList
                 ) {
                System.out.println(l);
            }
            System.out.println("**************************************************");

            jpql="from LivreEntity where auteur = 'Emile Zola'";
            query = entityManager.createQuery(jpql);
            livreEntityList = query.getResultList();
            for (LivreEntity l : livreEntityList
                 ) {
                System.out.println(l);
            }
            System.out.println("*****************************************************");

            jpql = "from LivreEntity";
            query = entityManager.createQuery(jpql);
            livreEntityList = query.getResultList();
            for (LivreEntity l : livreEntityList
            ) {
                System.out.println(l);
            }
            transaction.commit();


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
