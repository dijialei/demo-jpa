import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJpa {
    public static void main(String[] args) {
        try(
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa");
                EntityManager entityManager = entityManagerFactory.createEntityManager()
                ) {
            System.out.println(entityManager);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
