# XPath (XML Path)

## FORMAT

- `//tagName[@attributeKey='attributeValue']` <br>
  _Best practice format_
- `//*[@attributeKey='attributeValue']`
- `./tagName[@attributeKey='attributeValue']`
- `./*[@attributeKey='attributeValue']`
- `//tagName[text() = 'element text']`

---

### Types of XPATH

#### 1. Absolute XPATH
_Complete path from the root to target_

- `/html/body/main/section/div/div[1]/input`

#### 2. Relative XPATH
_Relative path to the target_

- `//input[@id='input-sendkeys']`

#### Wildcards

- `*` : any match  
- `@*` : any attribute in the element (Ex: `//select[@*='dropdown-example']`)

#### Multiple Attributes
- `//input[@id='toggle-input'][@placeholder='I can be disabled!']`
- `//input[@id='toggle-input' and @placeholder='I can be disabled!']` (using `and`)
- `//input[@id='toggle-input' or @placeholder='I can be disabled!']` (using `or`)

#### By Element Text
- `//h3[text() = 'Enable / Disable Elements']`
- `//h3[. = 'Enable / Disable Elements']` _(Alternate of text())_

---

### Different Methods of Creating XPATH

#### **starts-with()**
- `//h3[starts-with(. , 'Enable / Dis')]`
- _similar to:_<br>
  `//h3[starts-with(text() , 'Enable / Dis')]`
- Attribute-specific:  
  `//input[starts-with(@placeholder, "I can be di")]`

#### **contains()**
- `//input[contains(@placeholder, "I can be di")]`
- `//h3[contains(. , 'ble / Dis')]`

#### **ends-with()**
- `//input[ends-with(@id, '-sendkeys')]`

---

## Relationship in XPath

- **Parent, Child, Sibling (following, preceding), Ancestor, Descendant**

### Parent
- `//input[@id = 'input-sendkeys']/parent::div`
- `//input[@id = 'input-sendkeys']/..` _(alternate)_

### Child
- `//div[@class= 'flex gap-2 mb-2']/child::button`
- `//div[@class= 'flex gap-2 mb-2']/button` _(alternate)_
- `//div[@class= 'flex gap-2 mb-2']/child::button[.='Show Confirm']`

---

---
### XPath Axes for Navigation

* `/` : Selects direct child nodes.
* `//` : Selects descendant nodes at any level.

---

### Sibling Axes

* **`following-sibling`**: Selects all following siblings of the context node.
  * Example: `//td[.='CONT001']/following-sibling::td[3]` (Selects the 3rd `<td>` element that is a following sibling of the `<td>` containing 'CONT001').
* **`preceding-sibling`**: Selects all preceding siblings of the context node.
  * Example: `//td[.='In Transit']/preceding-sibling::td[3]` (Selects the 3rd `<td>` element that is a preceding sibling of the `<td>` containing 'In Transit').