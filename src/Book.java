public class Book {
    private String name;
    private String ISBN;
    private String author;
    private String genre;

    public Book(String name, String ISBN, String author, String genre){
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getISBN(){
        return this.ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

}
