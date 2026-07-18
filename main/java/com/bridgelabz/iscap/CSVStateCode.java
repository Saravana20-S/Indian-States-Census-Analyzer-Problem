package com.bridgelabz.iscap;

import com.opencsv.bean.CsvBindByName;

/**
 * Model class representing one record of the State Code CSV.
 */
public class CSVStateCode {

    // Serial Number
    @CsvBindByName(column = "SrNo")
    public int srNo;

    // State Name
    @CsvBindByName(column = "StateName")
    public String stateName;

    // TIN Number
    @CsvBindByName(column = "TIN")
    public int tin;

    // State Code
    @CsvBindByName(column = "StateCode")
    public String stateCode;
}