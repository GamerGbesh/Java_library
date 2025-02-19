import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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

    public void addBooks(Book book){
        if (books.containsKey(book)){
            books.put(book, books.get(book) + 1);
        }
        else{
            books.put(book, 1);
        }
    }

    public void viewBooks(){
        System.out.println("All the books in the library");
        System.out.println("-".repeat(50));
        for (Map.Entry<Book, Integer> entry : books.entrySet()){
            System.out.println("Title: " + entry.getKey().getName() + " | Quantity: " + entry.getValue());
        }
    }

    public void addMembers(Member member){
        this.members.add(member);
    }

    public void displayMembers(){
        for (Member member : members){
            System.out.println(member.getName());
        }
    }

    public void giveBook(Member member, Book book){
        /*
        This function is supposed to check if a book exists in the dictionary, if the books exists check if the quantity is more than 0.
        If the person doesn't already have the max number of books then you can add the new book to the person's borrowed books.
         */
    }

}
