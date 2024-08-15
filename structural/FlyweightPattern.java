package designpatterns.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book{
    private String name;
    String author;
    BookType bookType;

    Book(String name, String author, BookType bookType){
        this.name = name;
        this.author = author;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookType=" + bookType +
                '}';
    }
}

class BookType{
     String type;
     String distributor;

    BookType(String type, String distributor){
        this.type = type;
        this.distributor = distributor;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "type='" + type + '\'' +
                ", distributor='" + distributor + '\'' +
                '}';

    }
}

class FlyweightBookFactory{
     static Map<String,BookType> bookTypeMap = new HashMap<>();

    public static BookType getBookType(String type, String distributor){
        BookType bookType = bookTypeMap.get(type);
        if(bookType==null){
            bookType = new BookType(type,distributor);
            bookTypeMap.put(type,bookType);
        }
        return bookType;
    }
}

class BookStore{
    private List<Book> books = new ArrayList<>();
    public void storeBook(String name, String author, String type, String distributor){
        BookType bookType = FlyweightBookFactory.getBookType(type, distributor);
        books.add(new Book(name,author,bookType));
    }

    public void displayBooks(){
        books.stream().forEach(System.out::println);
    }
}
public class FlyweightPattern {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.storeBook("Book1","Author1","Type1","Distributor1");
        bookStore.storeBook("Book2","Author2","Type2","Distributor2");
        bookStore.storeBook("Book3","Author3","Type1","Distributor1");
        bookStore.displayBooks();
        System.out.println(FlyweightBookFactory.bookTypeMap.size());
    }

}
