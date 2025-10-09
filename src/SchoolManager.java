import helpers.Helpers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManager implements Runnable
{
    private static SchoolManager instance;
    private SchoolManager(){}
    private Scanner input = new Scanner(System.in);
    private Helpers helper = new Helpers();

    public static SchoolManager GetInstance(){
        if(instance == null){instance = new SchoolManager();}
        return instance;
    }

    @Override
    public void run() {
        System.out.println("Running School Manager...");

        ArrayList<Course> curriculum = Mock.GenerateMockCurriculum();
        ArrayList<Teacher> faculty = Mock.GenerateMockFaculty();
        ArrayList<Student> students = Mock.GenerateMockStudents();

        //dummy/demo implement
        Course dummyCourse = new Course("Java", "Programming in Java", "OOP principles", LocalDate.of(2025,9,1),LocalDate.of(2026,10,30));
        Student dummyStudent = Student.builder().first_name("Adam").surname("Genesis").age(20).build();
        Teacher dummyTeacher = Teacher.builder().first_name("Eve").surname("Applebaum").age(37).build();
        dummyCourse.AddStudent(dummyStudent);
        dummyCourse.AddTeacher(dummyTeacher);

        System.out.println(dummyCourse.getName());
        System.out.println("teacher/s:");
        dummyCourse.getTeachers().forEach(System.out::println);

        System.out.println("students:");
        dummyCourse.getStudents().forEach(System.out::println);
        dummyCourse.getStudents().forEach((s) -> {
            s.AddCourse(dummyCourse);
            s.AddGrade(dummyCourse, Grade.Score.B);
            s.printGrades();
        });

        System.out.println("----------------------------------"
                            +"\nSchool Management System Interface"
                            +"\n----------------------------------"
                            +"\n"
        );

        Boolean programRunning = true;
        while(programRunning){
            System.out.println(
                "What would you like to do?\n"
                        + "1: 📋 Display the curriculum!\n"
                        + "2: 👩🏻‍🏫 Display the faculty members!\n"
                        + "3: 🧑🏽‍🎓 Display enrolled students!\n"
                        + "4: 📝 Display a student's grades!\n"
                        + "x: ❌ Exit the program.");
    
            char choice = helper.askChar(input, "");

            switch(choice){
                case '1': {
                    curriculum.forEach(System.out::println);
                    continue;
                }
                case '2': {
                    faculty.forEach(System.out::println);
                    continue;
                }
                case '3': {
                    students.forEach(System.out::println);
                    continue;
                }
                case '4': {
                    dummyStudent.printGrades();
                    continue;
                }
                case 'x': {
                    programRunning = false;
                    break;
                }
                default: {
                    System.out.println("There is no such option -- Try again!");
                }
            }

        }
    }
}
