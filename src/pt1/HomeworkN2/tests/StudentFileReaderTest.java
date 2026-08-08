package pt1.HomeworkN2.tests;

import pt1.HomeworkN2.main.Book;
import pt1.HomeworkN2.main.Student;
import pt1.HomeworkN2.main.StudentFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentFileReaderTest {
    StudentFileReader studentFileReader;

    static final String WRONG_PATH = "wrong/path.txt";
    static final String CORRECT_PATH = "src/pt1.HomeworkN2/tests/studentsTest.txt";

    static final String BASE_STUDENT_NAME = "Ivan";
    static final String FIRST_BASE_BOOK_TITLE = "The Great Gatsby";
    static final String SECOND_BASE_BOOK_TITLE = "Clean Code";
    static final int FIRST_BASE_BOOK_PAGES = 180;
    static final int SECOND_BASE_BOOK_PAGES = 464;
    static final int FIRST_BASE_BOOK_YEAR = 1925;
    static final int SECOND_BASE_BOOK_YEAR = 2008;

    @BeforeEach
    void setUp() {
        studentFileReader = new StudentFileReader();
    }

    @Test
    void when_readFromFileAndFileDoesNotExist_then_throwIOException() {
        assertThrows(IOException.class, () -> studentFileReader.readFromFile(WRONG_PATH));
    }

    @Test
    void when_readFromFile_then_returnExpectedList() throws IOException {
        List<Student> readerStudents = studentFileReader.readFromFile(CORRECT_PATH);

        Book firstExpectedBook = new Book(FIRST_BASE_BOOK_TITLE, FIRST_BASE_BOOK_PAGES, FIRST_BASE_BOOK_YEAR);
        Book secondExpectedBook = new Book(SECOND_BASE_BOOK_TITLE, SECOND_BASE_BOOK_PAGES, SECOND_BASE_BOOK_YEAR);

        List<Book> expectedBooks = List.of(firstExpectedBook, secondExpectedBook);

        Student expectedStudent = new Student(BASE_STUDENT_NAME, expectedBooks);

        List<Student> expectedStudents = List.of(expectedStudent);

        assertEquals(expectedStudents, readerStudents);
    }

    @Test
    void when_readFromFile_then_returnUnexpectedList() throws IOException {
        List<Student> readerStudents = studentFileReader.readFromFile(CORRECT_PATH);

        Book firstExpectedBook = new Book(FIRST_BASE_BOOK_TITLE, FIRST_BASE_BOOK_PAGES, FIRST_BASE_BOOK_YEAR);

        List<Book> expectedBooks = List.of(firstExpectedBook);

        Student expectedStudent = new Student(BASE_STUDENT_NAME, expectedBooks);

        List<Student> expectedStudents = List.of(expectedStudent);

        assertNotEquals(expectedStudents, readerStudents);
    }
}