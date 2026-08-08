package pt1.HomeworkN2.main;
import java.util.List;

public class StudentProcessor {

    public String process(List<Student> students) {
        if (students == null) {
            return "No students";
        }

        return students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .mapToInt(Book::getYear)
                .boxed()
                .findFirst()
                .map(year -> "Found book published in: " + year)
                .orElse("No book found published after 2000");
    }
}
