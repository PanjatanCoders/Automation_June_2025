# ✅ XPath Selectors in Selenium – Complete Guide

XPath (XML Path Language) is a powerful way to locate elements based on their structure, attributes, and text content.

Use them with:

```java
driver.findElement(By.xpath("your_xpath_here"));
```

---

## 🎯 1. Basic XPath Syntax

**Absolute XPath**
```
/html/body/div[1]/div[2]/input
```
*(Not recommended—fragile.)*

**Relative XPath**
```
 //tagname[@attribute='value']
```
Example:
```
 //input[@id='username']
```

---

## 🎯 2. Selecting by Attribute

```
 //tagname[@attribute='value']
```
Example:
```
 //button[@type='submit']
```

---

## 🎯 3. Selecting by Multiple Attributes

```
 //tagname[@attr1='value1' and @attr2='value2']
```
Example:
```
 //input[@type='text' and @name='email']
```

---

## 🎯 4. Using `contains()`

**Attribute Contains**
```
 //tagname[contains(@attribute,'value')]
```
Example:
```
 //input[contains(@name,'user')]
```

**Text Contains**
```
 //tagname[contains(text(),'partial text')]
```
Example:
```
 //button[contains(text(),'Login')]
```

---

## 🎯 5. Using `starts-with()`

```
 //tagname[starts-with(@attribute,'value')]
```
Example:
```
 //input[starts-with(@id,'user')]
```

---

## 🎯 6. Using `ends-with()` (*Note:* Not in XPath 1.0)

> ⚠️ `ends-with()` is available only in XPath 2.0 (not supported by Selenium by default). Use `substring` workarounds instead.

Example workaround for "ends with":
```
 //input[substring(@id, string-length(@id) - string-length('name') +1) = 'name']
```

---

## 🎯 7. Using `text()`

**Exact Text Match**
```
 //tagname[text()='Exact Text']
```
Example:
```
 //h1[text()='Welcome']
```

---

## 🎯 8. Any Element (`*`)

```
 //*[@attribute='value']
```
Example:
```
 //*[@id='loginButton']
```

---

## 🎯 9. Selecting by Position

**First Element**
```
 (//tagname)[1]
```
Example:
```
 (//input)[1]
```

**Nth Element**
```
 (//tagname)[n]
```
Example:
```
 (//div[@class='row'])[3]
```

---

## 🎯 10. Axes in XPath

XPath axes let you navigate DOM relationships.

**Child**
```
 //div/child::input
```

**Descendant**
```
 //div/descendant::input
```

**Parent**
```
 //input/parent::div
```

**Ancestor**
```
 //input/ancestor::form
```

**Following-Sibling**
```
 //label/following-sibling::input
```

**Preceding-Sibling**
```
 //input/preceding-sibling::label
```

**Following**
```
 //h2/following::div
```

**Preceding**
```
 //div/preceding::h2
```

---

## 🎯 11. Wildcard Tag

```
 //*/input[@type='text']
```

---

## 🎯 12. Logical Operators

**OR**
```
 //input[@type='submit' or @name='submitButton']
```

**AND**
```
 //button[@type='button' and contains(text(),'Save')]
```

---

## 🎯 13. Combining Conditions

```
 //div[@class='container']//input[@name='email']
```

---

## 🎯 14. Using `normalize-space()`

Trim spaces around text:
```
 //button[normalize-space()='Submit']
```

---

## 🎯 15. Indexing within Parent

**First Child**
```
 //ul/li[1]
```

**Last Child**
```
 //ul/li[last()]
```

**Specific Index**
```
 //ul/li[3]
```

---

## 🎯 16. Selecting Elements by Partial Attribute

**Contains**
```
 //input[contains(@id,'user')]
```

**Starts With**
```
 //input[starts-with(@name,'email')]
```

---

## 📌 Usage in Selenium (Java Example)

```java
driver.findElement(By.xpath("//input[@name='username']"));
driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
driver.findElement(By.xpath("//div[@class='container']//input[@type='email']"));
driver.findElement(By.xpath("(//ul/li)[3]"));
driver.findElement(By.xpath("//label/following-sibling::input"));
```

---

✅ **Tip:** XPath is extremely powerful for complex DOM trees but can be slower than CSS selectors. Use it carefully.
