import java.util.Scanner;

class Automobile {
    private String make;
    private String type;
    private int maxSpeed;
    private double price;
    private double mileage;
    private String registrationNumber;

    // Constructors
    public Automobile() {
    }

    public Automobile(String make, String type, int maxSpeed, double price, double mileage, String registrationNumber) {
        this.make = make;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.mileage = mileage;
        this.registrationNumber = registrationNumber;
    }

    // Accessor and modifier methods
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}

class Truck extends Automobile {
    private int capacity;
    private String hoodType;
    private int noOfWheels;

    // Constructors
    public Truck() {
    }

    public Truck(String make, String type, int maxSpeed, double price, double mileage, String registrationNumber,
                 int capacity, String hoodType, int noOfWheels) {
        super(make, type, maxSpeed, price, mileage, registrationNumber);
        this.capacity = capacity;
        this.hoodType = hoodType;
        this.noOfWheels = noOfWheels;
    }

    // Accessor and modifier methods
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHoodType() {
        return hoodType;
    }

    public void setHoodType(String hoodType) {
        this.hoodType = hoodType;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }
}

class Car extends Automobile {
    private int noOfDoors;
    private int seatingCapacity;

    // Constructors
    public Car() {
    }

    public Car(String make, String type, int maxSpeed, double price, double mileage, String registrationNumber,
               int noOfDoors, int seatingCapacity) {
        super(make, type, maxSpeed, price, mileage, registrationNumber);
        this.noOfDoors = noOfDoors;
        this.seatingCapacity = seatingCapacity;
    }

    // Accessor and modifier methods
    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Truck object
        System.out.println("Enter details for Truck:");
        Truck truck = new Truck();
        enterAutomobileDetails(scanner, truck);
        System.out.print("Enter capacity: ");
        truck.setCapacity(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character left by previous nextInt()
        System.out.print("Enter hood type: ");
        truck.setHoodType(scanner.nextLine());
        System.out.print("Enter number of wheels: ");
        truck.setNoOfWheels(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character left by previous nextInt()

        // Create a Car object
        System.out.println("\nEnter details for Car:");
        Car car = new Car();
        enterAutomobileDetails(scanner, car);
        System.out.print("Enter number of doors: ");
        car.setNoOfDoors(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character left by previous nextInt()
        System.out.print("Enter seating capacity: ");
        car.setSeatingCapacity(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character left by previous nextInt()

        // Display details
        System.out.println("\nDetails for Truck:");
        displayAutomobileDetails(truck);

        System.out.println("\nDetails for Car:");
        displayAutomobileDetails(car);

        scanner.close();
    }

    private static void enterAutomobileDetails(Scanner scanner, Automobile automobile) {
        System.out.print("Enter make: ");
        automobile.setMake(scanner.nextLine());
        System.out.print("Enter type: ");
        automobile.setType(scanner.nextLine());
        System.out.print("Enter max speed: ");
        automobile.setMaxSpeed(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character left by previous nextInt()
        System.out.print("Enter price: ");
        automobile.setPrice(scanner.nextDouble());
        scanner.nextLine(); // Consume the newline character left by previous nextDouble()
        System.out.print("Enter mileage: ");
        automobile.setMileage(scanner.nextDouble());
        scanner.nextLine(); // Consume the newline character left by previous nextDouble()
        System.out.print("Enter registration number: ");
        automobile.setRegistrationNumber(scanner.nextLine());
    }

    private static void displayAutomobileDetails(Automobile automobile) {
        System.out.println("Make: " + automobile.getMake());
        System.out.println("Type: " + automobile.getType());
        System.out.println("Max Speed: " + automobile.getMaxSpeed());
        System.out.println("Price: " + automobile.getPrice());
        System.out.println("Mileage: " + automobile.getMileage());
        System.out.println("Registration Number: " + automobile.getRegistrationNumber());

        if (automobile instanceof Truck) {
            Truck truck = (Truck) automobile;
            System.out.println("Capacity: " + truck.getCapacity());
            System.out.println("Hood Type: " + truck.getHoodType());
            System.out.println("Number of Wheels: " + truck.getNoOfWheels());
        } else if (automobile instanceof Car) {
            Car car = (Car) automobile;
            System.out.println("Number of Doors: " + car.getNoOfDoors());
            System.out.println("Seating Capacity: " + car.getSeatingCapacity());
        }

        System.out.println();
    }
}