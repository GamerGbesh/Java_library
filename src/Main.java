public class Main {
    public static void main(String[] args) {
        Library lib = new Library("Gbesh");
        Book book1 = new Book("Forever young", "123043-5", "James Newmont", "Fun");
        Book book2 = new Book("Never Die", "12304-gh123", "Farad Helmsworth", "Horror");
        lib.addBooks(book1);
        lib.addBooks(book2);
        lib.viewBooks();

    }
}