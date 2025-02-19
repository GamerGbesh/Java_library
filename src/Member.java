import java.util.ArrayList;

/**
 * This class is to create the schema for members that would join the library
 */
public class Member {
    private String name;
    private int age;
    private String contact;
    private String email;
    private float debt;
    private final ArrayList<Book> books_possessed = new ArrayList<>();

    public Member(String name, int age, String contact, String email) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;

    }

    public void showBooks(){
        for (Book book : books_possessed) System.out.println(book.getName());
    }

    /**
     * This method allows a member to borrow a book
     * @param book This refers to the book the member wants to borrow
     * @throws Exception Checks if the person has borrowed the max number of books
     * @throws Exception Checks if the user has already borrowed the book
     */
    public void addBorrowedBooks(Book book) throws Exception {
        if (books_possessed.size() == 2){
            throw new Exception(name + " has already borrowed the max number of books!");
        }
        else if (books_possessed.contains(book)) {
            throw new Exception(name + " has already borrowed this book!");
        }
        else books_possessed.add(book);
    }

    /**
     * This function is used to return a book that a member has borrowed
     * @param book This is the book the member is returning
     * @throws IllegalArgumentException if the book has not been borrowed by that person
     */
    public void removeBorrowedBooks(Book book){
        if (books_possessed.isEmpty()){
            System.out.println(name + " has not borrowed any books!");
            return;
        }
        if (books_possessed.contains(book)){
            books_possessed.remove(book);
        }
        else{
            throw new IllegalArgumentException(book.getName() + " has not been borrowed by " + name);
        }
    }

    public float getDebt(){
        return debt;
    }

    public void addDebt(float amount){
        if (amount < 0){
            throw new IllegalArgumentException("The amount to be paid cannot be negative");
        }
        else{
            this.debt += amount;
        }
    }

    /**
     * This function is used to pay the debt the person owes
     * @param amount the amount to be paid
     * @throws IllegalArgumentException if the amount is negative or the amount is more than what is owed
     */
    public void payDebt(float amount){
        if (amount < 0){
            throw new IllegalArgumentException("The amount to be paid cannot be negative");
        }
        else if (amount > this.debt){
            throw new IllegalArgumentException("The amount to be paid cannot be more than the debt owed!");
        }
        else{
            this.debt -= amount;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
