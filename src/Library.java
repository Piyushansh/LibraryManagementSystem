import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryOperations {
    private List<Book> books;
    private List<Student> students;

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Success: Book added to the library.");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Success: Student registered in the system.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The library currently has no books.");
            return;
        }
        for (Book b : books) {
            String status = b.isAvailable() ? "Available" : "Issued";
            System.out.println("ID: " + b.getBookId() + " | " + b.getBookName() + " by " + b.getAuthorName() + " | Status: " + status);
        }
    }

    public void viewStudentDetails(int studentId) throws InvalidIdException {
        Student s = findStudent(studentId);
        s.displayDetails();
        if (!s.getBorrowedBooks().isEmpty()) {
            System.out.println("Books currently held:");
            for(Book b : s.getBorrowedBooks()) {
                System.out.println(" - " + b.getBookName() + " (ID: " + b.getBookId() + ")");
            }
        }
    }

    private Student findStudent(int id) throws InvalidIdException {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        throw new InvalidIdException("Student with ID " + id + " does not exist.");
    }

    private Book findBook(int id) throws BookNotFoundException {
        for (Book b : books) {
            if (b.getBookId() == id) return b;
        }
        throw new BookNotFoundException("Book with ID " + id + " does not exist.");
    }

    @Override
    public void issueBook(int studentId, int bookId) throws Exception {
        Student student = findStudent(studentId);
        Book book = findBook(bookId);

        if (!book.isAvailable()) {
            throw new BookAlreadyIssuedException("This book is currently issued to another student.");
        }
        if (student.getBorrowedBooks().size() >= 3) {
            throw new BorrowLimitExceededException("Borrow limit reached! A student can borrow a maximum of 3 books.");
        }

        book.setAvailable(false);
        student.getBorrowedBooks().add(book);
        System.out.println("Success: '" + book.getBookName() + "' has been issued to " + student.getName());
    }

    @Override
    public void returnBook(int studentId, int bookId) throws Exception {
        Student student = findStudent(studentId);
        Book book = findBook(bookId);

        if (!student.getBorrowedBooks().contains(book)) {
            throw new Exception("Error: This book was not borrowed by this student.");
        }

        book.setAvailable(true);
        student.getBorrowedBooks().remove(book);
        System.out.println("Success: '" + book.getBookName() + "' has been successfully returned.");
    }
}