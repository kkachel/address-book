package com.gumtree.addressbook.processor.cell;

import org.springframework.beans.factory.annotation.Value;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.constraint.NotNull;

/**
 * Provides processor for person birth date cell.
 *
 * @author Krzysztof Kachel
 */
public class BirthDateCellProcessor implements CellProcessorAdapter {

    public CellProcessorAdaptor getProcessor() {
        return new NotNull(new Trim(new ParseDate("dd/MM/yy")));
    }

}