import java.util.Scanner;

class Student {
    String name;
    String rollno;
    String roomno;
    String course;

    public Student(String name, String rollno, String roomno, String course) {
        this.name = name;
        this.rollno = rollno;
        this.roomno = roomno;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getRollno() {
        return rollno;
    }

    public String getRoomno() {
        return roomno;
    }

    public String getCourse() {
        return course;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }
}

class Hostel {
    Student[] students;
    int numStudents;
    int numRooms;
    int[] rooms;

    public Hostel(int numStudents, int numRooms) {
        this.numStudents = numStudents;
        this.numRooms = numRooms;
        this.rooms = new int[numRooms];
        this.students = new Student[numStudents];
    }

    public void addStudent(Student s) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i] == null) {
                students[i] = s;
                System.out.println("Student " + s.getName() + " has been added to the system.");
                break;
            }
        }
    }

    public void allocateRoom() {
        int count = 0;
        for (int i = 0; i < numRooms; i++) {
            if (rooms[i] == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Sorry, there are no rooms available at the moment.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the roll number of the student you want to allocate a room to: ");
        String rollno = sc.nextLine();
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getRollno().equals(rollno)) {
                for (int j = 0; j < numRooms; j++) {
                    if (rooms[j] == 0) {
                        rooms[j] = 1;
                        students[i].setRoomno(Integer.toString(j+1));
                        System.out.println("Room " + (j+1) + " has been allocated to " + students[i].getName() + ".");
                        return;
                    }
                }
            }
        }
        System.out.println("Sorry, the student with roll number " + rollno + " is not registered.");
    }

    public void viewStudentDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the roll number of the student: ");
        String rollno = sc.nextLine();
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getRollno().equals(rollno)) {
                System.out.println("Name: " + students[i].getName());
                System.out.println("Roll number: " + students[i].getRollno());
                System.out.println("Course: " + students[i].getCourse());
                System.out.println("Room number: " + students[i].getRoomno());
                return;
            }
        }
        System.out.println("Sorry, the student with roll number " + rollno + " is not registered.");
    }
}

public class HostelManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int numStudents = sc.nextInt();
        System.out.println("Enter the number of rooms: ");
        int numRooms = sc.nextInt();
        Hostel hostel = new Hostel(numStudents, numRooms);
        while (true) {
            System.out.println("Enter 1 to add a student.");
            System.out.println("Enter 2 to allocate a room.");
            System.out.println("Enter 3 to view student details.");
            System.out.println("Enter 4 to exit.");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the student: ");
                    String name = sc.next();
                    System.out.println("Enter the roll number of the student: ");
                    String rollno = sc.next();
                    System.out.println("Enter the course of the student: ");
                    String course = sc.next();
                    Student s = new Student(name, rollno, null, course);
                    hostel.addStudent(s);
                    break;
                case 2:
                    hostel.allocateRoom();
                    break;
                case 3:
                    hostel.viewStudentDetails();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
