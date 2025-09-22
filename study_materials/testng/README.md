# Complete TestNG Tutorial

TestNG is a powerful testing framework for Java that provides advanced features like parallel execution, data-driven testing, and flexible test configuration through annotations.

## Installation & Setup

### Maven Dependency
```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.0</version>
    <scope>test</scope>
</dependency>
```

### Gradle Dependency
```gradle
testImplementation 'org.testng:testng:7.8.0'
```

## Core Annotations

### Basic Test Structure
```java
import org.testng.annotations.*;
import org.testng.Assert;

public class BasicTestExample {

    @BeforeClass
    public void setUpClass() {
        System.out.println("Before all test methods in this class");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before each test method");
    }

    @Test
    public void testAddition() {
        int result = 2 + 3;
        Assert.assertEquals(result, 5);
    }

    @Test(priority = 1)
    public void testMultiplication() {
        int result = 4 * 5;
        Assert.assertEquals(result, 20);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After each test method");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("After all test methods in this class");
    }
}
```

### Annotation Hierarchy
```java
@BeforeSuite    // Runs once before all tests in suite
@BeforeTest     // Runs before each <test> tag in XML
@BeforeClass    // Runs once before all methods in class
@BeforeMethod   // Runs before each test method
@Test           // The actual test method
@AfterMethod    // Runs after each test method
@AfterClass     // Runs once after all methods in class
@AfterTest      // Runs after each <test> tag in XML
@AfterSuite     // Runs once after all tests in suite
```

## Test Attributes & Configuration

### Test Method Attributes
```java
public class TestAttributes {

    @Test(description = "Test user login functionality")
    public void testLogin() {
        // Test implementation
    }

    @Test(enabled = false)
    public void disabledTest() {
        // This test will be skipped
    }

    @Test(timeOut = 2000) // Fails if takes more than 2 seconds
    public void timeoutTest() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void exceptionTest() {
        throw new IllegalArgumentException("Expected exception");
    }

    @Test(invocationCount = 3) // Run 3 times
    public void repeatedTest() {
        System.out.println("This test runs 3 times");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testLogout() {
        // Runs only if testLogin passes
    }
}
```

## Assertions

### Common Assertions
```java
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionExamples {

    @Test
    public void hardAssertions() {
        // Hard assertions - stop execution on failure
        Assert.assertEquals("actual", "expected");
        Assert.assertTrue(5 > 3);
        Assert.assertFalse(2 > 5);
        Assert.assertNotNull("not null");
        Assert.assertNull(null);

        // Array assertions
        int[] actual = {1, 2, 3};
        int[] expected = {1, 2, 3};
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void softAssertions() {
        SoftAssert softAssert = new SoftAssert();

        // Soft assertions - continue execution, report all failures
        softAssert.assertEquals("actual", "expected");
        softAssert.assertTrue(false, "This will fail but continue");
        softAssert.assertNotNull(null, "This will also fail");

        // Must call assertAll() to report failures
        softAssert.assertAll();
    }
}
```

## Data-Driven Testing

### Using @DataProvider
```java
public class DataDrivenTests {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"user1", "pass1", true},
                {"user2", "pass2", false},
                {"admin", "admin123", true}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean expected) {
        boolean result = authenticateUser(username, password);
        Assert.assertEquals(result, expected);
    }

    // DataProvider with Iterator
    @DataProvider(name = "numberData")
    public Iterator<Object[]> getNumbers() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{1, 2, 3});
        data.add(new Object[]{4, 5, 9});
        data.add(new Object[]{10, 15, 25});
        return data.iterator();
    }

    @Test(dataProvider = "numberData")
    public void testAddition(int a, int b, int sum) {
        Assert.assertEquals(a + b, sum);
    }

    private boolean authenticateUser(String username, String password) {
        return username.equals("user1") || username.equals("admin");
    }
}
```

### External Data Sources
```java
import com.opencsv.CSVReader;
import java.io.FileReader;

public class ExternalDataProvider {

    @DataProvider(name = "csvData")
    public Object[][] getCsvData() throws Exception {
        CSVReader reader = new CSVReader(new FileReader("test-data.csv"));
        List<String[]> rows = reader.readAll();
        reader.close();

        Object[][] data = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }
        return data;
    }

    @Test(dataProvider = "csvData")
    public void testWithCsvData(String name, String email, String age) {
        // Test implementation using CSV data
        Assert.assertNotNull(name);
        Assert.assertTrue(email.contains("@"));
        Assert.assertTrue(Integer.parseInt(age) > 0);
    }
}
```

