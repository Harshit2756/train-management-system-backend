package com.tcs.train.util;

public class CsvValidator {

  public static boolean isValidCsv(String csvContent) {
    // Simple validation: check if not empty and contains at least one comma
    return csvContent != null && csvContent.contains(",");
  }
}
