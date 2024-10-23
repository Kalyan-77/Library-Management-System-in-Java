# Library Management System

This is a simple Library Management System built in Java using a Linked List data structure. The system allows users to manage a collection of books and perform key operations such as adding books, searching for books, issuing and returning books, and deleting entries from the system.

Key Features:
    Add a Book: Adds a new book to the library with a unique ID. It checks for duplicate IDs to avoid conflicts.
    Search Books:
    Search by Book ID
    Search by Book Title
    Issue Book: Issues a book to a person if it’s available. It updates the book's status to "Issued" and records the person’s name.
    Return Book: Allows a user to return an issued book, updating its status to "Available."
    Delete Book: Deletes a book from the library using either the book's ID or title.
    Display All Books: Shows a list of all books in the library with their status (Issued/Available) and to whom they are issued.
    Input Validation: Ensures all integer inputs (e.g., Book ID, menu choice) are correctly entered to prevent invalid entries.
Tech Stack:
    Java
    Linked List Data Structure
