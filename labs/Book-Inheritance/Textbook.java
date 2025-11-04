public class Textbook extends Book {

    private boolean used;
    private boolean electronicAccess;

    public Textbook(String title, String author, int publi_year, int num_of_pages, boolean u) {
        super(title, author, publi_year, num_of_pages);
        used = u;
        electronicAccess = false;
    }

    public void addElectronicAccess() {
        if (!used && publi_year >= 2020) {
            electronicAccess = true;
        }
    }

    public double getPrice() {
        double price;

        if (publi_year >= 2020) {
            price = 199.99;
        } else {
            price = 149.99;
        }

        if (used) {
            price *= 0.7;
        }

        if (electronicAccess) {
            price += 50.00;
        }

        return price;
    }

    public String toString() {
        StringBuilder build = new StringBuilder(super.toString());

        if(used) {
            build = build.append("\nUsed");
        }
        if(electronicAccess) {
            build = build.append("\nIncludes electronic access");
        }
        String override = build.toString();
        return override;
    }
}