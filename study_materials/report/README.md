# Allure Report Configuration for Java + TestNG + Selenium

## Prerequisites
- Maven project
- Java 8+
- TestNG
- Selenium WebDriver

---

## Step 1: Add Dependencies to pom.xml

```xml
<properties>
    <aspectj.version>1.9.20</aspectj.version>
    <allure.version>2.24.0</allure.version>
</properties>

<dependencies>
    <!-- Allure TestNG -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>${allure.version}</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
                <argLine>
                    -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                </argLine>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.aspectj</groupId>
                    <artifactId>aspectjweaver</artifactId>
                    <version>${aspectj.version}</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```

---

## Step 2: Create TestNG Configuration File

**File:** `src/test/resources/testng.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Test Suite">
    <listeners>
        <listener class-name="io.qameta.allure.testng.AllureTestNg"/>
    </listeners>
    <test name="Sample Test">
        <classes>
            <class name="com.yourpackage.YourTestClass"/>
        </classes>
    </test>
</suite>
```

---

## Step 3: Sample Test Class with Allure Annotations

**File:** `src/test/java/com/yourpackage/LoginTest.java`

```java
package com.yourpackage;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Web Application Tests")
@Feature("Login Feature")
public class LoginTest {
    
    WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }
    
    @Test
    @Description("Verify successful login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User Authentication")
    public void testValidLogin() {
        step("Navigate to login page");
        driver.get("https://example.com/login");
        
        step("Enter credentials and submit");
        // Your login code here
        
        step("Verify successful login");
        Assert.assertTrue(true); // Replace with actual assertion
    }
    
    @Test
    @Description("Verify login fails with invalid credentials")
    @Severity(SeverityLevel.NORMAL)
    @Story("User Authentication")
    public void testInvalidLogin() {
        step("Navigate to login page");
        driver.get("https://example.com/login");
        
        step("Enter invalid credentials");
        // Your invalid login code here
        
        step("Verify error message is displayed");
        Assert.assertTrue(true); // Replace with actual assertion
    }
    
    @Step("{stepDescription}")
    public void step(String stepDescription) {
        // Step will be logged automatically in Allure report
    }
    
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

---

## Step 4: Advanced Features - Screenshots on Failure

```java
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureHelper {
    
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
```

**Update Test Class with Screenshot on Failure:**

```java
@AfterMethod
public void teardown(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
        AllureHelper.takeScreenshot(driver);
    }
    if (driver != null) {
        driver.quit();
    }
}
```

---

## Step 5: Install Allure Command Line

### Windows (using Scoop)
```bash
scoop install allure
```

### macOS (using Homebrew)
```bash
brew install allure
```

### Linux (Manual Installation)
```bash
wget https://github.com/allure-framework/allure2/releases/download/2.24.0/allure-2.24.0.tgz
tar -zxvf allure-2.24.0.tgz
sudo mv allure-2.24.0 /opt/allure
export PATH=$PATH:/opt/allure/bin
```

### Verify Installation
```bash
allure --version
```

---

## Step 6: Run Tests and Generate Report

### Option 1: Generate and Serve Report (Automatically Opens Browser)
```bash
mvn clean test
allure serve target/allure-results
```

### Option 2: Generate Report to Specific Directory
```bash
mvn clean test
allure generate target/allure-results --clean -o allure-report
allure open allure-report
```

### Option 3: Using Maven Plugin (Optional)
Add to `pom.xml`:

```xml
<plugin>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-maven</artifactId>
    <version>2.12.0</version>
    <configuration>
        <reportVersion>${allure.version}</reportVersion>
    </configuration>
</plugin>
```

Then run:
```bash
mvn clean test allure:serve
```

---

## Key Allure Annotations Reference

| Annotation | Purpose | Example |
|------------|---------|---------|
| `@Epic` | Highest level grouping | `@Epic("E-Commerce")` |
| `@Feature` | Feature under test | `@Feature("Shopping Cart")` |
| `@Story` | User story | `@Story("Add item to cart")` |
| `@Step` | Test step description | `@Step("Click add to cart button")` |
| `@Description` | Test description | `@Description("Verify cart updates")` |
| `@Severity` | Test priority | `@Severity(SeverityLevel.CRITICAL)` |
| `@Attachment` | Attach files/screenshots | `@Attachment(value = "Page screenshot")` |
| `@Issue` | Link to issue tracker | `@Issue("JIRA-123")` |
| `@TmsLink` | Link to test management | `@TmsLink("TMS-456")` |
| `@Link` | Custom link | `@Link(name = "Requirements", url = "...")` |

### Severity Levels
- `BLOCKER`
- `CRITICAL`
- `NORMAL`
- `MINOR`
- `TRIVIAL`

---

## Project Structure

```
project-root/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── yourpackage/
│       │           ├── LoginTest.java
│       │           └── AllureHelper.java
│       └── resources/
│           └── testng.xml
├── target/
│   └── allure-results/
├── allure-report/
└── pom.xml
```

---

## Troubleshooting

### Issue: Tests run but no report generated
**Solution:** Ensure AspectJ weaver is configured in maven-surefire-plugin

### Issue: "allure: command not found"
**Solution:** Install Allure CLI or add to PATH

### Issue: Empty report
**Solution:** Check that `io.qameta.allure.testng.AllureTestNg` listener is added in testng.xml

### Issue: Screenshots not appearing
**Solution:** Ensure method has `@Attachment` annotation and returns byte[]

---

## Additional Resources

- [Allure Official Documentation](https://docs.qameta.io/allure/)
- [Allure TestNG Integration](https://docs.qameta.io/allure/#_testng)
- [GitHub Repository](https://github.com/allure-framework/allure2)

---

## Summary

1. Add Allure dependencies and AspectJ to `pom.xml`
2. Configure TestNG listener in `testng.xml`
3. Use Allure annotations in test classes
4. Run tests with `mvn clean test`
5. Generate report with `allure serve target/allure-results`

Your Allure report will show:
- Test execution timeline
- Test case details with steps
- Screenshots and attachments
- Graphs and statistics
- Trends over time
- Categorized failures