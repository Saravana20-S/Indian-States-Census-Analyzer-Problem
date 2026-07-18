package com.bridgelabz.iscap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for StateCensusAnalyser.
 */
public class StateCensusAnalyserTest {

    // Path to the valid State Census CSV file
    private static final String STATE_CENSUS_CSV_FILE_PATH =
            "src/test/resources/IndiaStateCensusData.csv";

    /**
     * TC1.1:
     * Given a valid State Census CSV file,
     * when the analyser loads the data,
     * then it should return the correct number of records.
     */
    @Test
    public void givenStateCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount() {

        try {
            // Create analyser object
            StateCensusAnalyser analyser = new StateCensusAnalyser();

            // Load the CSV file and get the record count
            int recordCount = analyser.loadStateCensusData(STATE_CENSUS_CSV_FILE_PATH);

            // Verify the expected number of records
            Assertions.assertEquals(29, recordCount);

        } catch (Exception e) {
            // Fail the test if any exception occurs
            Assertions.fail("Test failed due to exception: " + e.getMessage());
        }
    }


    /**
     * TC1.2:
     * Given an incorrect State Census CSV file path,
     * when the analyser loads the file,
     * then it should throw a custom exception.
     */
    @Test
    public void givenWrongStateCensusCSVFile_WhenLoaded_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {
            analyser.loadStateCensusData("src/test/resources/WrongFile.csv");
            Assertions.fail("Expected StateCensusAnalyserException was not thrown.");

        } catch (StateCensusAnalyserException e) {

            Assertions.assertEquals(
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    e.type);
        }
    }



    /**
     * TC1.3:
     * Given a State Census file with an incorrect file type,
     * when the analyser loads the file,
     * then it should throw a custom exception.
     */
    @Test
    public void givenStateCensusFile_WhenIncorrectFileType_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {

            analyser.loadStateCensusData("src/test/resources/IndiaStateCensusData.txt");

            Assertions.fail("Expected StateCensusAnalyserException was not thrown.");

        } catch (StateCensusAnalyserException e) {

            Assertions.assertEquals(
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_TYPE_INCORRECT,
                    e.type);
        }
    }


    /**
     * TC1.4:
     * Given a State Census CSV file with an incorrect delimiter,
     * when the analyser loads the file,
     * then it should throw a custom exception.
     */
    @Test
    public void givenStateCensusCSVFile_WhenDelimiterIncorrect_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {

            analyser.loadStateCensusData(
                    "src/test/resources/IndiaStateCensusWrongDelimiter.csv");

            Assertions.fail("Expected StateCensusAnalyserException was not thrown.");

        } catch (StateCensusAnalyserException e) {

            Assertions.assertEquals(
                    StateCensusAnalyserException.ExceptionType.CENSUS_FILE_DELIMITER_INCORRECT,
                    e.type);
        }
    }


    /**
     * TC1.5:
     * Given a State Census CSV file with an incorrect header,
     * when the analyser loads the file,
     * then it should throw a custom exception.
     */
    @Test
    public void givenStateCensusCSVFile_WhenHeaderIncorrect_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {

            analyser.loadStateCensusData(
                    "src/test/resources/IndiaStateCensusWrongHeader.csv");

            Assertions.fail("Expected StateCensusAnalyserException was not thrown.");

        } catch (StateCensusAnalyserException e) {

            Assertions.assertEquals(
                    StateCensusAnalyserException.ExceptionType.CENSUS_HEADER_INCORRECT,
                    e.type);
        }
    }
}