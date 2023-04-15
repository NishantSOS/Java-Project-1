import java.util.Scanner;
import java.util.InputMismatchException;
class Student{
    String name;
    String roll_number;
    String room_number;
    String course;

    public Student(String name , String roll_number , String room_number , String course){
        this.name = name;
        this.roll_number = roll_number;
        this.room_number =room_number;
        this.course=course;
    }
    public String getName(){
        return name;
    }
    public String getRoll_number(){
        return roll_number;
    }
    public String getRoom_number(){
        return room_number;
    }
    public String getCourse(){
        return course;
    }
    
    public void setRoom_number(String room_number){
        this.room_number = room_number;
    }

}

class Hostel{
    Student[] students; 
    int Students_num;
    int Rooms_num;
    int[] rooms;

    public Hostel(int Students_num , int Rooms_num){
        this.Students_num=Students_num;
        this.Rooms_num=Rooms_num;
        this.rooms=new int[Rooms_num];
        this.students=new Student[Students_num];
    }

    //1st method
    public void Add_Student(Student s){
        for(int i=0; i<Students_num;i++){
            if(students[i]==null){
                students[i]=s;
                System.out.println("Student "+ s.getName() + " has been added to the system.");
                break;
            }
        }
    }
    
    //2nd method
    public void Room_Allocation(){
        int count = 0 ;
        for(int i=0; i<Rooms_num;i++){
            if(rooms[i]==0){
                count++;
            }
        }
        if(count==0){
            System.out.println("There are no rooms available, Have a nice day!");
            return;
        }
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the roll number of the student who is ready to choose the room : ");
        String roll_number = s.nextLine();
        for(int i=0 ; i<Students_num;i++){
            if(students[i].getRoll_number().equals(roll_number)){
                for(int j=0; j<Rooms_num;j++){
                    if(rooms[j]==0){
                        rooms[j]=1;
                        students[i].setRoom_number(Integer.toString(j+1));
                        System.out.println("Congrats room number " + (j+1) + " has been allocated to "+ students[i].getName());
                        return;
                    }
                }
            }
        }
        System.out.println("Sorry the student wiht roll number "+roll_number+ " is not registered.");

    }


    //3rd method
    public void Student_Details(){
        Scanner s= new Scanner(System.in);
        System.out.println("Please, enter the roll number of the student: ");
        String roll_number =s.nextLine();
        for(int i=0; i<Students_num;i++){
            if(students[i].getRoll_number().equals(roll_number)){
                System.out.println("Name : "+ students[i].getName());
                System.out.println("Roll-Number :"+ students[i].getRoll_number());
                System.out.println("Room-Number :"+ students[i].getRoom_number());
                System.out.println("Course :" + students[i].getCourse());
                return;
            }
        }
        System.out.println("Please look again, the student with the roll number "+roll_number+ " is not been registered.");
    }




}

public class HMS{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int Students_num = 0;
        int Rooms_num = 0;
        try {
            System.out.println("Enter total number of students: ");
            Students_num = s.nextInt();
            s.nextLine(); // consume leftover newline character
            System.out.println("Enter the number of available rooms: ");
            Rooms_num = s.nextInt();
            s.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer value.");
            System.exit(0);
        }
        Hostel hostel=new Hostel(Students_num,Rooms_num);
        while(true){
            System.out.println("Enter 1 to add a student");
            System.out.println("Enter 2 to allocate a room");
            System.out.println("Enter 3 to view student details");
            System.out.println("Enter 4 to exit");
            int choice =s.nextInt();
            switch(choice){
                case 1:
                System.out.println("Enter the name of the student: ");
                String name =s.next();
                System.out.println("Enter the roll number of the student : ");
                String roll_number=s.next();
                System.out.println("Enter the enrolled course of the student :");
                String course = s.next();
                Student sm = new Student(name , roll_number , null , course);
                hostel.Add_Student(sm);
                break;
                case 2:
                hostel.Room_Allocation();
                break;
                case 3:
                hostel.Student_Details();
                break;
                case 4:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid input.");
            }
        }
    }
}
