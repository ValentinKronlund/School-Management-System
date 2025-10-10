import helpers.Helpers;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolManager implements Runnable, Serializable
{
    private static SchoolManager instance;
    private SchoolManager(){}

    public static SchoolManager GetInstance(){
        if(instance == null){instance = new SchoolManager();}
        return instance;
    }


    private final ArrayList<Course> curriculum = Mock.GenerateMockCurriculum();
    private final ArrayList<Teacher> faculty = Mock.GenerateMockFaculty();
    private final ArrayList<Student> students = Mock.GenerateMockStudents();

    @Override
    public void run() {
        Helpers helper = new Helpers();
        System.out.println("Running School Manager...");


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

        System.out.println("""
                ----------------------------------\
                
                School Management System Interface\
                
                ----------------------------------\
                
                """
        );

        boolean programRunning = true;
        while(programRunning){
            System.out.println(
                    """
                            \nWhat would you like to do?
                            1: 📋 Display the curriculum!
                            2: 👩🏻‍🏫 Display the faculty members!
                            3: 🧑🏽‍🎓 Display enrolled students!
                            4: 📝 Display a dummy student's grades!
                            5: Save current files.
                            x: ❌ Exit the program.
                            
                            e: ✏️ Register student to a course.
                            """);
    
            char choice = helper.askChar("");

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
                case '5':{
                    SaveLoadSystem.save(this,LocalDate.now().toString());
                    continue;
                }
                case 'e':{
                    enrollStudent(helper, curriculum, students);
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

    private void enrollStudent(Helpers helper, ArrayList<Course> curriculum, ArrayList<Student> students){
        System.out.println("What student are you looking to enroll?");
        students.forEach(System.out::println);
        Student searchedStudent = null;
        Course searchedCourse = null;

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

        if(foundStudent){
            System.out.println("What course would you like to register for?\n");
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
        }

        searchedStudent.AddCourse(searchedCourse);
        searchedCourse.AddStudent(searchedStudent);

        System.out.println("\n✅ Student: %s %s, has registered for: ".formatted(searchedStudent.getFirstName(), searchedStudent.getSurname(), searchedCourse.getName()));
    }
}
