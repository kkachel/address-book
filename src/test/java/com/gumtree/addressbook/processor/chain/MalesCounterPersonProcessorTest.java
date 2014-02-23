package com.gumtree.addressbook.processor.chain;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import com.gumtree.addressbook.domain.Gender;
import com.gumtree.addressbook.domain.Person;
import org.junit.Test;

import java.util.List;

/**
 * Tests {@link MalesCounterPersonProcessor}.
 *
 * @author Krzysztof Kachel
 */
public class MalesCounterPersonProcessorTest {

    @Test
    public void process_noPerson_returnCountZero() {
        MalesCounterPersonProcessor processor = new MalesCounterPersonProcessor();
        assertEquals(0, processor.getCount());
    }

    @Test
    public void process_fewPersons_returnRightCount() {
        MalesCounterPersonProcessor processor = new MalesCounterPersonProcessor();

        Person person = new Person();
        List<Gender> genders = Lists.newArrayList(Gender.MALE, Gender.MALE,
                Gender.FEMALE, Gender.MALE, Gender.FEMALE, Gender.MALE);

        for(Gender gender: genders) {
            person.setGender(gender);
            processor.process(person);
        }
        assertEquals(4, processor.getCount());
    }

}
