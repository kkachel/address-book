package com.gumtree.addressbook.processor.cell;

import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Provides file cell processor.
 *
 * @author Krzysztof Kachel
 */
public interface CellProcessorAdapter {

    public CellProcessor getProcessor();

}
