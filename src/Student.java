import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String department;
    private List<Book> borrowedBooks;

    public Student(int id, String name, String department) {
        super(id, name);
        this.department = department;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getDepartment() { return department; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + id + " | Name: " + name + " | Dept: " + department);
        System.out.println("Total Borrowed Books: " + borrowedBooks.size());
    }
}