import helpers.Helpers;

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

}
