package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Process {@link Person} objects.
 * Collects information about the oldest person.
 *
 * @author Krzysztof Kachel
 */
@Component
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

    public Person getOldestPerson() {
        return oldestPerson;
    }

}
