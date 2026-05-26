public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private boolean isAvailable;

    public Book(int bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isAvailable = true; // Available by default when added
    }

    public int getBookId() { return bookId; }
    public String getBookName() { return bookName; }
    public String getAuthorName() { return authorName; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}