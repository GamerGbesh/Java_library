import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class is to simulate an actual library
 */
public class Library {
    private final Map<Book, Integer> books = new HashMap<>();
    public final ArrayList<Member> members = new ArrayList<Member>();
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

    /**
     * This method is to add new books to the library
     * @param name This is the name of the book to be added to the library
     * @param author This is the author of the book
     * @param genre This is the genre of the book
     * @param ISBN This is the ISBN of the book
     */
    public void addBooks(String name, String ISBN, String author, String genre, int count){
        Book book = (checkBook(name, ISBN, author, genre));
        if (book != null){
           books.put(book, books.get(book) + count);
            }
        else {
            book = new Book(name, ISBN, author, genre);
            books.put(book, count);
        }
    }

    public Book checkBook(String name, String ISBN, String author, String genre) {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            if (Objects.equals(entry.getKey().getName(), name) && Objects.equals(entry.getKey().getAuthor(), author) && Objects.equals(entry.getKey().getISBN(), ISBN)) {
                return entry.getKey();
            }
        }
        return null;
    }


    /**
     * This function displays all the books currently owned by the library
     */
    public ArrayList<Book> viewBooks(){
        System.out.println("All the books in the library");
        System.out.println("-".repeat(50));
        ArrayList<Book> books_possessed = new ArrayList<>();
        int count = 1;
        for (Map.Entry<Book, Integer> entry : books.entrySet()){

            System.out.println(count + ". Title: " + entry.getKey().getName() + " | Quantity: " + entry.getValue());
            books_possessed.add(entry.getKey());
            count ++;
        }
        System.out.println("-".repeat(50));
        return books_possessed;
    }

    /**
     * This method adds new members to the library
     * @param member the person to be added to the library
     */
    public void addMembers(Member member){
        if (members.contains(member)){
            System.out.println(member.getName() + " is already a member of the library!");
        }
        else members.add(member);
    }

    /**
     * Displays all members of the library
     */
    public boolean displayMembers(){
        System.out.println("These are the members of library");
        System.out.println("-".repeat(50));
        for (int i = 0; i < members.size(); i++){
            System.out.println((i + 1) + " " + members.get(i).getName());
        }
        System.out.println("-".repeat(50));
        return !members.isEmpty();

    }

    /**
     * Checks if the book is in the library and then hands it to the person borrowing
     * @param member the member who wants borrow the book
     * @param book the book to be borrowed
     */
    public void giveBook(Member member, Book book){
        if (!books.containsKey(book)){
            System.out.println("This book is not in the library!");
        }
        else {
            if (books.get(book) <= 0){
                System.out.println("All available copies of this book have already been borrowed!");
                return;
            }
            if(member.addBorrowedBooks(book)) {
                books.put(book, books.get(book) - 1);
            }
        }
    }

    /**
     * This method is to return the books borrowed by the members back to the library
     * @param member this is the member that is to return the book
     * @param book this is the book to be returned
     */
    public void returnBook(Member member, Book book){
        if (!books.containsKey(book)){
            System.out.println("The library does not possess " + book.getName() + " therefore it cannot be accepted!");
        }
        if (member.removeBorrowedBooks(book)) addBooks(book.getName(), book.getISBN(), book.getAuthor(), book.getGenre(), 1);
    }
}
