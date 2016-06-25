package example.entity;


import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kate on 6/25/16.
 */

    @Entity
    @Table(name = "person")
    @NamedQuery(name = "Person.getAll", query = "select p from Person p")
    public class Person {
        @Id
        @GeneratedValue
        private int id;
        private String name;
        private String surname;

        public Person() {

        }

}
