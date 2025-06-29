package com.saddy.enumdemo;

public enum TestStatus {
    PASS("Test Passed Successfully!!"),
    FAIL("Test Failed!!"),
    SKIPP("Test Skipped!!"),
    BLOCK("Test Blocked!!"),
    UNTESTED("Test Untested!!");

    private final String statusDescription;

    TestStatus(String statusDescription){
        this.statusDescription = statusDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

}
