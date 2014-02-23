package com.gumtree.addressbook.processor.chain;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import com.gumtree.addressbook.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link DaysOlderPersonProcessor}.
 *
 * @author Krzysztof Kachel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/context/test-application-context.xml" })
public class DaysOlderPersonProcessorTest {

    @Autowired
    private DaysOlderPersonProcessor daysOlderPersonProcessor;

    @Before
    public void init() {
        daysOlderPersonProcessor.reset();
    }

    @Test
    public void process_noPerson_returnNulls() {
        assertNull(daysOlderPersonProcessor.getPerson1());
        assertNull(daysOlderPersonProcessor.getPerson2());
    }

    @Test
    public void process_fewPersons_returnRightPersons() throws ParseException {
        String person1Name = "Bill McKnight";
        String person2Name = "Paul Robinson";
        List<String> names = Lists.newArrayList("Gemma Lane", person2Name,
                "Sarah Stone", "Wes Jackson", person1Name);

        for(String name: names) {
            Person person = new Person();
            person.setName(name);
            daysOlderPersonProcessor.process(person);
        }

        assertEquals(person1Name, daysOlderPersonProcessor.getPerson1().getName());
        assertEquals(person2Name, daysOlderPersonProcessor.getPerson2().getName());
    }

}
