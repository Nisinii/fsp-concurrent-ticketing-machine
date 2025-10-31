# FSP Concurrent Ticketing System in Java

This project is a thread-safe ticketing system simulator built with Java. It models a real-world scenario where multiple actors (technicians and users) attempt to access a shared resource (a ticketing machine) concurrently.

The system's logic was first modelled using **FSP (Finite State Processes)** to define and analyze the concurrent behaviors, ensuring a correct-by-design approach before implementation. The final application uses Java's concurrency utilities to manage shared resources and prevent race conditions, with a functional GUI built using Java Swing.

## ✨ Core Concepts & Features

This simulation models three main concurrent actors:

* **Paper Technician:** A thread that can refill the machine's paper supply.
* **Toner Technician:** A thread that can refill the machine's toner supply.
* **User (Student):** A thread that attempts to print a ticket, which requires both paper and toner.

The primary challenge is to ensure that these operations can happen concurrently without causing inconsistencies (e.g., printing with no paper, refilling while printing).

### Concurrency Management

To ensure thread safety and system consistency, the following Java concurrency mechanisms were implemented:

* **Synchronization:** Used to protect critical sections of code where shared resources (like toner and paper levels) are modified.
* **ReentrantLocks:** Implemented to provide more flexible and fine-grained locking control than standard synchronization, helping to prevent deadlocks.
* **Semaphores:** Used to manage access to the limited resources (paper and toner), ensuring a user cannot print unless all required resources are available.

### Design

* **Object-Oriented Programming (OOP):** The system is built using strong OOP principles, encapsulating the printer's state and behavior.
* **Design Patterns:** Utilized appropriate design patterns to structure the code for maintainability and scalability.
* **GUI:** The graphical user interface was built using **Java Swing** to provide a visual representation of the machine's state and the actions of each thread.

## ✨ LTS Models
<img width="1085" height="622" alt="Paper_Technician LTS Model" src="https://github.com/user-attachments/assets/2c012414-e804-4399-96ed-3b151e611ff5" />
<img width="1068" height="632" alt="Toner_Technician LTS Model" src="https://github.com/user-attachments/assets/d8aa246f-e176-4892-b41a-a144b708c827" />
<img width="1102" height="578" alt="Passenger LTS Model" src="https://github.com/user-attachments/assets/a576db71-d4de-4262-8d67-a1f1ad6708a2" />
<img width="1797" height="925" alt="Ticketing_Machine LTS Model" src="https://github.com/user-attachments/assets/1951b61a-67c3-47d7-a5b9-166b481aec2e" />

## 🛠️ Tech Stack & Skills

* **Core Language:** Java
* **Concurrency:** Java Concurrency Utilities (ReentrantLock, Semaphore, `synchronized` keyword)
* **Modelling:** FSP (Finite State Processes)
* **GUI:** Java Swing
* **Core Concepts:** Object-Oriented Programming (OOP), Design Patterns, Thread Safety, Resource Management
