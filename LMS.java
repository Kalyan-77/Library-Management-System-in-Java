package Projects;
import java.util.InputMismatchException;
import java.util.*;

 class Node{
    int id;
    String name;
    String author;
    boolean issued;
    String issuedTo;
    Node next;
}
class LinkedList{
    Node head;
    public void AddBook(int id, String name, String author){
        Node current = head;
        while(current != null){
            if(current.id == id){
                System.out.println("+---------------------------------------------------------------------+");
                System.out.println("|      Book With ID "+id+" is already exists. Please enter another id.     |");
                System.out.println("+---------------------------------------------------------------------+");
                return;
            }
            current = current.next;
        }
        Node node = new Node();
        node.id = id;
        node.name = name;
        node.author = author;
        node.next = null;

        if(head == null){
            head = node;
        }else{
            current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                      Book Added Successfully                        |");
        System.out.println("+---------------------------------------------------------------------+");
    }
    public void SearchById(int id){
        Node current = head;
        boolean found = false;
        while(current != null){
            if(current.id == id){
                found = true;
                break;
            }
            found = false;
            current = current.next;
        }
        if(found){
            String status = current.issued ? "Issued" : "Available";
            String issuedTo = current.issued ? current.issuedTo : "N/A";
            
            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-30s | %-30s | %-10s | %-17s |\n", "ID", "Book Name", "Book Author", "Status", "Issued To");
            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10d | %-30s | %-30s | %-10s | %-17s |\n", current.id, current.name, current.author, status, issuedTo);
            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        }else{
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                      Book Not Found                                 |");
            System.out.println("+---------------------------------------------------------------------+");
        }
    }
    public void SearchByTitle(String title){
        Node current = head;
        boolean found = false;
        while(current != null){
            if (current.name.equalsIgnoreCase(title)) {
                found = true;
                break;
            }
            found = false;
            current = current.next;
        }
        if(found){
            String status = current.issued ? "Issued" : "Available";
            String issuedTo = current.issued ? current.issuedTo : "N/A";
            
            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-30s | %-30s | %-10s | %-17s |\n", "ID", "Book Name", "Book Author", "Status", "Issued To");
            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10d | %-30s | %-30s | %-10s | %-17s |\n", current.id, current.name, current.author, status, issuedTo);
            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        }else{
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                      Book Not Found                                 |");
            System.out.println("+---------------------------------------------------------------------+");
        }
    }
    public void IssueBook(int id, String person_name){
        Node current = head;
        boolean found = false;
        while(current != null){
            if(current.id == id){
                found = true;
                if(current.issued){
                    System.out.println("+---------------------------------------------------------------------+");
                    System.out.println("|                       Book already Issued.                          |");
                    System.out.println("+---------------------------------------------------------------------+");
                    return;
                }else{
                    current.issued = true;
                    current.issuedTo = person_name;
                    System.out.println("+-------------------------------------------------------------------------------------+");
                    System.out.println("|           Book "+current.name+" is issued to "+person_name+" successfully             |");
                    System.out.println("+-------------------------------------------------------------------------------------+");
                    return;
                }
            }
            current = current.next;
        }
        if(!found){
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                      Book Not Found                                 |");
            System.out.println("+---------------------------------------------------------------------+");
        }
    }
    public void ReturnBook(int id){
        Node current = head;
        boolean found = false;

        while(current != null){
            if(current.id == id){
                found = true;
                if(!current.issued){
                    System.out.println("+---------------------------------------------------------------------+");
                    System.out.println("|                      No Book To Return.                             |");
                    System.out.println("+---------------------------------------------------------------------+");
                    return;
                }else{
                    // String no = "None";
                    current.issued = false;
                    current.issuedTo = "None";
                    System.out.println("+---------------------------------------------------------------------+");
                    System.out.println("|          Book "+current.name+" successfully Submitted.                |");
                    System.out.println("+---------------------------------------------------------------------+");
                    return;
                }
            }
            current = current.next;
        }
        if(!found){
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                      Book Not Found                                 |");
            System.out.println("+---------------------------------------------------------------------+");
        }
    }
    public void DeleteBook(int Delete_id, String Delete_title){
        Node current = head;
        Node previous = null;
        boolean found = false;
        while(current != null){
            if(current.id == Delete_id || current.name.equalsIgnoreCase(Delete_title)){
                found = false;
                if(current == head){
                    head = head.next;
                }else{
                    previous.next = current.next;
                }
                System.out.println("+-------------------------------------------------------------------------------------+");
                System.out.println("|                      Book with ID"+current.id+" and Title "+current.name+" deleted successfully.              |");
                System.out.println("+-------------------------------------------------------------------------------------+");
                return;
            }
            previous = current;
            current = current.next;
        }
        if(!found){
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                      Book Not Found                                 |");
            System.out.println("+---------------------------------------------------------------------+");
        }
    }
    public void Display() {
        if (head == null) {
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                        No Books are Available                       |");
            System.out.println("+---------------------------------------------------------------------+");
            return;
        }
        Node current = head;
        System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-30s | %-30s | %-10s | %-20s |\n", "ID", "Book Name", "Book Author", "Status", "Issued To");
        System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        while (current != null) {
            String status = current.issued ? "Issued" : "Available";
            String issuedTo = current.issued ? current.issuedTo : "N/A";
            
            System.out.printf("| %-10d | %-30s | %-30s | %-10s | %-20s |\n", current.id, current.name, current.author, status, issuedTo);
            current = current.next;
        }
        System.out.println("+---------------------------------------------------------------------------------------------------------------+");
    }
}
public class Project1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("Library Management System");

