package pt1.HomeworkN2.tests;

import pt1.HomeworkN2.main.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;

    private static final String BASE_BOOK_TITLE = "Clean Code";
    private static final int BASE_BOOK_PAGES = 464;
    private static final int BASE_BOOK_YEAR = 2008;

    private static final String OTHER_BOOK_TITLE = "Other book";
    private static final int OTHER_BOOK_PAGES = 400;
    private static final int SMALLER_BOOK_PAGES = 300;
    private static final int BIGGER_BOOK_PAGES = 600;
    private static final int BIGGER_BOOK_YEAR = 2001;

    @BeforeEach
    void setUp() {
        book = new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
    }

    @Test
    void when_getTitle_then_returnCorrectTitle() {
        String result = book.getTitle();
        assertEquals(BASE_BOOK_TITLE, result);
    }

    @Test
    void when_getPages_then_returnCorrectPagesCount() {
        int result = book.getPages();
        assertEquals(BASE_BOOK_PAGES, result);
    }

    @Test
    void when_getYear_then_returnCorrectYearsCount() {
        int result = book.getYear();
        assertEquals(BASE_BOOK_YEAR, result);
    }

    @Test
    void when_compareToZero_then_returnPositive() {
        Book otherBook = new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        int result = book.compareTo(otherBook);
        assertEquals(0, result);
    }

    @Test
    void when_compareToLess_then_returnPositive() {
        Book biggerBook = new Book(OTHER_BOOK_TITLE, BIGGER_BOOK_PAGES, BASE_BOOK_YEAR);
        assertTrue(book.compareTo(biggerBook) < 0);
    }

    @Test
    void when_compareToGreater_then_returnPositive() {
        Book smallerBook = new Book(OTHER_BOOK_TITLE, SMALLER_BOOK_PAGES, BASE_BOOK_YEAR);
        assertTrue(book.compareTo(smallerBook) > 0);
    }

    @Test
    void when_testEquals_then_returnPositive() {
        Book otherBook = new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        boolean result = book.equals(otherBook);
        assertTrue(result);
    }

    @Test
    void when_testEquals_then_returnNegative() {
        Book otherBook = new Book(OTHER_BOOK_TITLE, OTHER_BOOK_PAGES, BIGGER_BOOK_YEAR);
        boolean result = book.equals(otherBook);
        assertFalse(result);
    }

    @Test
    void when_testHashCode_then_returnPositive() {
        Book otherBook = new Book(BASE_BOOK_TITLE, BASE_BOOK_PAGES, BASE_BOOK_YEAR);
        assertEquals(book.hashCode(), otherBook.hashCode());
    }

    @Test
    void when_testHashCode_then_returnNegative() {
        Book otherBook = new Book(OTHER_BOOK_TITLE, OTHER_BOOK_PAGES, BASE_BOOK_YEAR);
        assertNotEquals(book.hashCode(), otherBook.hashCode());
    }

    @Test
    void when_testToString_then_returnPositive() {
        String result = book.toString();
        String expected = "Book { title='" + BASE_BOOK_TITLE + "', pages=" + BASE_BOOK_PAGES + ", year=" + BASE_BOOK_YEAR + " } ";
        assertEquals(expected, result);
    }

    @Test
    void when_testToString_then_returnNegative() {
        String result = book.toString();
        String expected = "Book { title='" + OTHER_BOOK_TITLE + "', pages=" + OTHER_BOOK_PAGES + ", year=" + BASE_BOOK_YEAR + " } ";
        assertNotEquals(expected, result);
    }
}