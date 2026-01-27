# LibraryJava

Simple Library System - MVC Learning Project
📚 Project Overview

A beginner-friendly Java console application that demonstrates the Model-View-Controller (MVC) architecture pattern. This simple library system helps you understand how to separate concerns in software development.
🎯 Learning Objectives

    Understand the MVC architectural pattern

    Learn separation of concerns in software design

    Practice object-oriented programming principles

    Implement a complete Java application from scratch

📖 What the Application Does

The library system allows users to:

    Add new books to the library catalog

    View all books with their current status

    Borrow available books

    Return borrowed books

Each book has:

    Title

    Author

    Unique ID

    Status (Available/Borrowed)

🏗️ MVC Architecture Explained
1. MODEL (Book.java) - The Data Layer

Purpose: Represents the application's data and business logic.

Responsibilities:

    Defines what a "Book" is (title, author, ID, status)

    Contains the actual data storage

    Enforces data rules (e.g., "a borrowed book can't be borrowed again")

    Provides methods to manipulate the data

What it does NOT do:

    Display information to the user

    Handle user input

    Make decisions about application flow

Analogy: The actual books on the library shelves with information printed inside.
2. VIEW (LibraryView.java) - The Presentation Layer

Purpose: Handles all user interaction and display.

Responsibilities:

    Shows menus and prompts to the user

    Collects user input

    Displays results and messages

    Formats output for readability

What it does NOT do:

    Store or process business data

    Make decisions about business rules

    Know about the application's logic

Analogy: The library's computer screen and keyboard interface.
3. CONTROLLER (LibraryController.java) - The Logic Layer

Purpose: Connects Model and View, contains application logic.

Responsibilities:

    Processes user requests from the View

    Updates the Model based on business rules

    Retrieves data from the Model for the View

    Manages the flow of the application

What it does NOT do:

    Store data permanently

    Display information directly

    Handle user input directly

Analogy: The librarian who processes requests and manages the system.
🔄 MVC Flow Example: Borrowing a Book
text

User Action → View → Controller → Model → Controller → View → User Feedback

Step-by-Step Process:

    User chooses "Borrow a book" from the menu

    View asks: "Enter book ID:" and collects input

    View sends the book ID to the Controller

    Controller asks the Model: "Get me book with this ID"

    Model returns the book data to the Controller

    Controller checks: "Is this book available?"

    Controller updates the Model: "Mark this book as borrowed"

    Controller tells the View: "Show success message"

    View displays: "Book borrowed successfully!"

    User sees the confirmation

📂 Project Structure
text

simple-library-mvc/
├── src/
│   ├── Book.java              # MODEL: Data representation
│   ├── LibraryView.java       # VIEW: User interface
│   ├── LibraryController.java # CONTROLLER: Application logic
│   └── Main.java             # Application entry point
└── README.md

🛠️ Required Java Knowledge
Basic Concepts Needed:

    Classes and Objects

    Methods and Constructors

    Arrays and ArrayLists

    Loops (for, while)

    Conditional Statements (if-else)

    Basic Input/Output (Scanner class)

MVC-Specific Concepts:

    Encapsulation (private fields with public methods)

    Separation of Concerns

    Class Communication

    Single Responsibility Principle

🚀 Learning Path
Phase 1: Model Layer (Book.java)

    Create the Book class with private fields

    Implement constructor and getter methods

    Add basic methods: borrowBook(), returnBook()

    Test creating and manipulating Book objects

Phase 2: View Layer (LibraryView.java)

    Create menu display methods

    Implement user input collection

    Add output formatting methods

    Test the user interface separately

Phase 3: Controller Layer (LibraryController.java)

    Create a list to manage multiple books

    Implement business logic methods

    Connect View requests to Model updates

    Test the complete flow

Phase 4: Integration (Main.java)

    Connect all three layers

    Implement the main application loop

    Test the complete application

💡 Key MVC Principles Learned
Separation of Concerns

Each layer has one specific responsibility:

    Model manages data

    View handles display

    Controller processes logic

Benefits of MVC

    Maintainability: Change one layer without affecting others

    Testability: Test each layer independently

    Reusability: Use the same Model with different Views

    Team Collaboration: Different developers can work on different layers

Common MVC Mistakes to Avoid

    View manipulating Model directly ❌

        Wrong: book.isBorrowed = true; (in View)

        Right: controller.borrowBook(bookId);

    Model containing display logic ❌

        Wrong: System.out.println("Book: " + title); (in Model)

        Right: view.displayBook(book);

    Controller storing business data ❌

        Wrong: Storing book list in Controller

        Right: Model/Repository stores the data

