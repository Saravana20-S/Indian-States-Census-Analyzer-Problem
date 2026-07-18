package com.bridgelabz.iscap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRuntimeException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/**
 * Service class responsible for loading State Census CSV data.
 */
public class StateCensusAnalyser {

    /**
     * Loads the State Census CSV data and returns the number of records.
     *
     * @param csvFilePath Path to the CSV file
     * @return Number of records loaded
     * @throws StateCensusAnalyserException if any validation fails
     */
    public int loadStateCensusData(String csvFilePath)
            throws StateCensusAnalyserException {

        try {

            // Validate file type
            if (!csvFilePath.toLowerCase().endsWith(".csv")) {
                throw new StateCensusAnalyserException(
                        "Invalid File Type",
                        StateCensusAnalyserException.ExceptionType.CENSUS_FILE_TYPE_INCORRECT);
            }

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCensus> iterator = csvToBean.iterator();

            int recordCount = 0;

            while (iterator.hasNext()) {
                iterator.next();
                recordCount++;
            }

            reader.close();

            return recordCount;

        } catch (CsvRuntimeException e) {

            // Thrown when the CSV format is invalid (e.g., wrong delimiter)
            throw new StateCensusAnalyserException(
                    "Incorrect CSV Delimiter",
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_DELIMITER_INCORRECT);

        } catch (IOException e) {

            throw new StateCensusAnalyserException(
                    "File Problem",
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}