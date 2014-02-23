package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Gender;
import com.gumtree.addressbook.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Process {@link Person} objects.
 * Calculates number of males.
 *
 * @author Krzysztof Kachel
 */
@Component
@Order(value=1)
public class MalesCounterPersonProcessor implements PersonProcessor {

    @Value("${males.counter.person.template}")
    private String template;

    private int count = 0;

    @Override
    public void process(Person person) {
        if(person.getGender() == Gender.MALE) {
            count++;
        }
    }

    @Override
    public String getResultMessage() {
        return String.format(template, count);
    }

    @Override
    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

}
