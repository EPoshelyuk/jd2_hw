package it.academy.loader;

import it.academy.pojos.Email;
import it.academy.pojos.Passport;
import it.academy.pojos.Person;
import org.junit.Test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IdGettingTest extends BaseTest {

    @Test
    public void getPassportId() {
        cleanInsert("PassportTest.xml");
        List<Passport> passports = session.createQuery("FROM Passport ", Passport.class).list();
        List<Serializable> ids = new ArrayList<>();

        passports.forEach(passport -> {
            ids.add(session.getIdentifier(passport));
        });

        for (Serializable id : ids) {
            System.out.println(id);
        }
        assertEquals(3, ids.size());
        deleteDataset();
    }

    @Test
    public void getPersonId() {
        cleanInsert("PersonTestLoaderDbunit.xml");

        List<Person> persons = session.createQuery("FROM Person ", Person.class).list();
        List<Serializable> ids = new ArrayList<>();

        persons.forEach(person -> {
            ids.add(session.getIdentifier(person));
        });

        for (Serializable id : ids) {
            System.out.println(id);
        }
        assertEquals(5, ids.size());
        deleteDataset();
    }

    @Test
    public void getEmailId() {
        cleanInsert("EmailTest.xml");

        List<Email> emails = session.createQuery("FROM Email", Email.class).list();
        List<Serializable> ids = new ArrayList<>();

        emails.forEach(email -> {
            ids.add(session.getIdentifier(email));
        });

        for (Serializable id : ids) {
            System.out.println(id);
        }
        assertEquals(2, ids.size());
        deleteDataset();
    }

}