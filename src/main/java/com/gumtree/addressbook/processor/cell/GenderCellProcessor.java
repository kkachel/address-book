package com.gumtree.addressbook.processor.cell;

import com.google.common.collect.ImmutableMap;
import com.gumtree.addressbook.domain.Gender;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.HashMapper;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.constraint.NotNull;

import java.util.Map;

/**
 * Provides processor for person gender cell.
 *
 * @author Krzysztof Kachel
 */
public class GenderCellProcessor implements CellProcessorAdapter {

    public CellProcessorAdaptor getProcessor() {
        Map genderMapping = (Map) ImmutableMap.of(
                Gender.MALE.getName(), Gender.MALE,
                Gender.FEMALE.getName(), Gender.FEMALE
        );
        return new NotNull(new Trim(new HashMapper(genderMapping)));
    }

}