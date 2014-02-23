package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Person;
import org.springframework.beans.factory.annotation.Value;

/**
 * Process {@link Person} objects.
 * Calculates how many days one person is older than other person.
 *
 * @author Krzysztof Kachel
 */
public class DaysOlderPersonProcessor implements PersonProcessor {

    @Value("${days.older.person.name1}")
    private String personName1;

    @Value("${days.older.person.name2}")
    private String personName2;

    private Person person1;

    private Person person2;

    @Override
    public void process(Person person) {
        String name = person.getName().toLowerCase();
        if(person1 == null && name.contains(personName1)) {
            person1 = person;
        } else if(person2 == null && name.contains(personName2)) {
            person2 = person;
        }
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }
}
