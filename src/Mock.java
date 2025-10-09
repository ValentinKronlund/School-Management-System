import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mock {

    private Mock(){}
    
    public static ArrayList<Course> GenerateMockCurriculum(){
        ArrayList<Map<String, String>> courses = new ArrayList<>();
        ArrayList<Course> mock = new ArrayList<>();

        HashMap<String, String> course1 = new HashMap<>();
        course1.put("name", "Introduction to Computer Science");
        course1.put("description", "Covers programming basics, algorithms, and computational thinking.");
        course1.put("subject", "Computer Science");
        course1.put("startDate", "2025-09-01");
        course1.put("endDate", "2025-12-15");
        courses.add(course1);

        HashMap<String, String> course2 = new HashMap<>();
        course2.put("name", "Principles of Microeconomics");
        course2.put("description", "Explores supply, demand, and market equilibrium fundamentals.");
        course2.put("subject", "Economics");
        course2.put("startDate", "2025-09-01");
        course2.put("endDate", "2025-12-15");
        courses.add(course2);

        HashMap<String, String> course3 = new HashMap<>();
        course3.put("name", "Modern European History");
        course3.put("description", "A survey of political and social developments from 1789 to the present.");
        course3.put("subject", "History");
        course3.put("startDate", "2025-09-01");
        course3.put("endDate", "2025-12-15");
        courses.add(course3);

        HashMap<String, String> course4 = new HashMap<>();
        course4.put("name", "Cognitive Psychology");
        course4.put("description", "Examines perception, memory, language, and problem solving.");
        course4.put("subject", "Psychology");
        course4.put("startDate", "2025-09-01");
        course4.put("endDate", "2025-12-15");
        courses.add(course4);

        HashMap<String, String> course5 = new HashMap<>();
        course5.put("name", "Environmental Sustainability");
        course5.put("description", "Studies the impact of human activity and strategies for a sustainable future.");
        course5.put("subject", "Environmental Science");
        course5.put("startDate", "2025-09-01");
        course5.put("endDate", "2025-12-15");
        courses.add(course5);

        HashMap<String, String> course6 = new HashMap<>();
        course6.put("name", "Creative Writing Workshop");
        course6.put("description", "Encourages storytelling, poetry, and fiction writing through peer feedback.");
        course6.put("subject", "Literature");
        course6.put("startDate", "2025-09-01");
        course6.put("endDate", "2025-12-15");
        courses.add(course6);

        HashMap<String, String> course7 = new HashMap<>();
        course7.put("name", "Fantasy Writing 101");
        course7.put("description", "Fantasy writing principles for storytelling, poetry, and fiction writing.");
        course7.put("subject", "Literature");
        course7.put("startDate", "2025-09-01");
        course7.put("endDate", "2025-12-15");
        courses.add(course7);

        HashMap<String, String> course8 = new HashMap<>();
        course8.put("name", "Raid Boss Tactics & Advanced Combat Rotation");
        course8.put("description", "Git gud so you don't get kicked from the guild!");
        course8.put("subject", "World of Warcraft");
        course8.put("startDate", "2025-09-01");
        course8.put("endDate", "2025-12-15");
        courses.add(course8);

        HashMap<String, String> course9 = new HashMap<>();
        course9.put("name", "Vampire Romance Stories, and Spicy Novellas");
        course9.put("description", "A very pale skin faculty member with dark makeup requested we add this to the curriculum ...");
        course9.put("subject", "Literature");
        course9.put("startDate", "2025-09-01");
        course9.put("endDate", "2025-12-15");
        courses.add(course9);

        for(Map<String, String> course : courses){
            mock.add(new Course(
                            course.get("name"),
                            course.get("description"),
                            course.get("subject"),
                            LocalDate.parse(course.get("startDate")), 
                            LocalDate.parse(course.get("endDate"))
                        )
                    );
        }

        return mock;
    }
    
    public static ArrayList<Teacher> GenerateMockFaculty(){
        ArrayList<HashMap<String, Object>> faculty = new ArrayList<>();
        ArrayList<Teacher> mock = new ArrayList<>();

        HashMap<String, Object> member1 = new HashMap<>();
        member1.put("name", "Eleanor");
        member1.put("surname", "Hartwell");
        member1.put("age", 52);
        faculty.add(member1);

        HashMap<String, Object> member2 = new HashMap<>();
        member2.put("name", "Marcus");
        member2.put("surname", "Linwood");
        member2.put("age", 44);
        faculty.add(member2);

        HashMap<String, Object> member3 = new HashMap<>();
        member3.put("name", "Selene");
        member3.put("surname", "Vargas");
        member3.put("age", 39);
        faculty.add(member3);

        HashMap<String, Object> member4 = new HashMap<>();
        member4.put("name", "Julian");
        member4.put("surname", "Kensley");
        member4.put("age", 58);
        faculty.add(member4);

        HashMap<String, Object> member5 = new HashMap<>();
        member5.put("name", "Amira");
        member5.put("surname", "D’Souza");
        member5.put("age", 47);
        faculty.add(member5);

        HashMap<String, Object> member6 = new HashMap<>();
        member6.put("name", "Tobias");
        member6.put("surname", "Grimm");
        member6.put("age", 61);
        faculty.add(member6);

        for (Map<String, Object> teacher : faculty){
            mock.add(Teacher.builder().first_name((String)teacher.get("name")).surname((String)teacher.get("surname")).age((int)teacher.get("age")).build());
        }

        return mock;
    }

    public static ArrayList<Student> GenerateMockStudents(){
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();
        ArrayList<Student> mock = new ArrayList<>();

        HashMap<String, Object> student1 = new HashMap<>();
        student1.put("name", "Lydia");
        student1.put("surname", "Morales");
        student1.put("age", 20);
        students.add(student1);

        HashMap<String, Object> student2 = new HashMap<>();
        student2.put("name", "Ethan");
        student2.put("surname", "Callahan");
        student2.put("age", 22);
        students.add(student2);

        HashMap<String, Object> student3 = new HashMap<>();
        student3.put("name", "Nora");
        student3.put("surname", "Bjornsson");
        student3.put("age", 19);
        students.add(student3);

        HashMap<String, Object> student4 = new HashMap<>();
        student4.put("name", "Ravi");
        student4.put("surname", "Patel");
        student4.put("age", 21);
        students.add(student4);

        HashMap<String, Object> student5 = new HashMap<>();
        student5.put("name", "Aiko");
        student5.put("surname", "Tanaka");
        student5.put("age", 23);
        students.add(student5);

        HashMap<String, Object> student6 = new HashMap<>();
        student6.put("name", "Jonas");
        student6.put("surname", "Lindström");
        student6.put("age", 20);
        students.add(student6);

        for(HashMap<String, Object> student : students){
            mock.add(Student.builder().first_name((String)student.get("name")).surname((String)student.get("surname")).age((int)student.get("age")).build());
        }

        return mock;
    }

}
