# Transparency International Bangladesh (TIB) Simulation Software

> **Course:** Object Oriented Programming (OOP)
> **Project Type:** JavaFX Desktop Application

## Project Overview
The **TIB Simulation Software** is a comprehensive desktop application designed to digitize and simulate the real-world operations of **Transparency International Bangladesh (TIB)**.

This solution streamlines organizational tasks such as corruption reporting, data analysis, event scheduling, and employee management. It serves as both an operational tool for TIB staff and an educational platform for the general public to engage with transparency initiatives.

**Key Goals:**
* Promote accountability through digital corruption reporting.
* Enhance operational efficiency via role-based dashboards.
* Provide data visualization and analytics for decision-making.
* Demonstrate core **Object-Oriented Programming (OOP)** principles in a real-world scenario.

---

## Technical Stack
* **Language:** Java (JDK 8+)
* **GUI Framework:** JavaFX (FXML)
* **Design Pattern:** Model-View-Controller (MVC)
* **Data Persistence:** Binary File I/O (Serialization) - *No database required*
* **Third-Party Libraries:**
    * `iText` (for PDF Report Generation)
    * `Barcodes` (for QR/Barcode generation)

---

## Key Features by Role
The system features a secure login system that routes users to one of **8 specific dashboards** based on their role:

| User Role | Key Responsibilities & Features |
| :--- | :--- |
| ** Administrator** | Manage employees, view infractions, approve admin requests, verify memberships, and visualize employee data (Pie Charts). |
| ** Media Officer** | Make internal announcements, schedule press conferences, manage press releases, and send communications. |
| ** Secretary** | Schedule meetings, restock equipment, manage internal requests, and handle resignations. |
| ** Data Officer** | Generate annual reports, calculate taxes/liquidity, update Corruption Perception Index (CPI), and analyze outliers. |
| ** Journalist** | Report news, view press conferences, write articles, and receive official communications from TIB. |
| ** Researcher** | Propose research topics, apply for funding, publish papers, and collaborate on research networks. |
| ** Recordkeeper** | Maintain archives, add infractions, manage passwords, verify documents, and update company policies. |
| ** General Public** | Report corruption incidents, apply for membership/jobs, donate to TIB, and access educational resources. |

---

## OOP Principles Implemented
This project was built to demonstrate proficiency in Object-Oriented Programming:

1.  **Encapsulation:**
    * All data fields in User/Employee classes are private and accessed via public Getters/Setters.
    * Sensitive data (like passwords) is wrapped within objects before storage.

2.  **Inheritance:**
    * A base `User` class is extended by specific roles (e.g., `public class Admin extends Employee`).
    * Shared attributes (ID, Name, DOJ) are managed in the parent classes to reduce code redundancy.

3.  **Polymorphism:**
    * Method Overriding is used in controllers to handle `initialize()` methods differently for each scene.
    * Users are treated as generic objects during login and cast to specific roles dynamically.

4.  **Abstraction:**
    * Complex file handling logic is abstracted away into helper methods (e.g., `AppendableObjectOutputStream` for appending data to binary files).

---

## Installation & Setup

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher (compatible with JavaFX).
* **IDE:** NetBeans, IntelliJ IDEA, or Eclipse.

### Steps to Run
1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/YourUsername/YourRepoName.git](https://github.com/YourUsername/YourRepoName.git)
    ```
2.  **Open in IDE:**
    * Launch your IDE and go to **File > Open Project**.
    * Select the cloned folder.
3.  **Configure Libraries:**
    * Navigate to the project properties/libraries.
    * Ensure the `dist/lib` folder jars (iText, Barcodes) are added to the **Classpath**.
4.  **Run the Application:**
    * Locate `MainClass.java` in `src/mainpkg`.
    * Right-click and select **Run File**.

---

## Usage
1.  **Login:** Upon launching, use the credentials provided in the project documentation (or sign up as a "General Public" user via the GUI).
2.  **Dashboard:** Navigate through the sidebar menu to access your role-specific tasks.
3.  **Data Persistence:** All data (users, reports, meetings) is saved automatically to `.bin` files in the project root directory. **Do not delete these files** if you wish to keep your saved data.

---

## Project Structure
```bash
src/
├── images/             # UI Assets (Logos, backgrounds)
├── mainpkg/            # Source Code
│   ├── MainClass.java  # Entry point
│   ├── User.java       # Base user logic
│   ├── Admin.java      # Admin logic
│   ├── *.fxml          # UI Layout files
│   └── *Controller.java # Logic for UI
└── ...
