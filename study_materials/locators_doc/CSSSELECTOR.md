# ✅ CSS Selectors in Selenium – Complete Guide

CSS Selectors are powerful and flexible ways to locate elements in Selenium. Use them with:

```java
driver.findElement(By.cssSelector("your_selector_here"));
```

---

## 🎯 1. Basic Selectors

**By Tag Name**
```css
input
```

**By ID**
```css
#elementId
```

**By Class**
```css
.className
```

**By Attribute**
```css
tagName[attribute='value']
```
Example:
```css
input[name='username']
```

---

## 🎯 2. Multiple Attributes

```css
tagName[attr1='value1'][attr2='value2']
```
Example:
```css
input[type='text'][name='username']
```

---

## 🎯 3. Class and ID Combinations

```css
tagName#id.class
```
Example:
```css
button#submit.primary
```

---

## 🎯 4. Multiple Classes

```css
div.class1.class2
```
Example:
```css
div.box.shadow
```

---

## 🎯 5. Substring Matching Selectors

**Starts with (`^=`)**
```css
input[name^='user']
```

**Ends with (`$=`)**
```css
input[name$='name']
```

**Contains (`*=`)**
```css
input[name*='ser']
```

---

## 🎯 6. Parent-Child Relationship

**Direct Child (`>`)**
```css
div > input
```

**All Descendants (space)**
```css
div input
```

---

## 🎯 7. Sibling Selectors

**Adjacent Sibling**
```css
label + input
```

**General Sibling**
```css
label ~ input
```

---

## 🎯 8. Nth Child / Nth-of-Type

**Nth Child**
```css
ul > li:nth-child(3)
```

**Nth of Type**
```css
div p:nth-of-type(2)
```

---

## 🎯 9. First / Last / Only Child

```css
ul > li:first-child
ul > li:last-child
div p:only-child
```

---

## 🎯 10. Attribute Presence

```css
input[required]
```

---

## 🎯 11. Universal Selector

```css
*
```

---

## 🎯 12. Combining Selectors

```css
div#container input[name='email'].form-input
```

---

## 🎯 13. Not Selector

```css
input:not([type='submit'])
```

---

## 🎯 14. Empty Selector

```css
div:empty
```

---

## 🎯 15. Checked Selector

```css
input:checked
```

---

## 📌 Usage in Selenium (Java Example)

```java
driver.findElement(By.cssSelector("input[name='username']"));
driver.findElement(By.cssSelector("#loginButton"));
driver.findElement(By.cssSelector("div.container > ul li:nth-child(2)"));
driver.findElement(By.cssSelector("input:not([disabled])"));
driver.findElement(By.cssSelector("input[name^='user']"));
```

---

✅ **Tip:** CSS Selectors are generally faster and more readable than XPath. Use them when possible.
