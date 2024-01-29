import java.util.Scanner;

// Interface for Shape
interface Shape {
    double area();
    void draw();
    void rotate();
    void move();
}

// Class for Circle implementing Shape interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println("Drawing a Circle");
    }

    public void rotate() {
        System.out.println("Rotating the Circle");
    }

    public void move() {
        System.out.println("Moving the Circle");
    }
}

// Class for Rectangle implementing Shape interface
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    public void rotate() {
        System.out.println("Rotating the Rectangle");
    }

    public void move() {
        System.out.println("Moving the Rectangle");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create two Circle objects
        System.out.println("Enter details for Circle 1:");
        Circle circle1 = createCircle(scanner);
        System.out.println("\nEnter details for Circle 2:");
        Circle circle2 = createCircle(scanner);

        // Create three Rectangle objects
        System.out.println("\nEnter details for Rectangle 1:");
        Rectangle rectangle1 = createRectangle(scanner);
        System.out.println("\nEnter details for Rectangle 2:");
        Rectangle rectangle2 = createRectangle(scanner);
        System.out.println("\nEnter details for Rectangle 3:");
        Rectangle rectangle3 = createRectangle(scanner);

        // Print details before moving
        System.out.println("\nDetails before moving:");

        printShapeDetails(circle1);
        printShapeDetails(circle2);
        printShapeDetails(rectangle1);
        printShapeDetails(rectangle2);
        printShapeDetails(rectangle3);

        // Move the shapes
        System.out.println("\nMoving the shapes:");

        moveShape(circle1);
        moveShape(circle2);
        moveShape(rectangle1);
        moveShape(rectangle2);
        moveShape(rectangle3);

        // Print details after moving
        System.out.println("\nDetails after moving:");

        printShapeDetails(circle1);
        printShapeDetails(circle2);
        printShapeDetails(rectangle1);
        printShapeDetails(rectangle2);
        printShapeDetails(rectangle3);

        scanner.close();
    }

    private static Circle createCircle(Scanner scanner) {
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left by previous nextDouble()
        return new Circle(radius);
    }

    private static Rectangle createRectangle(Scanner scanner) {
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left by previous nextDouble()
        return new Rectangle(length, width);
    }

    private static void moveShape(Shape shape) {
        shape.move();
    }

    private static void printShapeDetails(Shape shape) {
        System.out.println("Shape details:");
        shape.draw();
        System.out.println("Area: " + shape.area());
        shape.rotate();
        System.out.println();
    }
}
