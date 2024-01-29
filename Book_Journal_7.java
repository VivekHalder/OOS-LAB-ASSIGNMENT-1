import java.util.*;

abstract class Publication{

    private int noOfPages;
    private double price;
    private String publisherName;

    public Publication( int noOfPages, double price, String publisherName ){
        this.noOfPages = noOfPages;
        this.price = price;
        this.publisherName = publisherName;
    }

    public int getNoOfPages(){
        return noOfPages;
    }

    public double getPrice(){
        return price;
    }

    public String getPublisherName(){
        return publisherName;
    }

    abstract public void displayDetails();
}

class Book extends Publication{
    private String bookName;
    private String authorName;

    public Book( int noOfPages, double price, String publisherName, String authorName, String bookName ){
        super( noOfPages, price, publisherName );
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public String getBookName(){
        return bookName;
    }

    public String getAuthor(){
        return authorName;
    }

    public void setAuthor( String authorName ){
        this.authorName = authorName;
    }

    public void displayDetails(){
        System.out.println( "Name of the book: "+bookName+"." );
        System.out.println( "Name of the author: "+authorName+"." );
        System.out.println( "Number of pages: "+getNoOfPages()+"." );
        System.out.println( "Price of the book: "+getPrice()+"." );
        System.out.println( "Publisher's name: "+getPublisherName()+"." );
    }
}

class Journal extends Publication{
    private String journalName;

    public Journal( int noOfPages, double price, String publisherName, String journalName ){
        super( noOfPages, price, publisherName );
        this.journalName = journalName;
    }

    public String getJournalName(){
        return journalName;
    }

    public void displayDetails(){
        System.out.println( "Name of the journal: "+journalName+"." );
        System.out.println( "Number of pages: "+getNoOfPages()+"." );
        System.out.println( "Price of the journal: "+getPrice()+"." );
        System.out.println( "Publisher's name: "+getPublisherName()+"." );
    }
}

class Library{
    private List< Publication > publications;

    public Library(){
        this.publications = new ArrayList<>();
    }

    public void addPublication( Publication publication ){
        publications.add( publication );
    }

    public void displayAllPublications(){
        for( Publication publication : publications ){
            publication.displayDetails();
            System.out.println();
        }
    }
}

class Main{
    public static void main( String args[] ){
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Book 1:");
        System.out.print("Author: ");
        String author1 = scanner.nextLine();
        System.out.print("No. of Pages: ");
        int pages1 = scanner.nextInt();
        System.out.print("Price: ");
        double price1 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher1 = scanner.nextLine();
        System.out.print("Book Name: ");
        String bookName1 = scanner.nextLine();

        Book book1 = new Book(pages1, price1, publisher1, author1, bookName1);

        System.out.println("\nEnter details for Book 2:");
        System.out.print("Author: ");
        String author2 = scanner.nextLine();
        System.out.print("No. of Pages: ");
        int pages2 = scanner.nextInt();
        System.out.print("Price: ");
        double price2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher2 = scanner.nextLine();
        System.out.print("Book Name: ");
        String bookName2 = scanner.nextLine();

        Book book2 = new Book(pages2, price2, publisher2, author2, bookName2);

        System.out.println("\nEnter details for Journal 1:");
        System.out.print("Journal Name: ");
        String journalName1 = scanner.nextLine();
        System.out.print("No. of Pages: ");
        int journalPages1 = scanner.nextInt();
        System.out.print("Price: ");
        double journalPrice1 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Publisher: ");
        String journalPublisher1 = scanner.nextLine();

        Journal journal1 = new Journal(journalPages1, journalPrice1, journalPublisher1, journalName1);

        System.out.println("\nEnter details for Journal 2:");
        System.out.print("Journal Name: ");
        String journalName2 = scanner.nextLine();
        System.out.print("No. of Pages: ");
        int journalPages2 = scanner.nextInt();
        System.out.print("Price: ");
        double journalPrice2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Publisher: ");
        String journalPublisher2 = scanner.nextLine();

        Journal journal2 = new Journal(journalPages2, journalPrice2, journalPublisher2, journalName2);

        library.addPublication(book1);
        library.addPublication(book2);
        library.addPublication(journal1);
        library.addPublication(journal2);

        System.out.println();
        System.out.println();
        library.displayAllPublications();

        scanner.close();
    }
}