## Grouping Tests

### Test Groups
```java
public class TestGroups {

    @Test(groups = {"smoke", "regression"})
    public void smokeTest1() {
        System.out.println("Smoke test 1");
    }

    @Test(groups = "smoke")
    public void smokeTest2() {
        System.out.println("Smoke test 2");
    }

    @Test(groups = "regression")
    public void regressionTest1() {
        System.out.println("Regression test 1");
    }

    @Test(groups = {"integration", "database"})
    public void integrationTest() {
        System.out.println("Integration test");
    }

    @BeforeGroups("smoke")
    public void setUpSmokeTests() {
        System.out.println("Setup for smoke tests");
    }

    @AfterGroups("smoke")
    public void tearDownSmokeTests() {
        System.out.println("Cleanup for smoke tests");
    }
}
```

## Parallel Execution

### TestNG XML Configuration
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="ParallelSuite" parallel="methods" thread-count="3">
    <test name="ParallelTest">
        <classes>
            <class name="com.example.ParallelTests"/>
        </classes>
    </test>
</suite>
```

### Thread-Safe Test Class
```java
public class ParallelTests {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriver webDriver = new ChromeDriver();
        driver.set(webDriver);
    }

    @Test
    public void parallelTest1() {
        driver.get().get("https://example.com");
        // Test implementation
    }

    @Test
    public void parallelTest2() {
        driver.get().get("https://example2.com");
        // Test implementation
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
```

## TestNG XML Configuration

### Complete testng.xml Example
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="CompleteSuite" parallel="classes" thread-count="2" verbose="1">

    <parameter name="browser" value="chrome"/>
    <parameter name="environment" value="staging"/>

    <listeners>
        <listener class-name="com.example.CustomTestListener"/>
    </listeners>

    <test name="SmokeTests">
        <groups>
            <run>
                <include name="smoke"/>
            </run>
        </groups>
        <classes>
            <class name="com.example.LoginTests"/>
            <class name="com.example.NavigationTests"/>
        </classes>
    </test>

    <test name="RegressionTests">
        <groups>
            <run>
                <include name="regression"/>
                <exclude name="slow"/>
            </run>
        </groups>
        <packages>
            <package name="com.example.regression"/>
        </packages>
    </test>

    <test name="SpecificMethods">
        <classes>
            <class name="com.example.UserTests">
                <methods>
                    <include name="testCreateUser"/>
                    <include name="testUpdateUser"/>
                </methods>
            </class>
        </classes>
    </test>

</suite>
```

## Listeners and Reporting

### Custom Test Listener
```java
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getMethod().getMethodName());
        System.out.println("Failure Reason: " + result.getThrowable());

        // Take screenshot on failure
        takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }

    private void takeScreenshot(String testName) {
        // Screenshot implementation
        System.out.println("Screenshot taken for: " + testName);
    }
}
```

### Retry Analyzer
```java
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxTry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            }
        }
        return false;
    }
}

// Usage in test class
public class RetryTests {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flakyTest() {
        // Test that might fail intermittently
        if (Math.random() > 0.5) {
            Assert.fail("Random failure");
        }
    }
}
```

## Advanced Features

### Factory Pattern for Test Creation
```java
import org.testng.annotations.Factory;

public class TestFactory {

    @Factory
    public Object[] createInstances() {
        return new Object[] {
                new BrowserTest("chrome"),
                new BrowserTest("firefox"),
                new BrowserTest("edge")
        };
    }
}

class BrowserTest {
    private String browserName;

    public BrowserTest(String browserName) {
        this.browserName = browserName;
    }

    @Test
    public void testInBrowser() {
        System.out.println("Running test in: " + browserName);
        // Browser-specific test logic
    }
}
```

### Parameters from TestNG XML
```java
public class ParameterizedTests {
    
    @Parameters({"browser", "environment"})
    @BeforeMethod
    public void setUp(String browser, String environment) {
        System.out.println("Browser: " + browser);
        System.out.println("Environment: " + environment);
        // Setup based on parameters
    }
    
    @Parameters("username")
    @Test
    public void testWithParameter(String username) {
        System.out.println("Testing with user: " + username);
    }
}
```

### Test Dependencies
```java
public class DependencyTests {
    
    @Test
    public void testLogin() {
        System.out.println("Login test");
        // Login logic
    }
    
    @Test(dependsOnMethods = "testLogin")
    public void testCreateOrder() {
        System.out.println("Create order test");
    }
    
    @Test(dependsOnMethods = {"testLogin", "testCreateOrder"})
    public void testPayment() {
        System.out.println("Payment test");
    }
    
    @Test(dependsOnGroups = "smoke")
    public void testAfterSmoke() {
        System.out.println("Runs after all smoke tests");
    }
}
```

## Best Practices

### Page Object with TestNG
```java
// Page Object
public class LoginPage {
    private WebDriver driver;
    
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")  
    private WebElement passwordField;
    
    @FindBy(id = "loginBtn")
    private WebElement loginButton;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}

// Test Class
public class LoginPageTest extends BaseTest {
    
    private LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }
    
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean expectedResult) {
        loginPage.login(username, password);
        
        if (expectedResult) {
            Assert.assertTrue(isUserLoggedIn());
        } else {
            Assert.assertTrue(isErrorDisplayed());
        }
    }
    
    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
            {"validUser", "validPass", true},
            {"invalidUser", "invalidPass", false}
        };
    }
}
```

### Base Test Class
```java
public abstract class BaseTest {
    
    protected WebDriver driver;
    protected String baseUrl;
    
    @BeforeMethod
    @Parameters({"browser", "baseUrl"})  
    public void setUp(String browser, String baseUrl) {
        this.baseUrl = baseUrl;
        
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    protected void takeScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + fileName + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Test Utilities and Helpers
```java
public class TestUtils {
    
    // Random data generation
    public static String generateRandomEmail() {
        return "test" + System.currentTimeMillis() + "@example.com";
    }
    
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    // Wait utilities
    public static void waitForElement(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    // File operations
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    
    public static void writeToFile(String content, String filePath) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}
```

### Configuration Management
```java
public class ConfigReader {
    
    private Properties properties;
    private static ConfigReader instance;
    
    private ConfigReader() {
        properties = new Properties();
        loadProperties();
    }
    
    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }
    
    private void loadProperties() {
        try {
            String environment = System.getProperty("env", "dev");
            String configFile = "config/" + environment + ".properties";
            
            InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(configFile);
            
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Config file not found: " + configFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public String getBaseUrl() {
        return getProperty("base.url");
    }
    
    public String getDatabaseUrl() {
        return getProperty("database.url");
    }
    
    public int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }
}
```

### Data Management with TestNG
```java
public class DatabaseTestData {
    
    private Connection connection;
    
    @BeforeClass
    public void setUpDatabase() throws SQLException {
        String url = ConfigReader.getInstance().getDatabaseUrl();
        connection = DriverManager.getConnection(url);
    }
    
    @AfterClass
    public void tearDownDatabase() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    @DataProvider(name = "userDataFromDb")
    public Object[][] getUserDataFromDatabase() throws SQLException {
        List<Object[]> data = new ArrayList<>();
        
        String query = "SELECT username, email, role FROM users WHERE active = 1";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            data.add(new Object[]{
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("role")
            });
        }
        
        return data.toArray(new Object[0][]);
    }
    
    @Test(dataProvider = "userDataFromDb")
    public void testUserLogin(String username, String email, String role) {
        // Test implementation using database data
        System.out.println("Testing user: " + username + " with role: " + role);
    }
}
```

### Custom Annotations
```java
// Custom annotation for test metadata
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {
    String author() default "";
    String[] tags() default {};
    String jiraId() default "";
    Priority priority() default Priority.MEDIUM;
    
    enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }
}

