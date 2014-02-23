package com.gumtree.addressbook.processor.cell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.constraint.NotNull;

/**
 * Provides processor for person birth date cell.
 *
 * @author Krzysztof Kachel
 */
@Component
public class BirthDateCellProcessor implements CellProcessorAdapter {

    @Value("${file.cell.date.format}")
    private String dateFormat;

    public CellProcessorAdaptor getProcessor() {
        return new NotNull(new Trim(new ParseDate(dateFormat)));
    }

}