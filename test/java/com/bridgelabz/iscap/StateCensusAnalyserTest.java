package com.bridgelabz.iscap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for StateCensusAnalyser.
 */
public class StateCensusAnalyserTest {

    // Replace this path with your CSV file path
    private static final String CSV_FILE_PATH =
            "src/test/resources/IndiaStateCensusData.csv";

    /**
     * Test to verify whether all census records are loaded successfully.
     */
    @Test
    public void givenStateCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount() {

        try {

            StateCensusAnalyser analyser = new StateCensusAnalyser();

            int numberOfRecords = analyser.loadStateCensusData(CSV_FILE_PATH);

            // Expected number of records in the CSV file
            Assertions.assertEquals(29, numberOfRecords);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}