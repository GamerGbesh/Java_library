public class Main {
    public static void main(String[] args){
        Library lib = new Library("Gbesh");
        Book book1 = new Book("Forever young", "123043-5", "James Newmont", "Fun");
        Book book2 = new Book("Never Die", "12304-gh123", "Farad Helmsworth", "Horror");
        Book book3 = new Book("Another one", "12gh123", "Micheal Helmsworth", "Horror");
        Member me = new Member("Jefferson", 23, "0202229944", "frend@gmail.com");
        Member you = new Member("Anwal", 43, "00995423", "anw@gmail.com");
        lib.addMembers(me);
        lib.addMembers(you);
        lib.addBooks(book1);
        lib.addBooks(book2);
        lib.viewBooks();
        lib.displayMembers();
        lib.giveBook(me, book1);
        lib.viewBooks();
        me.showBooks();
        lib.giveBook(me, book3);
        me.showBooks();

    }
}