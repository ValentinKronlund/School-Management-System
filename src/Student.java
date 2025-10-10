import abstracts.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person implements Serializable
{
    ArrayList<Course> courses = new ArrayList<>();
    Map<String, Grade> gradesByCourse = new HashMap<>();

    private Student(Builder builder){
        super(builder.first_name, builder.surname, builder.age, Person.Role.Student);
    }

    public static Builder builder(){
        return new Builder();
    }

    public void AddCourse(Course course){
        this.courses.add(course);
    }

    public void AddGrade(Course course, Grade.Score score){
        String cName = course.getName();
        String cSubject = course.getSubject();
        Grade grade = Grade.builder().courseName(cName).courseSubject(cSubject).score(score).build();
        this.gradesByCourse.put(cName, grade);
    }

    public Collection<Grade> getGrades(){
        return gradesByCourse.values();
    }

    public void printGrades(){
        gradesByCourse.values().forEach((g) -> {
            System.out.println(this.getFirstName() + " " + this.getSurname() + " " + g.toString());
        });
    }


    public static final class Builder{
        private String first_name;
        private String surname;
        private int age;

        private Builder(){}

        public Builder first_name(String name){
            this.first_name = name;
            return this;
        }
        public Builder surname(String name){
            this.surname = name;
            return this;
        }
        public Builder age(int age){
            this.age =age;
            return this;
        }

        public Student build(){
            if(first_name == null || first_name.isBlank()){throw new IllegalStateException("⚠️ First name must be provided.");}
            if(surname == null || surname.isBlank()){throw new IllegalStateException("⚠️ Surname must be provided.");}
            if(age <= 0 || age >= 130){throw new IllegalStateException("⚠️ Age must be a valid number between 0 - 130.");}

            return new Student(this);
        }
    }
}
