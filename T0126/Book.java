package T0126;

public class Book {
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isBorrow=false;

    public Book(String name,String author,double price,String type) {
        this.name = name;
        this.author=author;
        this.price=price;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrow=" + isBorrow +
                '}';
    }
}
