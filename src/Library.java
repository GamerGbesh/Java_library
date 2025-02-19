import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * This class is to simulate an actual library
 */
public class Library {
    private final Map<Book, Integer> books = new HashMap<>();
    private final ArrayList<Member> members = new ArrayList<Member>();
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
     * @param book This is the book to be added to the library
     */
    public void addBooks(Book book){
        if (books.containsKey(book)){
            books.put(book, books.get(book) + 1);
        }
        else{
            books.put(book, 1);
        }
    }

    /**
     * This function displays all the books currently owned by the library
     */
    public void viewBooks(){
        System.out.println("All the books in the library");
        System.out.println("-".repeat(50));
        for (Map.Entry<Book, Integer> entry : books.entrySet()){
            System.out.println("Title: " + entry.getKey().getName() + " | Quantity: " + entry.getValue());
        }
    }

    /**
     * This method adds new members to the library
     * @param member the person to be added to the library
     * @throws IllegalArgumentException if the member is already in the library
     */
    public void addMembers(Member member){
        if (members.contains(member)){
            throw new IllegalArgumentException(member.getName() + " is already a member of the library!");
        }
        else members.add(member);
    }

    /**
     * Displays all members of the library
     */
    public void displayMembers(){
        for (Member member : members){
            System.out.println(member.getName());
        }
    }

    /**
     * Checks if the book is in the library and then hands it to the person borrowing
     * @param member the member who wants borrow the book
     * @param book the book to be borrowed
     */
    public void giveBook(Member member, Book book) throws Exception {
        if (!books.containsKey(book)){
            throw new IllegalArgumentException("This book is not in the library!");
        }
        else {
            if (books.get(book) <= 0){
                System.out.println("All available copies of this book have already been borrowed!");
                return;
            }
            member.addBorrowedBooks(book);
            books.put(book, books.get(book) - 1);
        }
    }

    public void returnBook(Member member, Book book){
        if (!books.containsKey(book)){
            throw new IllegalArgumentException("The library does not possess " + book.getName() + " therefore it cannot be accepted!");
        }
        member.removeBorrowedBooks(book);
        addBooks(book);

    }
}
