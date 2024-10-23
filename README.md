# Library Management System

Project Overview:
This project implements a basic Library Management System in Java. It enables a librarian to efficiently manage book inventory and track book issuance. The system supports adding, searching, issuing, returning, and deleting books, offering a practical application of data structures like linked lists.

Features:
Add New Books: Librarians can add books to the system, each identified by a unique ID, with details such as title, author, and availability status (available or issued). The system uses a linked list to manage book data.

Search for a Book: Books can be searched by either their ID or title. When a book is found, its details, including availability status and issued information, are displayed. The system uses a linear search to locate books.

Issue a Book: Books can be issued to students, with the system updating their status to "Issued" and recording the student's name. The system prevents a book from being issued more than once.

Return a Book: Returned books are marked as "Available" again, and the student's information is cleared from the record.

List All Books: Librarians can view all the books in the system, with details like ID, title, author, and current status (available or issued). The system displays the books as they were added.

Delete a Book: Books can be deleted from the system using either their ID or title. The system removes the book node from the linked list.

Input Validation: The system ensures that all user inputs, especially integers like book IDs and menu options, are correctly entered to avoid errors.

