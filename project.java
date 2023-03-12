import java.util.Scanner;

class Hostel {
    private String hostelName;
    private int numberOfRooms;
    private double roomPrice;

    public Hostel(String hostelName, int numberOfRooms, double roomPrice) {
        this.hostelName = hostelName;
        this.numberOfRooms = numberOfRooms;
        this.roomPrice = roomPrice;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public double calculateBill(int numberOfDays) {
        return numberOfDays * roomPrice;
    }
}

class Student {
    private String studentName;
    private String studentID;
    private int numberOfDays;
    private Hostel hostel;

    public Student(String studentName, String studentID, int numberOfDays, Hostel hostel) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.numberOfDays = numberOfDays;
        this.hostel = hostel;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public double calculateBill() {
        return hostel.calculateBill(numberOfDays);
    }

    public String toString() {
        return "Student Name: " + studentName + ", Student ID: " + studentID + ", Hostel: " + hostel.getHostelName() + ", Number of Days: " + numberOfDays + ", Bill: Rs." + calculateBill();
    }
}
// all the methods or class

public class project {
    public static void main(String[] args) {
        Hostel hostel1 = new Hostel("Hostel A", 10, 50.0);
        Hostel hostel2 = new Hostel("Hostel B", 20, 70.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter the number of days you want to spend in hostel : ");
        int numberOfDays = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter hostel name (BH or GH): ");
        String hostelName = scanner.nextLine();

        Hostel hostel = null;
        if (hostelName.equalsIgnoreCase("A")) {
            hostel = hostel1;
        } else if (hostelName.equalsIgnoreCase("B")) {
            hostel = hostel2;
        } else {
            System.out.println("Invalid hostel name");
            System.exit(0);
        }

        Student student = new Student(studentName, studentID, numberOfDays, hostel);
        System.out.println(student.toString());
    }
}

//This is just a sample code that we wrote in small time .Further changes will be done after our mid term.
