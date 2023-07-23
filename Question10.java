import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID)
        );

        for (String event : events) {
            String[] tokens = event.split(" ");
            if (tokens[0].equals("ENTER")) {
                String name = tokens[1];
                double cgpa = Double.parseDouble(tokens[2]);
                int id = Integer.parseInt(tokens[3]);
                Student student = new Student(id, name, cgpa);
                pq.add(student);
            } else if (tokens[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> result = new ArrayList<>(pq);
        Collections.sort(result, Comparator.comparing(Student::getID));
        return result;
    }
}

public class Question10 {
    public static void main(String[] args) {
        Priorities priorities = new Priorities();
        List<String> events = Arrays.asList(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        List<Student> students = priorities.getStudents(events);
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
