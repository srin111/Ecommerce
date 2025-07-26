E-Commerce Checkout Automation Framework

This project is a robust Selenium-based automation framework for testing the checkout workflow of an e-commerce application. It follows best practices in test architecture, including Page Object Model (POM), TestNG integration, and JSON-based data-driven testing.

---

 Features

-  **Page Object Model (POM)**: Clean separation of page actions using reusable classes (`HomePage`, `CartPage`, `CheckOutPage`)
-  **TestNG Framework**: Organized test execution with assertions and test lifecycle annotations
-  **Data-Driven Testing**: Reads test data from external `.json` files using GSON and converts it into `List<HashMap<String, String>>`
- **UUID Generation**: Automatically generates unique card numbers at runtime using Java `UUID` and replaces placeholders in test data
- **Reusable Wait Utility**: Centralized explicit wait logic using `WaitUtils` for handling dynamic web elements
   **Auto-Suggest Handling**: Verifies country selection from dynamic dropdowns using input filtering and visible suggestions
   **Validations**: Includes success/failure checks after order placement, invalid input handling, and product validations

---

 Tech Stack

| Tool/Library | Purpose |
|--------------|---------|
| Java         | Programming language |
| Selenium WebDriver | UI automation |
| TestNG       | Test framework |
| GSON         | JSON parsing and conversion |
| Maven        | Dependency and build management |
| UUID         | Runtime placeholder replacement for dynamic test data |

---

 🗂️ Project Structure
 Ecommerce/
├── src/
│ ├── main/java/
│ │ ├── pages/ # Page Object classes (HomePage, CartPage, CheckOutPage)
│ │ └── utils/ # Utility classes (WaitUtils, DataUtilities)
│ ├── test/java/
│ │ ├── base/ # Base test setup and DataProvider class
│ │ └── tests/ # Test classes (CheckOutPageTest)
├── test-data/
│ └── testdata.json # JSON test data with placeholders
├── pom.xml # Maven project file
└── README.md # Project documentation


---

 How to Run the Tests

1. Clone the repository  
   ```bash
   git clone https://github.com/srin111/Ecommerce.git

   Import the project into Eclipse or IntelliJ as a Maven project

    Navigate to CheckOutPageTest.java inside the test package

    Run the test class or individual test methods


Sample JSON Data
  {
    "number": "UUID-CARD-NUMBER",
    "expiry": "12/28",
    "cvv": "123",
    "name": "John Doe",
    "country": "India",
    "email": "john.doe@example.com"
  }
]


 Runtime Placeholder Replacement

 Card numbers require unique values in some environments. This project replaces "UUID-CARD-NUMBER" with a unique 16-digit numeric UUID string using:

UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);



Author
Swathin
GitHub: srin111







