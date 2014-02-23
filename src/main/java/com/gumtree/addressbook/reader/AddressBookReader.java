package com.gumtree.addressbook.reader;

import com.gumtree.addressbook.domain.Person;
import com.gumtree.addressbook.processor.AddressBookProcessor;
import com.gumtree.addressbook.processor.chain.PersonProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Reads address book.
 *
 * @author Krzysztof Kachel
 */
@Component
public class AddressBookReader {

    private static final Logger LOG = LoggerFactory.getLogger(AddressBookReader.class);

    @Autowired
    private AddressBookProcessor addressBookProcessor;

    @Autowired
    private List<PersonProcessor> personProcessors;

    @Value("${address.book.file.location}")
    private String fileLocation;

    @Value("${file.cell.to.person.mapping}")
    private String[] mapping;

    /**
     * Reads {@link Person} objects from file and process them using chain of {@link PersonProcessor}.
     *
     * @throws IOException
     */
    public void read() throws IOException {
        ICsvBeanReader beanReader = null;
        try {
            LOG.debug("Start reading file with {} person processors", personProcessors.size());
            beanReader = new CsvBeanReader(new FileReader(fileLocation), CsvPreference.STANDARD_PREFERENCE);
            final CellProcessor[] processors =  addressBookProcessor.getProcessors();
            Person person;
            while( (person = beanReader.read(Person.class, mapping, processors)) != null ) {
                for(PersonProcessor processor: personProcessors) {
                    processor.process(person);
                }
            }
        } finally {
            if( beanReader != null ) {
                beanReader.close();
            }
        }
    }

    /**
     * Display results to console.
     */
    public void showResults() {
        for(PersonProcessor processor: personProcessors) {
            System.out.println(processor.getResultMessage());
        }
    }

}
