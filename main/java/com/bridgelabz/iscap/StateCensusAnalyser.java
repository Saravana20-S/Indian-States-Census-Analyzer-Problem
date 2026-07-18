package com.bridgelabz.iscap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRuntimeException;

import java.io.BufferedReader;
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
     * @param csvFilePath Path of the CSV file.
     * @return Number of records in the CSV file.
     * @throws StateCensusAnalyserException if any validation fails.
     */
    public int loadStateCensusData(String csvFilePath)
            throws StateCensusAnalyserException {

        try {

            // Validate file extension
            if (!csvFilePath.endsWith(".csv")) {
                throw new StateCensusAnalyserException(
                        "Incorrect File Type",
                        StateCensusAnalyserException.ExceptionType.CENSUS_FILE_TYPE_INCORRECT);
            }

            // Read and validate the CSV header
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));
            String header = bufferedReader.readLine();

            String expectedHeader = "State,Population,AreaInSqKm,DensityPerSqKm";

            if (!expectedHeader.equals(header)) {
                throw new StateCensusAnalyserException(
                        "Incorrect CSV Header",
                        StateCensusAnalyserException.ExceptionType.CENSUS_HEADER_INCORRECT);
            }

            bufferedReader.close();

            // Read CSV using OpenCSV
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

            throw new StateCensusAnalyserException(
                    "Incorrect CSV Delimiter",
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_DELIMITER_INCORRECT);

        } catch (IOException e) {

            throw new StateCensusAnalyserException(
                    "File Problem",
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }



    /**
     * Loads the State Code CSV data.
     *
     * @param csvFilePath path of the State Code CSV file
     * @return number of records loaded
     * @throws StateCensusAnalyserException if any error occurs
     */
    public int loadStateCodeData(String csvFilePath)
            throws StateCensusAnalyserException {

        try {

            // Validate file type
            if (!csvFilePath.endsWith(".csv")) {
                throw new StateCensusAnalyserException(
                        "Incorrect File Type",
                        StateCensusAnalyserException.ExceptionType.CENSUS_FILE_TYPE_INCORRECT);
            }

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCode> csvToBean =
                    new CsvToBeanBuilder<CSVStateCode>(reader)
                            .withType(CSVStateCode.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCode> iterator = csvToBean.iterator();

            int recordCount = 0;

            while (iterator.hasNext()) {
                iterator.next();
                recordCount++;
            }

            reader.close();

            return recordCount;

        } catch (IOException e) {

            throw new StateCensusAnalyserException(
                    "State Code File Problem",
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}