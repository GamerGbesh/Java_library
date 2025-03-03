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

    /**
     * The constructor for the member class
     * @param name the name of the member
     * @param age the age of the member
     * @param contact the contact of the member
     * @param email the email of the member
     */
    public Member(String name, int age, String contact, String email) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
        debt = 0;
    }

    /**
     * This shows the books borrowed by the member
     * @return ArrayList of books that the member borrowed
     */
    public ArrayList<Book> showBooks(){
        System.out.println("These are the books borrowed by " + name);
        System.out.println("-".repeat(50));
        for (int i =0; i < books_possessed.size(); i++) System.out.println((i+1) + ". " +books_possessed.get(i).getName());
        System.out.println("-".repeat(50));
        return books_possessed;
    }

    /**
     * This method allows a member to borrow a book
     * @param book This refers to the book the member wants to borrow
     */
    public boolean addBorrowedBooks(Book book){
        if (books_possessed.size() == 2){
            System.out.println(name + " has already borrowed the max number of books!");
            return false;
        }
        else if (books_possessed.contains(book)) {
            System.out.println(name + " has already borrowed this book!");
            return false;
        }
        else books_possessed.add(book);
        return true;
    }

    /**
     * This function is used to return a book that a member has borrowed
     * @param book This is the book the member is returning
     */
    public boolean removeBorrowedBooks(Book book){
        if (books_possessed.isEmpty()){
            System.out.println(name + " has not borrowed any books!");
            return false;
        }
        if (books_possessed.contains(book)){
            books_possessed.remove(book);
            return true;
        }
        else{
            System.out.println(book.getName() + " has not been borrowed by " + name);
            return false;
        }
    }

    public float getDebt(){
        return debt;
    }

    /**
     * Used to add debt to the member when the member delays returning borrowed books
     * @param amount this is the amount of money to be added to the person's debt
     */
    public void addDebt(float amount){
        if (amount < 0){
            System.out.println("The amount to be paid cannot be negative");
        }
        else{
            this.debt += amount;
        }
    }

    /**
     * This function is used to pay the debt the person owes
     * @param amount the amount to be paid
     */
    public void payDebt(float amount){
        if (amount < 0){
            System.out.println("The amount to be paid cannot be negative");
        }
        else if (amount > this.debt){
            System.out.println("The amount to be paid cannot be more than the debt owed!");
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