// Usage in test class
public class AnnotatedTests {
    
    @Test
    @TestInfo(
        author = "John Doe",
        tags = {"smoke", "login"},
        jiraId = "PROJ-123",
        priority = TestInfo.Priority.HIGH
    )
    public void testCriticalLogin() {
        // Critical test implementation
    }
    
    @Test
    @TestInfo(
        author = "Jane Smith",
        tags = {"regression", "api"},
        jiraId = "PROJ-456"
    )
    public void testApiEndpoint() {
        // API test implementation
    }
}
```

### Test Reporting and Screenshots
```java
public class ExtentReportManager {
    
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public static void initializeReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setReportName("Automation Test Results");
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }
    
    public static void createTest(String testName, String description) {
        ExtentTest extentTest = extent.createTest(testName, description);
        test.set(extentTest);
    }
    
    public static void logPass(String message) {
        test.get().pass(message);
    }
    
    public static void logFail(String message) {
        test.get().fail(message);
    }
    
    public static void logInfo(String message) {
        test.get().info(message);
    }
    
    public static void addScreenshot(String screenshotPath) {
        test.get().addScreenCaptureFromPath(screenshotPath);
    }
    
    public static void flushReport() {
        extent.flush();
    }
}

// Updated listener with reporting
public class ReportingTestListener implements ITestListener {
    
