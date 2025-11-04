public class ChildrensBook extends Book {

    private boolean illustrated;
    private boolean hardcover;

    public ChildrensBook(String title, String author, int publi_year, int num_of_pages, boolean i, boolean h) {
        super(title, author, publi_year, num_of_pages);
        illustrated = i;
        hardcover = h;
    }

    public double getPrice() {
        double price = 9.99;

        if (illustrated) {
            price += 5.00;
        }

        if (hardcover) {
            price += 5.00;
        }

        return price;
    }


    public String toString() {
        StringBuilder build = new StringBuilder(super.toString());

        if(illustrated) {
            build = build.append("\nIllustrated");
        }
        if(hardcover) {
            build = build.append("\nHardcover");
        }
        String override = build.toString();
        return override;
    }
}