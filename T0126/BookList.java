package T0126;

public class BookList {
    private Book[] book=new Book[100];
    private int size=0;

    public BookList() {
        book[0]=new Book("三国演义","罗贯中",100,"古典");
        book[1]=new Book("西游记","吴承恩",100,"古典");
        book[2]=new Book("水浒传","施耐庵",100,"古典");
        book[3]=new Book("红楼梦","曹雪芹",100,"古典");
        size=4;
    }

    public Book getBook(int index) {
        return book[index];
    }

    public void setBook(int index,Book book) {
        this.book[index]=book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
