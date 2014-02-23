package com.gumtree.addressbook;

import com.gumtree.addressbook.reader.AddressBookReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Application start class.
 *
 * @author Krzysztof Kachel
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("context/application-context.xml");
            AddressBookReader addressBookReader = (AddressBookReader) context.getBean("addressBookReader");
            addressBookReader.read();
            addressBookReader.showResults();
        } catch(Exception e) {
            LOG.error("Error during main execution", e);
        }
    }

}