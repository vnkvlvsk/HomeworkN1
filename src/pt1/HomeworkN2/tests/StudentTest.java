package pt1.HomeworkN2.tests;

import pt1.HomeworkN2.main.Book;
import pt1.HomeworkN2.main.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class StudentTest {
    Student student;
    List<Book> books = new ArrayList<>();

    private static final String BASE_STUDENT_NAME = "Ivan";
    private static final String OTHER_STUDENT_NAME = "Other name";

    private static final String BASE_BOOK_TITLE = "Clean Code";
    private static final String OTHER_BOOK_TITLE = "Other book title";
    private static final int BASE_BOOK_PAGES = 464;
    private static final int BASE_BOOK_YEAR = 2008;

    @BeforeEach
    void setUp() {
        books.add(new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR));
        student = new Student(BASE_STUDENT_NAME, books);
    }

    @Test
    void when_getName_returnCorrectName() {
        String name = student.getName();
        assertEquals(BASE_STUDENT_NAME, name);
    }

    @Test
    void when_getBooks_then_returnExpectedList() {
        List<Book> result = student.getBooks();
        assertEquals(books, result);
    }

    @Test
    void when_toString_then_returnCorrectFormat() {
        String result = student.toString();
        assertEquals("Student { name='" + BASE_STUDENT_NAME + "', books=[Book { title='" + BASE_BOOK_TITLE + "', pages=" + BASE_BOOK_PAGES + ", year=" + BASE_BOOK_YEAR + " } ] } ", result);
    }

    @Test
    void when_testEquals_then_returnPositive() {
        Book otherBook = new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        Student otherStudent = new Student(BASE_STUDENT_NAME, List.of(otherBook));
        boolean result = student.equals(otherStudent);
        assertTrue(result);
    }

    @Test
    void when_testEquals_then_returnNegative() {
        Book otherBook = new Book(OTHER_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        Student otherStudent = new Student(OTHER_STUDENT_NAME, List.of(otherBook));
        boolean result = student.equals(otherStudent);
        assertFalse(result);
    }

    @Test
    void when_testHashCode_then_returnPositive() {
        Book otherBook = new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        Student otherStudent = new Student(BASE_STUDENT_NAME, List.of(otherBook));
        assertEquals(student.hashCode(), otherStudent.hashCode());
    }

    @Test
    void when_testHashCode_then_returnNegative() {
        Book otherBook = new Book(OTHER_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        Student otherStudent = new Student(OTHER_STUDENT_NAME, List.of(otherBook));
        assertNotEquals(student.hashCode(), otherStudent.hashCode());
    }
}