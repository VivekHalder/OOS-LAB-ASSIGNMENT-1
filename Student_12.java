import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private String[] subjects;

    // Constructor
    public Student(String name, int rollNo, String[] subjects) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = subjects;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}

class TabulationSheet {
    private int[] rollNumbers;
    private int[] marks;

    // Constructor
    public TabulationSheet(int numOfStudents) {
        rollNumbers = new int[numOfStudents];
        marks = new int[numOfStudents];
    }

    // Method to add marks and roll number of a student
    public void addStudentMark(int rollNo, int mark) {
        for (int i = 0; i < rollNumbers.length; i++) {
            if (rollNumbers[i] == 0) {
                rollNumbers[i] = rollNo;
                marks[i] = mark;
                break;
            }
        }
    }

    // Getter method for roll numbers
    public int[] getRollNumbers() {
        return rollNumbers;
    }

    // Print tabulation sheet
    public void printTabulationSheet() {
        System.out.println("Tabulation Sheet:");
        for (int i = 0; i < rollNumbers.length && rollNumbers[i] != 0; i++) {
            System.out.println("Roll No: " + rollNumbers[i] + ", Marks: " + marks[i]);
        }
    }
}

class MarkSheet {
    private String studentName;
    private int[] marks;

    // Constructor
    public MarkSheet(String studentName, int numOfSubjects) {
        this.studentName = studentName;
        marks = new int[numOfSubjects];
    }

    // Method to add name of a student and marks in each subject
    public void addStudentMarks(int[] studentMarks) {
        System.arraycopy(studentMarks, 0, marks, 0, marks.length);
    }

    // Print mark sheet
    public void printMarkSheet() {
        System.out.println("Mark Sheet for " + studentName + ":");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create three Student objects
        Student student1 = createStudent(scanner, 1);
        Student student2 = createStudent(scanner, 2);
        Student student3 = createStudent(scanner, 3);

        // Create five TabulationSheet objects for five subjects
        TabulationSheet tabulationSheet1 = new TabulationSheet(3);
        TabulationSheet tabulationSheet2 = new TabulationSheet(3);
        TabulationSheet tabulationSheet3 = new TabulationSheet(3);
        TabulationSheet tabulationSheet4 = new TabulationSheet(3);
        TabulationSheet tabulationSheet5 = new TabulationSheet(3);

        // Add marks and roll numbers to TabulationSheet objects
        addStudentMarksAndRollNumbers(scanner, tabulationSheet1, "Subject1");
        addStudentMarksAndRollNumbers(scanner, tabulationSheet2, "Subject2");
        addStudentMarksAndRollNumbers(scanner, tabulationSheet3, "Subject3");
        addStudentMarksAndRollNumbers(scanner, tabulationSheet4, "Subject4");
        addStudentMarksAndRollNumbers(scanner, tabulationSheet5, "Subject5");

        // Create three MarkSheet objects for three students
        MarkSheet markSheet1 = createMarkSheet(scanner, student1.getName(), student1.getSubjects());
        MarkSheet markSheet2 = createMarkSheet(scanner, student2.getName(), student2.getSubjects());
        MarkSheet markSheet3 = createMarkSheet(scanner, student3.getName(), student3.getSubjects());

        // Print mark sheets
        markSheet1.printMarkSheet();
        markSheet2.printMarkSheet();
        markSheet3.printMarkSheet();

        // Print tabulation sheets
        tabulationSheet1.printTabulationSheet();
        tabulationSheet2.printTabulationSheet();
        tabulationSheet3.printTabulationSheet();
        tabulationSheet4.printTabulationSheet();
        tabulationSheet5.printTabulationSheet();

        scanner.close();
    }

    private static Student createStudent(Scanner scanner, int studentNumber) {
        System.out.println("Enter details for Student " + studentNumber + ":");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by previous nextInt()

        String[] subjects = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
        }

        return new Student(name, rollNo, subjects);
    }

    private static void addStudentMarksAndRollNumbers(Scanner scanner, TabulationSheet tabulationSheet, String subjectName) {
        System.out.println("Enter marks for " + subjectName + ":");
        int[] studentMarks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for Roll No " + (i + 1) + ": ");
            studentMarks[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume the newline character left by previous nextInt()

        tabulationSheet.addStudentMark(1, studentMarks[0]);
        tabulationSheet.addStudentMark(2, studentMarks[1]);
        tabulationSheet.addStudentMark(3, studentMarks[2]);
    }

    private static MarkSheet createMarkSheet(Scanner scanner, String studentName, String[] subjects) {
        MarkSheet markSheet = new MarkSheet(studentName, subjects.length);

        System.out.println("Enter marks for " + studentName + ":");
        int[] studentMarks = new int[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            studentMarks[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume the newline character left by previous nextInt()

        markSheet.addStudentMarks(studentMarks);
        return markSheet;
    }
}