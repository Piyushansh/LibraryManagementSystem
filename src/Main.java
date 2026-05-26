import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Welcome to the Library Management System ===");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Student Details");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int bId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Book Name: ");
                        String bName = scanner.nextLine();
                        System.out.print("Enter Author Name: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(bId, bName, author));
                        break;
                    case 2:
                        library.viewAllBooks();
                        break;
                    case 3:
                        System.out.print("Enter Student ID: ");
                        int sId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String sName = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine();
                        library.addStudent(new Student(sId, sName, dept));
                        break;
                    case 4:
                        System.out.print("Enter Student ID: ");
                        int issueSId = scanner.nextInt();
                        System.out.print("Enter Book ID to issue: ");
                        int issueBId = scanner.nextInt();
                        library.issueBook(issueSId, issueBId);
                        break;
                    case 5:
                        System.out.print("Enter Student ID: ");
                        int retSId = scanner.nextInt();
                        System.out.print("Enter Book ID to return: ");
                        int retBId = scanner.nextInt();
                        library.returnBook(retSId, retBId);
                        break;
                    case 6:
                        System.out.print("Enter Student ID to view details: ");
                        int viewSId = scanner.nextInt();
                        library.viewStudentDetails(viewSId);
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting System... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid number from the menu.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}