import abstracts.Person;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable
{
    ArrayList<Course> courses = new ArrayList<>();

    private Teacher(Builder builder){
        super(builder.first_name, builder.surname, builder.age, Person.Role.Teacher);
    }

     public static Builder builder(){
        return new Builder();
    }


    //DUMMY CLASS, REPLACE/GROW FOR IMPLEMENTATION
    public void AddCourse(Course course){}

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

        public Teacher build(){
            if(first_name == null || first_name.isBlank()){throw new IllegalStateException("⚠️ First name must be provided.");}
            if(surname == null || surname.isBlank()){throw new IllegalStateException("⚠️ Surname must be provided.");}
            if(age <= 0 || age >= 130){throw new IllegalStateException("⚠️ Age must be a valid number between 0 - 130.");}

            return new Teacher(this);
        }
    }
}
