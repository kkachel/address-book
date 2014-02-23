package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Person;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Process {@link Person} objects.
 * Collects information about the oldest person.
 *
 * @author Krzysztof Kachel
 */
@Component
@Order(value=2)
public class OldestPersonProcessor implements PersonProcessor {

    private Person oldestPerson;

    @Override
    public void process(Person person) {
        if(oldestPerson == null) {
            oldestPerson = person;
        } else if(oldestPerson.getBirthDate().after(person.getBirthDate())) {
            oldestPerson = person;
        }
    }

    @Override
    public void reset() {
        oldestPerson = null;
    }

    public Person getOldestPerson() {
        return oldestPerson;
    }

}
