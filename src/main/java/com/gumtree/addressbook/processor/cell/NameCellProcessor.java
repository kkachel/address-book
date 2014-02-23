package com.gumtree.addressbook.processor.cell;

import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.constraint.NotNull;

/**
 * Provides processor for person name cell.
 *
 * @author Krzysztof Kachel
 */
@Component
public class NameCellProcessor implements CellProcessorAdapter {

    public CellProcessorAdaptor getProcessor() {
        return new NotNull(new Trim());
    }

}
