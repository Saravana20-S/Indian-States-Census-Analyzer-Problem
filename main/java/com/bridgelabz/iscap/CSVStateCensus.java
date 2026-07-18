package com.bridgelabz.iscap;

import com.opencsv.bean.CsvBindByName;

/**
 * Model class representing one record of the Indian State Census CSV.
 * Each object corresponds to one row in the CSV file.
 */
public class CSVStateCensus {

    // Name of the state
    @CsvBindByName(column = "State")
    public String state;

    // Population of the state
    @CsvBindByName(column = "Population")
    public long population;

    // Area of the state in square kilometers
    @CsvBindByName(column = "AreaInSqKm")
    public long areaInSqKm;

    // Density per square kilometer
    @CsvBindByName(column = "DensityPerSqKm")
    public int densityPerSqKm;
}