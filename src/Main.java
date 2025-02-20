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

                Book book = new Book(name, ISBN, author, genre);
                library.addBooks(book);
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
                    System.out.println("If yes, write the person's index else write no");
                    int another = scanner.nextInt(); scanner.nextLine();
                    if (another != 0){
                        Member member = library.members.get(another-1);
                        member.showBooks();
                    }
                }

            }

        }

        scanner.close();
    }
}