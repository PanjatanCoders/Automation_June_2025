## ✅ Project 1: Test Case Management Tool (CLI Version)

> **Requirement:**
> *"Assume you are working at XYZ Company as a Software Engineer. Your manager has approached you with a requirement 
> to build a console-based application that can help the QA team manage and validate test cases during early testing 
> cycles. This tool should be simple, lightweight, and should run locally in the terminal without any need for a 
> graphical interface."*

### 📋 Requirements

1. **Console Menu**

    * Show menu with options:

        * Add Test Case
        * View All Test Cases
        * Update Actual Result
        * Filter by Status (PASS / FAIL)
        * Show Summary
        * Export Report (CSV / PDF)
        * Exit

2. **Test Case Structure**

    * Each test case includes:

        * Test Case ID
        * Title
        * Description
        * Expected Result
        * Actual Result
        * Status

3. **Add Test Case**

    * Prompt user to input ID, Title, Description, Expected Result, Actual Result, Status

4. **View All Test Cases**

    * Print all test cases in tabular format
    * Show all fields neatly aligned

5. **Update Actual Result**

    * Select a test case by ID
    * Update status

6. **Filter by Status**

    * Allow user to view only PASS or only FAIL test cases

7. **Test Summary**

    * Show:

        * Total test cases
        * Count of PASS
        * Count of FAIL

8. **Export Report**

    * Allow user to generate:

        * CSV file of all test cases
        * PDF report of test cases (tabular format)

9. **Technology Stack**

    * Java Core
    * Use `Map<Integer, TestCase>` to store test cases in-memory
    * Use Scanner for console I/O

---