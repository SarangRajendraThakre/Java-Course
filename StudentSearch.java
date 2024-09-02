import java.util.ArrayList;
import java.util.Scanner;

class Student {
 int rollNo;
 String name;
 String address;
 double percentage;

   public Student(int rollNo,String name,String address,double percentage)
   {
    this.rollNo = rollNo;
    this.name = name;
    this.address= address;
    this.percentage=percentage;
   }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + "\nName: " + name + "\nAddress: " + address + "\nPercentage: " + percentage;
    }
}

public class StudentSearch {
  public static void main(String[] args) {
    
           Scanner scanner = new Scanner(System.in);
           ArrayList<Student> students = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
       int rollNo = scanner.nextInt();
    
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
          String address = scanner.nextLine();
            System.out.print("Percentage: ");
            double percentage = scanner.nextDouble();
            scanner.nextLine(); 

       students.add(new Student(rollNo, name, address, percentage));
        }

        // Search for a student by roll number
        System.out.print("Enter roll number to search: ");
        int searchRollNo = scanner.nextInt();

        boolean found = false;
        for (Student student : students) {
            if (student.rollNo == searchRollNo) {
                System.out.println("\nStudent details:");
                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with roll number " + searchRollNo + ".");
          
        }

        scanner.close();
    }
}
