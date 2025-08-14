

# 🧪 Selenium Amazon.in Automation Project

This project is a Selenium-based automation suite developed for functional testing of the [Amazon India website](https://www.amazon.in/). It demonstrates the use of modern test automation best practices, including cross-browser testing, logging, test reporting, and screenshot capture for failed scenarios.

---

# 📌 Project Overview

- **Application Under Test (AUT):** [Amazon India](https://www.amazon.in/)

- **Test Framework:** Selenium WebDriver with TestNG

- **Browsers Supported:** Chrome, Firefox, Microsoft Edge

- **Build Tool:** Maven

- **Logging:** Log4j2 (with JSON layout)

- **Reporting:** ExtentReports (screenshots on failure included)

---

# How to Run the Project



### 1. ✅ Prerequisites



- Java JDK 11 or higher

- Maven installed and configured in `PATH`

- Chrome, Firefox, and Edge browsers installed

- Browser drivers set up properly (or auto-managed using Selenium 4)



### 2. 📦 Clone the Repository

```bash

git clone https://git-training.nagarro.com/nagarro\_fresher\_training/automation-manual-qa/vuisile-tlotliso-lehola.git

cd vuisile-tlotliso-lehola/SeleniumAssignment

```

### 3. 🏃  Run the Tests

Tests can be run directly via Eclipse/IntelliJ:

- Right-click on testng.xml

- Choose Run As → TestNG Suite

Or run via Maven:

```bash

mvn clean test -DsuiteXmlFile=testng.xml

```

---

# 📈 Reports and Results

- After running, results are stored in the target/ directory:

    - **TestNG Report**: test-output/

    - **Extent Report**: target/extent-reports/

    - **Screenshots**: captured automatically on test failures and added to extent reports 

---

# 📋 Test Case Documentation

Test cases are documented in a Google sheet:

👉 [Test Case Excel Document (Google Drive)](https://docs.google.com/spreadsheets/d/15Q9tXp6HJyReYZnw\_90ARg6Q2pukqsgqG1msHvNjZBs/edit?usp=sharing)

---

# ⚠️ Caveats & Notes

- Ensure all required browser drivers are accessible in your PATH or handled automatically.

- Avoid running tests on slow or unstable networks — Amazon pages may load differently and cause flaky tests.

- If a sticky header blocks elements from being clicked, scroll offset logic is implemented, but might need fine-tuning on smaller screens.

- TestNG parallel execution may cause test failures if your system is resource-constrained.



