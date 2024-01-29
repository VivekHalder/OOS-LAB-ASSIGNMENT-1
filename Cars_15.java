import java.util.Scanner;

class Tollbooth {
    private int carsWithoutPaying;
    private int totalCars;
    private int totalCashCollected;

    public Tollbooth() {
        carsWithoutPaying = 0;
        totalCars = 0;
        totalCashCollected = 0;
    }

    public void carPasses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Car passed by. Did the car pay toll tax? (Enter 'yes' or 'no'): ");
        String paymentStatus = scanner.nextLine().toLowerCase();

        if (paymentStatus.equals("yes")) {
            collectToll();
        } else {
            carsWithoutPaying++;
        }

        totalCars++;
        
        // Close the Scanner object after reading input
        scanner.close();
    }

    private void collectToll() {
        System.out.println("Car paid Rs. 50 toll tax.");
        totalCashCollected += 50;
    }

    public void displayResults() {
        System.out.println("\nResults:");
        System.out.println("Total number of cars passed by without paying: " + carsWithoutPaying);
        System.out.println("Total number of cars passed by: " + totalCars);
        System.out.println("Total cash collected: Rs. " + totalCashCollected);
    }
}

class Main {
    public static void main(String[] args) {
        Tollbooth tollbooth = new Tollbooth();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cars passing by the toll booth: ");
        int numberOfCars = scanner.nextInt();

        for (int i = 0; i < numberOfCars; i++) {
            System.out.println("\nCar #" + (i + 1));
            tollbooth.carPasses();
        }

        tollbooth.displayResults();

        // Close the Scanner object after reading the number of cars
        scanner.close();
    }
}