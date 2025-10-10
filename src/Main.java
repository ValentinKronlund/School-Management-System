import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) {

        System.out.println("press 1 to load data or any other button to continue");
        Scanner sc = new Scanner(System.in);
        if(sc.nextInt() == 1) {
            Objects.requireNonNull(SaveLoadSystem.load()).run();
        }
        else{
        SchoolManager manager = SchoolManager.GetInstance();
        manager.run();}
    }
}