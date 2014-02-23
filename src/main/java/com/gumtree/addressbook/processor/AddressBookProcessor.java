package com.gumtree.addressbook.processor;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.gumtree.addressbook.processor.cell.CellProcessorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.List;

/**
 * Provides cell processors.
 *
 * @author Krzysztof Kachel
 */
@Component
public class AddressBookProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(AddressBookProcessor.class);

    @Autowired
    private List<CellProcessorAdapter> cellProcessors;

    public CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[cellProcessors.size()];
        Function<CellProcessorAdapter, CellProcessor> transformer =
                new Function<CellProcessorAdapter,CellProcessor>() {
                    public CellProcessor apply(CellProcessorAdapter processor) {
                        return processor.getProcessor();
                    }
                };
        LOG.debug("Registered {} cell processors", cellProcessors.size());
        return Lists.transform(cellProcessors, transformer).toArray(processors);
    }

}
