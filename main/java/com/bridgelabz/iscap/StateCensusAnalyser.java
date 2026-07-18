package com.bridgelabz.iscap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/**
 * Service class responsible for loading State Census CSV data.
 */
public class StateCensusAnalyser {

    /**
     * Loads State Census CSV data and returns the number of records.
     *
     * @param csvFilePath Path of the CSV file
     * @return Number of records
     * @throws StateCensusAnalyserException if the file cannot be read
     */
    public int loadStateCensusData(String csvFilePath)
            throws StateCensusAnalyserException {

        try {

            // Check whether the file is a CSV file
            if (!csvFilePath.toLowerCase().endsWith(".csv")) {
                throw new StateCensusAnalyserException(
                        "Invalid File Type. Please provide a CSV file.",
                        StateCensusAnalyserException.ExceptionType.CENSUS_FILE_TYPE_INCORRECT);
            }

            // Read the CSV file
            Reader reader = new FileReader(csvFilePath);

            // Build CsvToBean object
            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            // Iterate through the records
            Iterator<CSVStateCensus> iterator = csvToBean.iterator();

            int recordCount = 0;

            while (iterator.hasNext()) {
                iterator.next();
                recordCount++;
            }

            reader.close();

            return recordCount;

        } catch (StateCensusAnalyserException e) {
            // Re-throw custom exceptions
            throw e;

        } catch (IOException e) {
            throw new StateCensusAnalyserException(
                    "State Census CSV File Problem",
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}