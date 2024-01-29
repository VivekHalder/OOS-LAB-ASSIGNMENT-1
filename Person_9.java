import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Person {
    private int age;
    private double weight;
    private double height;
    private Date dateOfBirth;
    private String address;

    public Person(int age, double weight, double height, Date dateOfBirth, String address) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    // Accessor and modifier methods for data members
    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }
}

class Employee extends Person {
    private double salary;
    private Date dateOfJoining;
    private int experience;

    public Employee(int age, double weight, double height, Date dateOfBirth, String address,
                    double salary, Date dateOfJoining, int experience) {
        super(age, weight, height, dateOfBirth, address);
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;
    }

    // Accessor and modifier methods for additional data members
    public double getSalary() {
        return salary;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public int getExperience() {
        return experience;
    }
}

class Student extends Person {
    private int roll;
    private ArrayList<String> listOfSubjects;
    private ArrayList<Integer> marks;

    public Student(int age, double weight, double height, Date dateOfBirth, String address,
                   int roll, ArrayList<String> listOfSubjects, ArrayList<Integer> marks) {
        super(age, weight, height, dateOfBirth, address);
        this.roll = roll;
        this.listOfSubjects = listOfSubjects;
        this.marks = marks;
    }

    // Accessor and modifier methods for additional data members
    public int getRoll() {
        return roll;
    }

    public ArrayList<String> getListOfSubjects() {
        return listOfSubjects;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    // Method to calculate grade
    public void calculateGrade() {
        // Your implementation for calculating grade based on marks goes here
        // This can vary based on your grading system
        System.out.println("Grade calculated for Student with Roll Number " + roll);
    }
}

class Technician extends Employee {
    public Technician(int age, double weight, double height, Date dateOfBirth, String address,
                      double salary, Date dateOfJoining, int experience) {
        super(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);
    }
}

class Professor extends Employee {
    private ArrayList<String> courses;
    private ArrayList<String> listOfAdvisee;

    public Professor(int age, double weight, double height, Date dateOfBirth, String address,
                     double salary, Date dateOfJoining, int experience,
                     ArrayList<String> courses, ArrayList<String> listOfAdvisee) {
        super(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);
        this.courses = courses;
        this.listOfAdvisee = listOfAdvisee;
    }

    // Add and remove methods for additional data members
    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public void addAdvisee(String advisee) {
        listOfAdvisee.add(advisee);
    }

    public void removeAdvisee(String advisee) {
        listOfAdvisee.remove(advisee);
    }

    public ArrayList<String> getListOfAdvisee() {
        return listOfAdvisee;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }
    
    
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Person
        System.out.println("Enter details for Person:");
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Height: ");
        double height = scanner.nextDouble();
        // You can handle date input according to your specific requirements
        Date dateOfBirth = new Date();
        System.out.print("Address: ");
        scanner.nextLine(); // Consume the newline character left by previous nextDouble()
        String address = scanner.nextLine();

        Person person = new Person(age, weight, height, dateOfBirth, address);

        // Input for Employee
        System.out.println("Enter details for Employee:");
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        // You can handle date input according to your specific requirements
        Date dateOfJoining = new Date();
        System.out.print("Experience: ");
        int experience = scanner.nextInt();

        Employee employee = new Employee(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);

        // Input for Student
        System.out.println("Enter details for Student:");
        System.out.print("Roll: ");
        int roll = scanner.nextInt();
        System.out.print("Number of subjects: ");
        int numSubjects = scanner.nextInt();
        ArrayList<String> subjects = new ArrayList<>();
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter subject " + i + ": ");
            subjects.add(scanner.next());
        }
        ArrayList<Integer> marks = new ArrayList<>();
        for (String subject : subjects) {
            System.out.print("Enter marks for " + subject + ": ");
            marks.add(scanner.nextInt());
        }

        Student student = new Student(age, weight, height, dateOfBirth, address, roll, subjects, marks);

        // Input for Technician
        System.out.println("Enter details for Technician:");
        // Additional details for Technician can be added as needed

        Technician technician = new Technician(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);

        // Input for Professor
        System.out.println("Enter details for Professor:");
        // Additional details for Professor can be added as needed

        Professor professor = new Professor(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience,
                new ArrayList<>(), new ArrayList<>());

        // Demonstrate method calls
        student.calculateGrade();

        professor.addCourse("Chemistry");
        professor.addAdvisee("Alice Johnson");

        // Display details
        System.out.println("Details:");
        displayDetails(person);
        displayDetails(employee);
        displayDetails(student);
        displayDetails(technician);
        displayDetails(professor);

        // Close the scanner
        scanner.close();
    }

    private static void displayDetails(Person person) {
        System.out.println("Details for " + person.getClass().getSimpleName() + ":");
        System.out.println("Age: " + person.getAge());
        System.out.println("Weight: " + person.getWeight());
        System.out.println("Height: " + person.getHeight());
        System.out.println("Date of Birth: " + person.getDateOfBirth());
        System.out.println("Address: " + person.getAddress());
        System.out.println();
    }

    private static void displayDetails(Employee employee) {
        displayDetails((Person) employee);
        System.out.println("Additional details for Employee:");
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Date of Joining: " + employee.getDateOfJoining());
        System.out.println("Experience: " + employee.getExperience());
        System.out.println();
    }

    private static void displayDetails(Student student) {
        displayDetails((Person) student);
        System.out.println("Additional details for Student:");
        System.out.println("Roll: " + student.getRoll());
        System.out.println("Subjects: " + student.getListOfSubjects());
        System.out.println("Marks: " + student.getMarks());
        System.out.println();
    }

    private static void displayDetails(Technician technician) {
        displayDetails((Employee) technician);
        System.out.println("Additional details for Technician:");
        System.out.println();
    }

    private static void displayDetails(Professor professor) {
        displayDetails((Employee) professor);
        System.out.println("Additional details for Professor:");
        System.out.println("Courses: " + professor.getCourses());
        System.out.println("Advisee: " + professor.getListOfAdvisee());
        System.out.println();
    }
}