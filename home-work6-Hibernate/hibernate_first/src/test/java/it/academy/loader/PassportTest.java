package it.academy.loader;


import it.academy.pojos.Passport;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PassportTest extends BaseTest {

    @Test
    public void create() {
        Passport passport = new Passport();
        passport.setPassportNumber("AA1234567");
        passport.setIssuedDate(Date.valueOf("2010-01-01"));
        passport.expiryDate = Date.valueOf("2015-01-01");
        passport.loginTime = Date.valueOf("2021-02-02");// в БД не будет отображено , т.к. @Transient

        Transaction transaction = session.beginTransaction();

        final Serializable id = session.save(passport);
        transaction.commit();
        assertNotNull(id);
    }

    @Test
    public void readAll() {
        cleanInsert("PassportTest.xml");


        List<Passport> passports = session
                .createQuery("from Passport", Passport.class)
                .list();

        assertEquals(3, passports.size());
        deleteDataset();
    }
}
