import java.util.Scanner;

interface Fruit {
    void hasAPeel();
}

interface Vegetable {
    void hasARoot();
}

class Tomato implements Fruit, Vegetable {
    @Override
    public void hasAPeel() {
        System.out.println("Tomato is a fruit and may have a peel.");
    }

    @Override
    public void hasARoot() {
        System.out.println("Tomato is also considered a vegetable and has a root.");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiating an object of Tomato
        Tomato tomato = new Tomato();

        // Displaying details
        System.out.println("Details of Tomato:");
        tomato.hasAPeel();
        tomato.hasARoot();

        // Close the scanner
        scanner.close();
    }
}
