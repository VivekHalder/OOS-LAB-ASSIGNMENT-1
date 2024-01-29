import java.util.Scanner;

class Book {
    private String author;
    private String title;
    private String publisher;
    private double cost;
    private int stock;

    // Constructor
    public Book(String author, String title, String publisher, double cost, int stock) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.cost = cost;
        this.stock = stock;
    }

    // Method to check if the book is available
    public boolean isAvailable() {
        return stock > 0;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("Cost: Rs. " + cost);
        System.out.println("Stock: " + stock);
    }

    // Method to process a customer's request
    public void processRequest(int numberOfCopies) {
        if (isAvailable() && stock >= numberOfCopies) {
            double totalCost = cost * numberOfCopies;
            System.out.println("Books are available. Total cost for " + numberOfCopies + " copies: Rs. " + totalCost);
            stock -= numberOfCopies;
        } else {
            System.out.println("Required copies not in stock.");
        }
    }
}

class BookshopSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a sample book
        Book sampleBook = new Book("John Doe", "Sample Book", "ABC Publishers", 25.0, 10);

        // Display book details
        System.out.println("Enter the details of the book you are looking for:");
        sampleBook.displayDetails();

        // Check if the book is available
        if (sampleBook.isAvailable()) {
            // Process customer's request
            System.out.print("Enter the number of copies required: ");
            int numberOfCopies = scanner.nextInt();
            sampleBook.processRequest(numberOfCopies);
        } else {
            System.out.println("The book is not available.");
        }

        // Close the scanner
        scanner.close();
    }
}