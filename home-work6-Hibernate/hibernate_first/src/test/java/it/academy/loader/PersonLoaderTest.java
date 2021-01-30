package it.academy.loader;

import it.academy.pojos.Address;
import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.Serializable;

import static org.junit.Assert.*;

public class PersonLoaderTest {

    private Session session;
    Address address = new Address("Sadovaya", "Minsk", "200000");

    @Before
    public void setUp() throws Exception {
        HibernateUtil hibernateUtil = new HibernateUtil("hibernate.cfg.test.xml");
        session = hibernateUtil.getSession();

    }

    @Test
    public void savePerson() {
        Person person = new Person(null, 27, "Maria", "Ivanova", address);
        Transaction tx = null;
        Serializable id;
        try {
            tx = session.beginTransaction();
            id = session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        assertNotNull(id);
        Person personForDelete = session.get(Person.class, id);
        session.beginTransaction();
        session.delete(personForDelete);
        session.getTransaction().commit();
    }

    @Test
    public void deletePerson() {
        Person person = new Person(null, 66, "Nina", "Ivanova", address);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(person);
            Person personForDelete = session.get(Person.class, person.getId());
            session.delete(personForDelete);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        assertNull(session.get(Person.class, person.getId()));
    }

    @Test
    public void findPerson() {
        Person person = new Person(null, 27, "Ivan", "Ivanov", address);
        Person expPerson;
        try {
            session.save(person);
            expPerson = session.get(Person.class, person.getId());
        } catch (Exception e) {
            throw e;
        }
        assertEquals(person, expPerson);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
}