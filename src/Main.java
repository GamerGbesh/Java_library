import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Library library = new Library("Gbesh");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("This is the menu. Choose the operation you want to perform");
            System.out.println("0. Close the application");
            System.out.println("1. Add a new book to the library");
            System.out.println("2. Add a new member to the library");
            System.out.println("3. Show all the books the library possesses");
            System.out.println("4. Show the members of the library");
            System.out.println("5. Borrow book");
            System.out.println("6. Return book");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            else if (choice == 1){
                System.out.print("Enter the name of the book: ");
                String name = scanner.nextLine();
                System.out.print("Enter the ISBN of the book: ");
                String ISBN = scanner.nextLine();
                System.out.print("Enter the author of the book: ");
                String author = scanner.nextLine();
                System.out.print("Enter the genre of the book: ");
                String genre = scanner.nextLine();
                System.out.println("How many copies of the book are you adding: ");
                int count = scanner.nextInt(); scanner.nextLine();
                library.addBooks(name, ISBN, author, genre, count);
            }
            else if (choice == 2) {
                System.out.print("Enter the name of the member: ");
                String name = scanner.nextLine();
                System.out.print("Enter the age of the member: ");
                int age = scanner.nextInt(); scanner.nextLine();
                System.out.print("Enter the contact of the member: ");
                String contact = scanner.nextLine();
                System.out.print("Enter the email of the member: ");
                String email = scanner.nextLine();
                Member member = new Member(name, age, contact, email);
                library.addMembers(member);
            }
            else if (choice == 3) {
                library.viewBooks();
            }
            else if (choice == 4){
                if (library.displayMembers()){
                    System.out.println("Do you want to get show a members borrowed books?");
                    System.out.println("If yes, write the person's index else write 0");
                    int another = scanner.nextInt(); scanner.nextLine();
                    if (another != 0){
                        Member member = library.members.get(another-1);
                        member.showBooks();
                    }
                }
                else System.out.println("There are no members in the library!");
            } else if (choice == 5) {
                if (library.displayMembers()){
                    System.out.println("Write the index of the member who is going to borrow the book.");
                    int another = scanner.nextInt(); scanner.nextLine();
                    if (another != 0){
                        Member member = library.members.get(another-1);
                        ArrayList<Book> books = library.viewBooks();
                        int selection = scanner.nextInt(); scanner.nextLine();
                        Book book = books.get(selection-1);
                        library.giveBook(member, book);
                    }
                    else {
                        System.out.println("There is no member with that index in the library");
                    }
                }
                else System.out.println("There are no members in the library!");

            } else if (choice == 6) {
                if (library.displayMembers()) {
                    System.out.println("Write the index of the member who is going to return the book.");
                    int another = scanner.nextInt();
                    scanner.nextLine();
                    if (another != 0) {
                        Member member = library.members.get(another - 1);
                        ArrayList<Book> books = member.showBooks();
                        if (!books.isEmpty()) {
                            int selection = scanner.nextInt();
                            scanner.nextLine();
                            Book book = books.get(selection - 1);
                            library.returnBook(member, book);
                        }
                        else{
                            System.out.println(member.getName() + " hasn't borrowed any book!");
                        }
                    } else {
                        System.out.println("There is no member with that index in the library");
                    }
                }
            }
        }
        scanner.close();
    }
}