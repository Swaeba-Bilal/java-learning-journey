# 🎵 MusicShop Java Project
![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)

A Java application that simulates a musical instrument shop using core Object-Oriented Programming (OOP) principles including **abstraction**, **inheritance**, **interfaces**, and **polymorphism**.

## 📌 Project Description

This project models different musical instruments like guitars and pianos in a music shop. The system uses abstract classes and interfaces to allow for extensibility and modular design.

It demonstrates:
- Abstract classes (`Instrument`)
- Interface implementation (`Tunable`, `Maintainable`)
- Polymorphism through shared references and type checking
- Real-world behavior simulation like tuning, adjusting pitch, cleaning, and inspecting instruments

## 🧱 Class Overview

| Class/Interface   | Description |
|-------------------|-------------|
| `Instrument`      | Abstract base class for all instruments with common properties |
| `Tunable`         | Interface for instruments that can be tuned and pitch-adjusted |
| `Maintainable`    | Interface for instruments that can be cleaned and inspected |
| `StringedInstrument` | Concrete class extending `Instrument`, base for string instruments |
| `Guitar`          | Extends `StringedInstrument`, implements `Tunable` and `Maintainable` |
| `Piano`           | Extends `Instrument`, implements `Tunable` and `Maintainable` |
| `MusicShop`       | Test class that creates instrument objects and interacts with them |

## 💻 Features

- Instantiate different instruments (Guitar, Piano)
- Store them in a single array using abstract class reference
- Use `instanceof` to safely invoke interface methods
- Print detailed information using `getInstrumentDetails()`

## 🚀 How to Run

 Clone the repository:
   git clone https://github.com/swaiba-bilal/music-shop-java.git
   cd music-shop-java
🛠️ Compile the Program:
cd src
javac MusicShop.java
▶️ Run the Program:
java MusicShop
📄 License
This project is licensed under the Apache 2.0 License – feel free to use and contribute!
🙌 Author
Swaeba Bilal
