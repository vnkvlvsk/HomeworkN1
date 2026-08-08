package pt1.HomeworkN2.main;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentFileReader reader = new StudentFileReader();
        List<Student> students = reader.readFromFile("src/pt1.HomeworkN2/main/students.txt");

        System.out.println("Students loaded: " + students.size());
        System.out.println("---");

        StudentProcessor processor = new StudentProcessor();
        System.out.println(processor.process(students));
    }
}