        while (true) {
            System.out.println("1.Add Book.");
            System.out.println("2.Search Book By ID.");
            System.out.println("3.Search Book By Title.");
            System.out.println("4.Issue Book.");
            System.out.println("5.Return Book.");
            System.out.println("6.List of All Books.");
            System.out.println("7.Delete.");
            System.out.println("8.Exit.");


            choice = getValidIntegerInput(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int id = getValidIntegerInput(sc, "Enter Book ID: ");
                    
                    System.out.print("Enter Book Name: ");
                    String name = sc.next();

                    System.out.print("Enter Book Author: ");
                    String author = sc.next();

                    list.AddBook(id, name, author);
                    break;

                case 2:
                    int searchid = getValidIntegerInput(sc, "Enter the Book ID to Search: ");
                    list.SearchById(searchid);
                    break;

                case 3:
                    System.out.print("Enter the Book Title to Search: ");
                    String searchtitle = sc.next();
                    list.SearchByTitle(searchtitle);
                    break;

                case 4:
                    int issueID = getValidIntegerInput(sc, "Enter the Book ID to Issue: ");
                    
                    System.out.print("Enter the Student Name: ");
                    String student_name = sc.next();

                    list.IssueBook(issueID, student_name);
                    break;

                case 5:
                    int returnid = getValidIntegerInput(sc, "Enter the Book ID to return: ");
                    list.ReturnBook(returnid);
                    break;

                case 6:
                    list.Display();
                    break;

                case 7:
                    int Delete_id = getValidIntegerInput(sc, "Enter Book ID to Delete: ");
                    
                    System.out.print("Enter Book Title to Delete: ");
                    String Delete_title = sc.next();
                    
                    list.DeleteBook(Delete_id, Delete_title);
                    break;

                case 8:
                    System.out.println("Exiting.......");
                    System.out.println("THANK YOU");
                    return;

                default:
                    System.out.println("Enter a valid option....");
            }
        }
    }
    public static int getValidIntegerInput(Scanner sc, String prompt) {
        int value = 0;
        while (true) {
            try {
                System.out.print(prompt);
                value = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();
            }
        }
        return value;
    }
}
