package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Person;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Process {@link Person} objects.
 * Calculates how many days one person is older than other person.
 *
 * @author Krzysztof Kachel
 */
@Component
@Order(value=3)
public class DaysOlderPersonProcessor implements PersonProcessor {

    @Value("${days.older.person.template}")
    private String template;

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

    @Override
    public String getResultMessage() {
        DateTime date1 = new DateTime(person1.getBirthDate());
        DateTime date2 = new DateTime(person2.getBirthDate());
        if(date1.isBefore(date2)) {
            int days = Days.daysBetween(date1, date2).getDays();
            return String.format(template, person1.getName(), days, person2.getName());
        } else {
            int days = Days.daysBetween(date2, date1).getDays();
            return String.format(template, person2.getName(), days, person1.getName());
        }
    }

    @Override
    public void reset() {
        person1 = null;
        person2 = null;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }
}
