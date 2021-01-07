package it.academy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     Я пыталась написаит свой первый  unit-test. Но я зашла в тупик. Мне не хватает знаний, так как па предыдущем курсе
     нам эту тему не объесняли(((((
     */
    @Test
    public void shouldAnswerWithTrue() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(1);
        Average average = new Average();

        double actual = average.count(list);
        double expected = 4;
        //assertEquals



    }
}
