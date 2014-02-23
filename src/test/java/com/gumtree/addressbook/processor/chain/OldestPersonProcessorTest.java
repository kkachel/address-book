package com.gumtree.addressbook.processor.chain;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import com.gumtree.addressbook.domain.Person;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Tests {@link OldestPersonProcessor}.
 *
 * @author Krzysztof Kachel
 */
public class OldestPersonProcessorTest {

    @Test
    public void process_noPerson_returnNull() {
        OldestPersonProcessor processor = new OldestPersonProcessor();
        assertNull(processor.getOldestPerson());
    }

    @Test
    public void process_fewPersons_returnRightPerson() throws ParseException {
        OldestPersonProcessor processor = new OldestPersonProcessor();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String oldestDateString = "14/08/74";
        List<String> dateStrings = Lists.newArrayList("16/03/77", "15/01/85", oldestDateString, "20/11/91", "20/09/80");

        for(String dateString: dateStrings) {
            Date date = dateFormat.parse(dateString);
            Person person = new Person();
            person.setBirthDate(date);
            processor.process(person);
        }

        Date oldestDate = dateFormat.parse(oldestDateString);
        assertEquals(oldestDate, processor.getOldestPerson().getBirthDate());
    }

}
