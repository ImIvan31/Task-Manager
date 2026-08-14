# Task Manager

A simple **console-based Task Manager** built with Java. This project allows users to create, view, edit, complete, delete, and search for tasks.

## Features

* Add new tasks
* View all tasks
* Mark tasks as completed
* Edit existing tasks
* Delete tasks
* Search for tasks
* Automatically record the task date
* Simple command-line menu
* Input validation for menu options

## Technologies Used

* Java
* ArrayList
* LocalDate
* Scanner
* Object-Oriented Programming

## How It Works

Each task contains:

* **Title**
* **Description**
* **Status**
* **Date**

The `Task` class stores these properties and provides getter and setter methods.

The `TaskManager` class manages the tasks using an `ArrayList<Task>`.

## Menu Options

```text
Add       - Create a new task
View      - Show all tasks
Complete  - Mark a task as completed
Delete    - Remove a task
Edit      - Modify task details
Search    - Search for a task
Exit      - Exit the program
```

## How to Run

1. Clone the repository:

```bash
git clone repository URL
```

2. Open the project in your Java IDE or terminal.

3. Compile the files:

```bash
javac Task.java TaskManager.java
```

4. Run the program:

```bash
java TaskManager
```

## Example

```text
Welcome this program help you manage your task

Task Manager

Menu (Choose valid options):

Add - To create task
View - Show all tasks
Complete - Mark task as done
Delete - Remove a task
Edit - Modify task details
Search - Search Task
Exit - Exit the program
```

## What I Learned

Through this project, I practiced:

* Java classes and objects
* Encapsulation using getters and setters
* ArrayList
* Methods
* For-each and index-based loops
* Conditional statements
* `Scanner` for user input
* `LocalDate`
* Input validation
* Searching, editing, and deleting objects from an ArrayList
* Building a menu-driven console application

## Future Improvements

Possible improvements for future versions:

* Add task priorities
* Add due dates
* Save tasks to a file
* Load tasks when the program starts
* Add sorting by date or priority
* Add a database using SQL
* Create a graphical or web interface

## Status

Completed — Beginner Java Console Project
