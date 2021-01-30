package it.academy.loader;

import it.academy.pojos.Person;
import org.hibernate.Transaction;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTestLoaderDbunit extends BaseTest {


    @Test
    public void query() {

        cleanInsert("PersonTestLoaderDbunit.xml");

        List<Person> persons = session
                .createQuery("from Person where surname like 'Tes%'", Person.class)
                .list();

        assertEquals(5, persons.size());
        deleteDataset();
    }

    @Test
    public void changeAge() {

        cleanInsert("PersonTestLoaderDbunit.xml");
        int id = 1;
        int age = 99;

        Transaction tx = session.beginTransaction();
        Person person = session.get(Person.class, id);
        person.setAge(age);
        session.flush();
        session.clear();
        tx.commit();

        assertEquals(99, (long) person.getAge());
        deleteDataset();
    }

    @Test
    public void changeName() {

        cleanInsert("PersonTestLoaderDbunit.xml");
        int id = 1;
        String name = "Max";

        Transaction tx = session.beginTransaction();
        Person person = session.get(Person.class, id);
        person.setName(name);
        session.flush();
        session.clear();
        tx.commit();

        assertEquals(name, person.getName());
        deleteDataset();
    }

    @Test
    public void changeSurname() {

        cleanInsert("PersonTestLoaderDbunit.xml");
        int id = 1;
        String surname = "Maximov";

        Transaction tx = session.beginTransaction();
        Person person = session.get(Person.class, id);
        person.setSurname(surname);
        session.flush();
        session.clear();
        tx.commit();

        assertEquals(person.getSurname(), surname);
        deleteDataset();
    }
}
