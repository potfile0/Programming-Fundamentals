public class Book {

    //fields
    protected String title;
    protected String author;
    protected int publi_year;
    protected int num_of_pages;

    //constructor
    public Book(String t, String a, int p, int n) {
        title = t;
        author = a;
        publi_year = p;
        num_of_pages = n;
    }

    public double getPrice() {
        double basePrice;

        if (publi_year <= 2015) {
            basePrice = 9.99;
        } else {
            basePrice = 14.99;
        }

        if (num_of_pages > 300) {
            int extraPages = num_of_pages - 300;
            int extraBlocks = (extraPages + 99) / 100;
            basePrice += extraBlocks * 0.25;
        }

        return basePrice;
    }

    public String toString() {
        return String.format(
            "Title: %s\nAuthor: %s\nYear of publication: %d\nPage count: %d\nPrice: $%.2f", title, author, publi_year, num_of_pages, getPrice());
    }
}