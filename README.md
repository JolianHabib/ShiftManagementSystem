# Shift Management System

A console-based system for managing employees, shifts, and attendance in a small–medium organization.  
The project was built as part of a software engineering course and focuses on clean object-oriented design, role-based logic, and correct use of Java collections and design patterns.

---

## 1. Overview

The system supports three roles:

- **Employee**
- **Shift Manager**
- **Administrator**

Each user logs in with a username and password and then sees a menu of actions that match their role.  
The goal is to model a realistic shift scheduling system that is still simple enough to understand and extend.

---

## 2. Main Features

### Employee

- Clock-in to an active shift (only if assigned to it)
- Clock-out from a shift (only after a valid clock-in)
- View personal schedule:
  - by day  
  - by week  
  - by month  

### Shift Manager

Includes all employee features, plus:

- Assign employees to specific shifts
- Search and update shifts
- View the schedule of a single employee
- View the schedules of all employees
- Search and update employee details
- List all employees

### Administrator

Includes all shift-manager features, plus:

- Add new employees
- Remove employees
- Add new shifts
- Remove shifts
- Full control over the shift and employee data

---

## 3. Design and Architecture

The project is written in Java using standard OOP principles.  
Several classic design patterns are used to keep the code organized and easier to maintain.

### Design Patterns

- **Singleton**  
  `ShiftManagementSystem` is implemented as a singleton so that all parts of the program work with the same central data structure.

- **Observer**  
  Observers are used to notify:
  - employees when shifts they are assigned to are updated or removed  
  - administrators and shift managers when changes are made to shifts  

- **Command**  
  Clock-in and clock-out operations are implemented as command classes.  
  Each command encapsulates validation rules such as:
  - the employee must be assigned to the shift  
  - an employee cannot enter the same shift twice  
  - an employee cannot exit a shift before entering it  

- **Memento**  
  A memento is used to capture and restore the system state when users log in and out, so that invalid operations do not leave the system in an inconsistent state.

### Collections

- **List** – used for:
  - storing shifts
  - storing employees assigned to a specific shift
  - printing schedules (daily / weekly / monthly)

- **Set** – used for:
  - storing all employees without duplicates
  - storing unique usernames

- **Map** – used for:
  - mapping employees to their check-in/out records
  - mapping usernames to passwords

---

## 4. Tech Stack

- **Language:** Java (tested with JDK 17)
- **Paradigm:** Object-Oriented Programming
- **Patterns:** Singleton, Observer, Command, Memento
- **Collections:** List, Set, Map
- **Environment:** Eclipse / any Java 17-compatible IDE

---

## 5. How to Run

### Option A – Using an IDE (Eclipse)

1. Create a new Java project in Eclipse named `ShiftManagementSystem`.
2. Copy the contents of the `src` folder from this repository into the project's `src` folder.
3. Make sure the project is configured to use **JDK 17**.
4. Run the program from `Main1.java`:
   - Right-click `Main1.java` → `Run As` → `Java Application`.

### Option B – Using the command line

From the project root:

```bash
javac -d bin src/*.java
java -cp bin Main1
