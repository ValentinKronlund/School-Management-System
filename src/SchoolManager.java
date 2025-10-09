import java.time.LocalDate;

public class SchoolManager implements Runnable
{
    private static SchoolManager instance;
    private SchoolManager(){}

    public static SchoolManager GetInstance(){
        if(instance == null){instance = new SchoolManager();}
        return instance;
    }

    @Override
    public void run() {
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
    }
}
