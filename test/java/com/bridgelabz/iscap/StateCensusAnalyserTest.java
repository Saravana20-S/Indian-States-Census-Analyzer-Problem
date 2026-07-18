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
}