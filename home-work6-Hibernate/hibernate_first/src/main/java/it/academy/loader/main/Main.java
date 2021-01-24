package it.academy.loader.main;

import it.academy.loader.PersonLoader;
import it.academy.pojos.Person;

public class Main {

    public static void main(String[] args) throws Exception {

        Person person1 = new Person(null, 25, "Maria", "Ivanova");
        Person person2 = new Person(null, 27, "Ivan", "Ivanov");
        Person person3 = new Person(null, 1, "Igor", "Ivanov");
        Person person4 = new Person(null, 3, "Alex", "Ivanov");
        PersonLoader personLoader = new PersonLoader();
        personLoader.savePerson(person1);
        personLoader.savePerson(person2);
        personLoader.savePerson(person3);
        personLoader.savePerson(person4);

        personLoader.deletePerson(person4.getId());

        Person findPerson = personLoader.findPerson(person1.getId());

        personLoader.changeAge(person1.getId(), 20);
        personLoader.changeName(person1.getId(), "Sofia");
        personLoader.changeSurName(person1.getId(), "Smirnov");

    }
}
