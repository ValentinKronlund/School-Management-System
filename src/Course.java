import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable
{
    private String name;
    private String description;
    private String subject;

    //date format: 2000-12-30
    private LocalDate startDate;
    private LocalDate endDate;

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Course(String name, String description, String subject, LocalDate startDate, LocalDate endDate, List<Student> students, List<Teacher> teachers) {
        this.name = name;
        this.description = description;
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.teachers = teachers;
    }
    public Course(String name, String description, String subject, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
    } //for constructing without list provision

    public String getName(){return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public List<Student> getStudents() {return students;}
    public void AddStudent(Student student){
        this.students.add(student);
        student.AddCourse(this);
    }
    public void RemoveStudent(Student student){students.remove(student);}

    public List<Teacher> getTeachers() {return teachers;}
    public void AddTeacher(Teacher teacher){
        this.teachers.add(teacher);
        teacher.AddCourse(this);
    }
    public void RemoveTeacher(Teacher teacher){teachers.remove(teacher);}

    @Override
    public String toString(){
        return "[Course]: %s \n[Desc.]: %s \n[Subject]: %s \n[Start]: %s, \n[End]: %s\n".formatted(name, description, subject, startDate, endDate);
    }
}
