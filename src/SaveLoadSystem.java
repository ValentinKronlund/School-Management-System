import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.*;
public class SaveLoadSystem
{

    public static void save(SchoolManager manager, String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename + ".dat"))){
            out.writeObject(manager);
            System.out.println("SchoolManager saved as " + filename);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong while saving " + filename);
        }
    }

    public static SchoolManager load(){
        System.out.println("load what?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(input))){
            return (SchoolManager) in.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong while loading " + input);
            return null;
        }
    }
}
