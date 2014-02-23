package com.gumtree.addressbook.reader;

import static org.junit.Assert.*;

import com.gumtree.addressbook.processor.chain.PersonProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Tests {@link AddressBookReader}.
 *
 * @author Krzysztof Kachel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/context/test-application-context.xml" })
public class AddressBookReaderTest {

    @Autowired
    private AddressBookReader addressBookReader;

    @Autowired
    private List<PersonProcessor> personProcessors;

    @Test
    public void read_processData_returnRightMessages() throws IOException {
        addressBookReader.read();
        assertEquals("3", personProcessors.get(0).getResultMessage());
        assertEquals("Wes Jackson", personProcessors.get(1).getResultMessage());
        assertEquals("Bill McKnight,2862,Paul Robinson", personProcessors.get(2).getResultMessage());
    }

}
