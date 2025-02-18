import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<Book>();
    private String name;

    public Library(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addBooks(Book book){
        this.books.add(book);
    }

    public void viewBooks(){
        for (Book book : books){
            System.out.println(book.getName());
        }
    }

//    public static void main(String[] args) {
//        Library lib = new Library("Gbesh Library");
//        Book one = new Book("Alice in the wonderland", "123-432", "James Freeman", "Horrow");
//        Book two = new Book("Puss in boots", "GH2-341", "Micheal Helmsworth", "Fiction");
//        lib.addBooks(one);
//        lib.addBooks(two);
//        lib.viewBooks();
//    }
}
