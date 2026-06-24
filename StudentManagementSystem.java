import java.util.*;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while(true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1.Add Student");
            System.out.println("2.Display Student");
            System.out.println("3.Search student");
            System.out.println("4.Delete Student");
            System.out.println("5.update Student");
            System.out.println("6. Exit");
            System.out.println("Enter choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student s = new Student(id, name, marks);

                    students.add(s);

                    System.out.println("Student Added Successfully");
                    break;
                case 2:
                    System.out.println("Display Students");
                    if (students.isEmpty()) {
                        System.out.println("No student Available to show");
                        break;
                    } else {
                        for (int i = 0; i < students.size(); i++) {
                            students.get(i).display();
                        }

                    }
                    break;
                case 3:

                    if (students.isEmpty()) {
                        System.out.println("No Students Available");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    Student found = Student.search(students, searchId);

                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 4:

                    if (students.isEmpty()) {
                        System.out.println("No Students Available");
                        break;
                    }


                    System.out.print("Enter Student ID To Delete: ");
                    int deleteId = sc.nextInt();

                    Student.deletestudent(students, deleteId);

                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No Students Available for update");
                        break;
                    }
                    System.out.print("Enter Student ID To Update: ");
                    int updateId = sc.nextInt();
                    Student found1 = Student.search(students, updateId);
                    if(found1 != null){

                        sc.nextLine(); // buffer clear

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        found1.name = newName;
                        found1.mark = newMarks;

                        System.out.println("Student Updated Successfully");
                    }
                    else{
                        System.out.println("Student Not Found");
                    }

                    break;
                case 6:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }


    }
}

class Student{

    int id;
    String name;
    double mark;
    //constructor
    Student(int id , String name , double mark){
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    //display
    void display(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + mark);
    }
    //search
    static Student search(ArrayList<Student> students, int id){

        for(int i = 0; i < students.size(); i++){

            if(students.get(i).id == id){
                return students.get(i);
            }
        }

        return null;
    }


    //Delete
    static void deletestudent(ArrayList<Student> students, int id){

        if(students.isEmpty()){
            System.out.println("No student for deleted");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).id == id){
                students.remove(i);
                System.out.println("Student Deleted Successfully");
                return;
            }
        }
        System.out.println("Student not found");

    }
    //update student
    static void updateStudent(ArrayList<Student> students, int id,
                              String newName,
                              double newMarks){
        Student found = search(students, id);

        if(found != null){

            found.name = newName;
            found.mark = newMarks;

            System.out.println("Student Updated Successfully");
        }
        else{
            System.out.println("Student Not Found");
        }
    }
}
