import helpers.Helpers;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentModification
{
    private static StudentModification instance;
    private StudentModification(){}

    public static StudentModification GetInstance(){
        if(instance == null){instance = new StudentModification();}
        return instance;
    }

    public Student makeNewStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("New student adding started. ");
        Helpers help = new Helpers();

        return Student.builder()
                .first_name(help.askLine("First name?"))
                .surname(help.askLine("Surname?"))
                .age(help.askInt("Age?"))
                .build();

    }

    public void RemoveStudent(ArrayList<Student> students){
        System.out.println("who are you trying to remove? ");
        Student targStudent = studentSearch(students);
        students.remove(targStudent);
    }

    public void registerStudentCourse(Helpers helper, ArrayList<Course> curriculum, ArrayList<Student> students){
        System.out.println("What student are you looking to enroll?");
        students.forEach(System.out::println);

        Student searchedStudent = studentSearch(helper, students);
        if(searchedStudent != null){
            Course searchedCourse = courseSearch(helper,curriculum);
            searchedStudent.AddCourse(searchedCourse);
            searchedCourse.AddStudent(searchedStudent);
            System.out.println("\n✅ Student: %s %s, has registered for: ".formatted(searchedStudent.getFirstName(), searchedStudent.getSurname(), searchedCourse.getName()));
        }
    }

    private Student studentSearch( ArrayList<Student> students){
        Helpers helper = new Helpers();
        Student searchedStudent = null;
        boolean foundStudent = false;
        while(!foundStudent){
            String[] choice = helper.askLine("Enter the student's full name, separate the first name and surname by a whitespace ' ':\n").toLowerCase().split("\\s+", 2);

            for(Student student : students){
                String sFirstName = student.getFirstName().toLowerCase();
                String sSurname = student.getSurname().toLowerCase();
                if(sFirstName.equals(choice[0]) && sSurname.equals(choice[1])
                ){
                    System.out.println("\nYou have selected student: %s %s\n".formatted(sFirstName, sSurname));
                    foundStudent = true;
                    searchedStudent = student;
                    break;
                }
            }
            if(searchedStudent == null){
                System.out.println("There doesn't seem to be a student with the name of: %s %s \n".formatted(choice[0], choice[1]));
            }
        }
        return searchedStudent;
    }

    private Course courseSearch(ArrayList<Course> curriculum){
        Helpers helper = new Helpers();
        System.out.println("What course would you like to register for?\n");
        Course searchedCourse = null;
        curriculum.forEach(System.out::println);
        boolean foundCourse = false;
        while(!foundCourse){
            String choice = helper.askLine("Enter the course's name: ").toLowerCase();

            for(Course course : curriculum){
                if(course.getName().toLowerCase().equals(choice)){
                    System.out.println("You have selected the course: %s".formatted(course.getName()));
                    foundCourse = true;
                    searchedCourse = course;
                    break;
                }
            }
            if(searchedCourse == null){
                System.out.println("There doesn't seem to be a course with the name of: %s".formatted(choice));
            }
        }
        return searchedCourse;
    }
}
