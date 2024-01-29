import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String publisher;
    private double cost;
    private int stockPosition;

    // Constructor
    public Book(String title, String author, String publisher, double cost, int stockPosition) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.cost = cost;
        this.stockPosition = stockPosition;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Cost: $" + cost);
        System.out.println("Stock Position: " + stockPosition + " copies");
    }

    // Check availability and process order
    public void processOrder(int requiredCopies) {
        if (requiredCopies <= stockPosition) {
            double totalCost = requiredCopies * cost;
            System.out.println("Book is available.");
            System.out.println("Total Cost for " + requiredCopies + " copies: $" + totalCost);
            stockPosition -= requiredCopies;  // Update stock position after the sale
        } else {
            System.out.println("Required copies not in stock.");
        }
    }
}

class BookshopSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example usage
        Book book1 = createBook(scanner);
        Book book2 = createBook(scanner);

        // Display book details
        System.out.println("Book Inventory:");
        book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();
        System.out.println();

        // Process orders
        processOrder(scanner, book1);
        processOrder(scanner, book2);

        scanner.close();
    }

    private static Book createBook(Scanner scanner) {
        System.out.println("Enter book details:");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Cost: $");
        double cost = scanner.nextDouble();

        System.out.print("Stock Position: ");
        int stockPosition = scanner.nextInt();

        // Consume the newline character left by previous nextInt()
        scanner.nextLine();

        return new Book(title, author, publisher, cost, stockPosition);
    }

    private static void processOrder(Scanner scanner, Book book) {
        System.out.println("Enter book details to search and order:");
        System.out.print("Enter book title: ");
        String searchTitle = scanner.nextLine();
        System.out.print("Enter book author: ");
        String searchAuthor = scanner.nextLine();

        if (searchTitle.equalsIgnoreCase(book.getTitle()) && searchAuthor.equalsIgnoreCase(book.getAuthor())) {
            // Book found in inventory
            book.displayBookDetails();
            System.out.print("Enter number of copies required: ");
            int requiredCopies = scanner.nextInt();
            book.processOrder(requiredCopies);
        } else {
            // Book not found in inventory
            System.out.println("Book not found in the inventory.");
        }
    }
}