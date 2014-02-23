package com.gumtree.addressbook.processor.chain;

import com.gumtree.addressbook.domain.Person;

/**
 * Process {@link Person} objects.
 *
 * @author Krzysztof Kachel
 */
public interface PersonProcessor {

    public void process(Person person);

}