    @Override
    public void onStart(ISuite suite) {
        ExtentReportManager.initializeReport();
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        ExtentReportManager.createTest(testName, description);
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logPass("Test passed successfully");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportManager.logFail("Test failed: " + result.getThrowable().getMessage());
        
        // Take screenshot
        String screenshotPath = takeScreenshot(testName);
        ExtentReportManager.addScreenshot(screenshotPath);
    }
    
    @Override
    public void onFinish(ISuite suite) {
        ExtentReportManager.flushReport();
    }
    
    private String takeScreenshot(String testName) {
        // Screenshot implementation
        return "screenshots/" + testName + ".png";
    }
}
```

## Running Tests

### Maven Commands
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTests

# Run with TestNG XML
mvn test -DsuiteXmlFile=testng.xml

# Run specific groups
mvn test -Dgroups=smoke

# Run with parameters
mvn test -Dbrowser=chrome -Denvironment=staging

# Run parallel tests
mvn test -DsuiteXmlFile=parallel-suite.xml

# Generate reports
mvn surefire-report:report
```

### Gradle Commands
```bash
# Run all tests
gradle test

# Run specific test class
gradle test --tests LoginTests

# Run with system properties
gradle test -Dbrowser=chrome -Denvironment=staging

# Run tests with reports
gradle test --rerun-tasks
```

### IDE Integration
```java
// IntelliJ IDEA TestNG configuration
// Run -> Edit Configurations -> Add New -> TestNG
// - Test kind: Class/Method/Package/Group/Suite
// - Class: com.example.TestClass
// - VM options: -Dbrowser=chrome -Denvironment=dev
// - Working directory: $MODULE_WORKING_DIR$

// Eclipse TestNG configuration
// Right-click -> Run As -> TestNG Test
// Run Configurations -> TestNG -> New
// - Project: Select project
// - Class/Methods/Groups: Choose what to run
// - Parameters: Add VM arguments and program arguments
```

### Continuous Integration
```yaml
# GitHub Actions example
name: TestNG Tests

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up JDK 11
      uses: actions/setup-java@v2
      with:
        java-version: '11'
        distribution: 'adopt'
    
    - name: Cache Maven dependencies
      uses: actions/cache@v2
      with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
    
    - name: Run tests
      run: mvn clean test -Dbrowser=chrome -Denvironment=ci
    
    - name: Upload test reports
      uses: actions/upload-artifact@v2
      if: always()
      with:
        name: test-reports
        path: target/surefire-reports/
```

## Troubleshooting Common Issues

### Memory and Performance
```java
// JVM options for better performance
// -Xmx2g -XX:+UseG1GC -XX:+PrintGCDetails

public class PerformanceOptimizedTest {
    
    // Use ThreadLocal for thread safety in parallel execution
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // For CI environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        WebDriver webDriver = new ChromeDriver(options);
        driver.set(webDriver);
    }
    
    @AfterMethod
    public void tearDown() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove(); // Important: remove from ThreadLocal
        }
    }
    
    // Use explicit waits instead of Thread.sleep()
    @Test
    public void optimizedTest() {
        WebDriver webDriver = driver.get();
        webDriver.get("https://example.com");
        
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("submit"))
        );
        element.click();
    }
}
```
