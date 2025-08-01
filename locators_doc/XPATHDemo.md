
# 🔍 XPath (XML Path) — Quick Reference Guide

XPath (XML Path Language) is used to navigate through elements and attributes in XML or HTML documents — **commonly used in Selenium, Scrapy, and other automation tools**.

---

## 📌 Basic XPath Format

```xpath
//tagName[@attributeKey='attributeValue']
```

**When to use**:  
✅ Targeting elements using specific attribute values like `id`, `class`, `type`, etc.

### Common Variants

| XPath                          | Description                                      |
|-------------------------------|--------------------------------------------------|
| `//tagName[@attr='value']`     | Selects nodes with a specific attribute/value    |
| `//*[@attr='value']`           | Selects any tag with that attribute/value        |
| `./tagName[@attr='value']`     | Relative to current node — used in nested paths |
| `//tagName[text()='text']`     | Selects elements with specific inner text        |

---

## 🛣️ Types of XPath

### 1. **Absolute XPath**
```xpath
/html/body/main/section/div/div[1]/input
```
**When to use**:
- Only in **static pages** where structure doesn’t change.  
  ⚠️ Avoid in dynamic UIs — it's fragile.

### 2. **Relative XPath**
```xpath
//input[@id='input-sendkeys']
```
**When to use**:
- **Best practice** — more reliable in dynamic layouts.
- Easier to maintain and read.

---

## 🎯 XPath Wildcards

| Wildcard      | Use Case                                               | Example                                          |
|---------------|--------------------------------------------------------|--------------------------------------------------|
| `*`           | Match any tag                                           | `//div/*` — all child elements of a div         |
| `@*`          | Match any attribute                                     | `//input[@*='value']` — any attr with this value|

---

## ✍️ Multiple Attribute Matching

```xpath
//input[@id='toggle-input'][@placeholder='I can be disabled!']
```

Or using logical operators:

```xpath
//input[@id='toggle-input' and @placeholder='I can be disabled!']
```

**When to use**:
- Target the element more **precisely** when multiple attributes are present.

---

## 🔠 Element Text Matching

```xpath
//h3[text()='Enable / Disable Elements']
//h3[.='Enable / Disable Elements']   ← Alternate form
```

**When to use**:
- When text is visible in the DOM and unique.

---

## 🔍 Dynamic XPath Functions

### 1. **starts-with()**
```xpath
//input[starts-with(@placeholder, 'I can be')]
```

**When to use**:
- For dynamic attributes (IDs, placeholders, etc.)

### 2. **contains()**
```xpath
//input[contains(@class, 'input-box')]  
//h3[contains(text(), 'Enable')]
```

**When to use**:
- Partial matches in text or attribute values.

### 3. **ends-with()** (⚠️ Not supported in XPath 1.0)
```xpath
//input[ends-with(@id, '-input')]
```

**When to use**:
- Only in XPath 2.0+ (some tools don’t support it).
- For suffix-matching in attributes.

---

## 🧬 XPath Relationships (Axes)

### 🔝 Parent
```xpath
//input[@id='input-sendkeys']/parent::div
//input[@id='input-sendkeys']/..
```

### 👶 Child
```xpath
//div[@class='flex gap-2 mb-2']/child::button
//div[@class='flex gap-2 mb-2']/button
```

### 🤝 Sibling

#### Following Sibling
```xpath
//td[.='CONT001']/following-sibling::td[3]
```

#### Preceding Sibling
```xpath
//td[.='In Transit']/preceding-sibling::td[3]
```

---

## 🔢 Positional XPaths

```xpath
//td[.='CONT001']/following-sibling::td[last()]        # Last column of the row
//td[.='CONT001']/following-sibling::td[last()-2]      # 3rd last column of the row
//table/tbody/tr[last()]                               # Last row of a table
(//tr)[1]                                              # First <tr> in document
```

---

## 📚 Ancestor & Descendant

```xpath
//table/tbody/tr[1]/ancestor::tbody                     # Gets ancestor <tbody>
//table/tbody/tr[1]/ancestor::section                   # Parent, grandparent, etc.
//section[@class='card']/descendant::div[2]             # Child, grandchild, etc.
```

---

## ➡️ Following (below in DOM)

```xpath
//h4[.='E-commerce Product Search']/following::h4[1]
//h4[.='E-commerce Product Search']/following::h4[.='API Endpoint Testing']
```

## ⬅️ Preceding (above in DOM)

```xpath
//h4[.='E-commerce Product Search']/preceding::h4[1]
```

---

## 🧭 XPath Axes Summary

| Axis               | Use Case                                            |
|--------------------|-----------------------------------------------------|
| `/`                | Direct child                                        |
| `//`               | Descendant (any level)                              |
| `parent::`         | Move up one level                                   |
| `child::`          | Move one level down                                 |
| `following-sibling::` | Target next sibling elements                      |
| `preceding-sibling::` | Target previous sibling elements                  |
| `ancestor::`       | Access any ancestor in the hierarchy                |
| `descendant::`     | Access any descendant node                          |
| `following::`      | Access any node that appears after in the DOM       |
| `preceding::`      | Access any node that appears before in the DOM      |

---

## ✅ Quick XPath Tips

- Prefer **Relative XPath** over Absolute.
- Use `contains()` or `starts-with()` to handle dynamic values.
- Validate your XPath in **DevTools** (`Ctrl+F` in Elements tab).

---