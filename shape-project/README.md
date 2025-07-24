# Java Shape Project

This project demonstrates core **Object-Oriented Programming (OOP)** concepts in Java through the creation of different geometric shapes. The design uses abstraction and inheritance to define a base `Shape` class and several subclasses like `Rectangle`, `Square`, `Circle`, `Cylinder`, and `Sphere`, each of which calculates its surface area.

---

## 📁 Project Structure
New Folder/
└── com/
├── company/
│ └── Main8.java
└── codewithswaeba/
└── shape/
├── Shape.java
├── Rectangle.java
├── Square.java
├── Circle.java
├── Cylinder.java
└── Sphere.java

---

## 🔧 How It Works

- The **abstract class `Shape`** defines a method `getSurfaceArea()`, which is overridden by each concrete subclass to provide shape-specific surface area calculations.
- The `Main8` class creates instances of each shape and prints their surface areas.

---

## 🧠 OOP Concepts Demonstrated

| Concept       | Description |
|---------------|-------------|
| **Abstraction** | `Shape` is an abstract class that defines a general behavior for all shapes. |
| **Inheritance** | All shape classes (`Rectangle`, `Circle`, `Square`, `Cylinder`, `Sphere`) inherit from `Shape`. |
| **Polymorphism** | The method `getSurfaceArea()` is overridden in each subclass to provide specific behavior. |
| **Encapsulation** | Shape attributes like `radius`, `length`, etc., are declared `private` and accessed via methods. |

---

## 💻 Sample Output

Initial Values:
Rectangle Surface Area: 40.0
Square Surface Area: 25.0
Circle Surface Area: 153.93804002589985
Cylinder Surface Area: 565.4866776461628
Sphere Surface Area: 314.1592653589793

---

## 🚀 How to Compile and Run

### 📌 Prerequisite:
Java must be installed and added to your system PATH.

### 🛠️ Compile:
Open Git Bash or terminal and navigate to your project directory:

cd "C:/Users/YourName/Desktop/New Folder"
javac com/codewithswaeba/shape/*.java com/company/Main8.java
▶️ Run:
java com.company.Main8
👩‍💻 Author
Swaeba Bilal
2+ years of experience in Java, OOP, and academic programming.
