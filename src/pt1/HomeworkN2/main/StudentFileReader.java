package pt1.HomeworkN2.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {

    public List<Student> readFromFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            String currentName = null;
            List<Book> currentBooks = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    currentBooks.add(new Book(
                            parts[0].trim(),
                            Integer.parseInt(parts[1].trim()),
                            Integer.parseInt(parts[2].trim())
                    ));
                } else {
                    if (currentName != null) {
                        students.add(new Student(currentName, new ArrayList<>(currentBooks)));
                        currentBooks.clear();
                    }
                    currentName = line;
                }
            }

            if (currentName != null) {
                students.add(new Student(currentName, currentBooks));
            }
        }

        return students;
    }
}
