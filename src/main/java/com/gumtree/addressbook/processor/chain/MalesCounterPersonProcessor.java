package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Gender;
import com.gumtree.addressbook.domain.Person;

/**
 * Process {@link Person} objects.
 * Calculates number of males.
 *
 * @author Krzysztof Kachel
 */
public class MalesCounterPersonProcessor implements PersonProcessor {

    private int count = 0;

    @Override
    public void process(Person person) {
        if(person.getGender() == Gender.MALE) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

}
