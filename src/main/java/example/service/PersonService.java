package example.service;

import example.entity.Person;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by kate on 6/25/16.
 */

public class PersonService {
    private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public void save(Person person){
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void delete(Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }

    public Person get(int id) {
        return em.find(Person.class, id);
    }

    public void update(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public List<Person> getAll() {
        TypedQuery<Person> namedQuery = em.createNamedQuery("Person.getAll",Person.class);
        return namedQuery.getResultList();
    }

}
