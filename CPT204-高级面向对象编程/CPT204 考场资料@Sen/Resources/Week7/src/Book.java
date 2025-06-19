public class Book {

    // Do not modify or add the instance variables
    private String title;
    // Assume edition can only be 1st, 2nd, 3rd, 4th, ..., 8th edition
    private String edition;
    private double price;

    // Do not modify this constructor
    // It initializes the three instance variables
    public Book(String title, String edition, double price) {
        this.title = title;
        this.edition = edition;
        this.price = price;
    }

    // It returns the string representation of a Book object
    // in the format "title, edition, RMB price"
    @Override
    public String toString() {
        return title + ", " + edition + ", RMB " + price;
    }


    // Complete the method newer
    // It returns true iff both books have the same title,
    //     and this book is of newer edition than that of the other book
    public boolean newer(Book other) {
        // Check if both books have the same title
        if (!this.title.equals(other.title)) {
            return false;
        }

        // Extract the edition number from the edition string
        String[] thisEditionParts = this.edition.split(" ");
        String[] otherEditionParts = other.edition.split(" ");

        // Convert the edition number to an integer
        int thisEditionNumber = Integer.parseInt(thisEditionParts[thisEditionParts.length - 1]);
        int otherEditionNumber = Integer.parseInt(otherEditionParts[otherEditionParts.length - 1]);

        // Compare the edition numbers
        return thisEditionNumber > otherEditionNumber;
    }


    public static void main(String[] args) {
        Book book1 = new Book("Intro Java", "2nd edition", 200.0);
        Book book2 = new Book("Intro Java", "1st edition", 150.0);
        System.out.println(book1.newer(book2)); // Should print true
        System.out.println(book2.newer(book1)); // Should print false
    }

}