import java.util.*;

public class Lab18 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Book[] books = new Book[5];

        books[0] = new ChildrensBook("Make Way for Ducklings", "Robert McCloskey", 1941, 72, true, true);

        books[1] = new Textbook("Introduction to Algorithms, 4th Edition", "Thomas Corman et al", 2022, 1312, true);

        books[2] = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310);

        books[3] = new Book("Fourth Wing", "Rebecca Yarros", 2023, 517);

        Textbook tb = new Textbook("Managerial Accounting, 17th Edition", "Carl Warren et al", 2025, 800, false);
        tb.addElectronicAccess(); 
        books[4] = tb;

        for (Book b : books) {
            System.out.println(b);
            System.out.println();
        }
    }
}
