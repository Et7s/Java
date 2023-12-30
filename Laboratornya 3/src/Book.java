public class Book {
    private String name;
    private String author;
    private int copy;

    public Book(String name, String author, int copy) {
        this.name = name;
        this.author = author;
        this.copy = copy;
    }
    //геттеры
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public int getCopy() {
        return copy;
    }
    //сеттеры
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCopy(int copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                ", copy='" + copy + '}';
    }
}
