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
    
}
