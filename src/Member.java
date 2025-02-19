import java.util.ArrayList;

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

    public void addBorrowedBooks(Book book) throws Exception {
        if (books_possessed.size() >= 2){
            throw new Exception(name + " has already borrowed the max number of books!");
        }
        else books_possessed.add(book);
    }

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
