# ✅ Task Manager CLI (Java)

**Task Manager CLI** is a robust, lightweight command-line application built with **Java**. It allows users to efficiently manage their daily tasks with persistent file storage, ensuring data remains safe even after the program exits.

## 📂 Repository Content

This project consists of a single-file Java application designed for simplicity and portability:

* **`TaskManager.java`:** The core source code containing:
    * **Task Model:** Defines task properties (ID, title, description, status, timestamp).
    * **File Persistence:** Methods (`load`, `save`) to read/write tasks to a local `tasks.txt` file.
    * **CLI Interface:** A menu-driven loop for user interaction.

---

## ✨ Key Features

* **📝 CRUD Operations:** Easily **Add** new tasks, **List** existing ones, and **Remove** unwanted entries.
* **✅ Status Tracking:** Mark tasks as **DONE** or **TODO** to keep track of progress.
* **💾 Persistent Storage:** Automatically saves all data to `tasks.txt` so your list is restored next time you run the app.
* **🆔 Unique IDs:** Uses `UUID` to ensure every task has a unique identifier for safe deletion and updates.
* **🕒 Timestamps:** Records the exact creation date and time for every task.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher installed.

### Installation & Execution

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/pushtikadia/Task_Manager.git](https://github.com/pushtikadia/Task_Manager.git)
    ```
2.  **Navigate to the directory:**
    ```bash
    cd Task_Manager
    ```
3.  **Compile the code:**
    ```bash
    javac TaskManager.java
    ```
4.  **Run the application:**
    ```bash
    java TaskManager
    ```

---

## 🛠️ Technologies Used

* **Language:** Java (JDK 8+)
* **Libraries:** `java.util` (Collections, UUID), `java.io` (File Handling), `java.time` (LocalDateTime)

---

<p align="center">
  <b>Task Manager CLI</b> • Created by <a href="https://github.com/pushtikadia"><b>Pushti Kadia</b></a>
</p>
