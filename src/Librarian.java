public class Librarian extends Person {
    public Librarian(int id, String name) {
        super(id, name);
    }

    @Override
    public void displayDetails() {
        System.out.println("Librarian ID: " + id + " | Name: " + name);
    }
}