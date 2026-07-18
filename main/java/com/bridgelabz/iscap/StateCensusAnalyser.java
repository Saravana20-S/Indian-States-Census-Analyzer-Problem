package com.bridgelabz.iscap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

/**
 * Service class responsible for loading the Indian State Census CSV data.
 */
public class StateCensusAnalyser {

    /**
     * Loads census data from the specified CSV file.
     *
     * @param csvFilePath Path of the census CSV file.
     * @return Number of records loaded.
     * @throws Exception if the file cannot be read.
     */
    public int loadStateCensusData(String csvFilePath) throws Exception {

        // Create a FileReader to read the CSV file
        Reader reader = new FileReader(csvFilePath);

        // Build CsvToBean object for mapping CSV rows to Java objects
        CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                .withType(CSVStateCensus.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        // Iterator to traverse through all census records
        Iterator<CSVStateCensus> iterator = csvToBean.iterator();

        int recordCount = 0;

        // Iterate through each record
        while (iterator.hasNext()) {
            iterator.next();
            recordCount++;
        }

        // Close the reader
        reader.close();

        return recordCount;
    }
}