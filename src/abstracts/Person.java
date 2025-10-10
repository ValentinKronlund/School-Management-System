package abstracts;

import java.io.Serializable;

public abstract class Person implements Serializable
{
    String first_name;
    String surname;
    int age;
    Role role;

    public enum Role{
        Student, Teacher, Principal;
    
        @Override
        public String toString(){
            return name();
        }
    }

    public Person(String first_name, String surname, int age, Role role){
        this.first_name = first_name;
        this.surname = surname;
        this.age = age;
        this.role = role;
    }

    public String getFirstName(){return first_name;}
    public String getSurname(){return surname;}
    public String getFullName(){return "%s %s".formatted(first_name, surname);}

    @Override
    public String toString(){
        return "%s %s, is a %d year old %s".formatted(first_name, surname, age, role);
    }
    
}
