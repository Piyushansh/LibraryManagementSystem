public interface LibraryOperations {
    void issueBook(int studentId, int bookId) throws Exception;
    void returnBook(int studentId, int bookId) throws Exception;
}