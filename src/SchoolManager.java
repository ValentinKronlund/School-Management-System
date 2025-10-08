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
    }
}
