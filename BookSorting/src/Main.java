import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> books = new TreeSet<>(new BookNameComparator());
        //Nesnelerden kitapları oluşturduk.
        books.add(new Book("Fisek", 240, "Yahya Kemal", "01.01.1990"));
        books.add(new Book("Benzersiz", 140, "Adnan Kemal", "12.01.1980"));
        books.add(new Book("Ali Veli", 210, "Yahya Ali", "03.11.1890"));
        books.add(new Book("Kursunlu", 180, "Demir Kır", "09.07.2003"));
        books.add(new Book("Güzelyali", 70, "Nevin Gülser", "05.01.1962"));
        //Kitapları tek tek gezmek için döngü kullandık.
        System.out.println("books are listed in alphabetical order !");
        for (Book i: books) {
            System.out.println(i.getBookName());
        }

        System.out.println("##################");
        System.out.println("books are ordered by page number !");
        //Nesnelerden kitapları oluşturduk.
        TreeSet<Book> booksNew = new TreeSet<>(new BookPageOfNumberComparator());
        booksNew.add(new Book("Fisek", 240, "Yahya Kemal", "01.01.1990"));
        booksNew.add(new Book("Benzersiz", 140, "Adnan Kemal", "12.01.1980"));
        booksNew.add(new Book("Ali Veli", 210, "Yahya Ali", "03.11.1890"));
        booksNew.add(new Book("Kursunlu", 180, "Demir Kır", "09.07.2003"));
        booksNew.add(new Book("Güzelyali", 70, "Nevin Gülser", "05.01.1962"));
        //Kitapları tek tek gezmek için döngü kullandık.
        for (Book b: booksNew) {
            System.out.println(b.getNumberOfPages());
        }



    }
}