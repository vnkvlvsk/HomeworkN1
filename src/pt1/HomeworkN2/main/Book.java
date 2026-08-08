package pt1.HomeworkN2.main;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() { return title; }
    public int getPages() { return pages; }
    public int getYear() { return year; }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return pages == b.pages && year == b.year && title.equals(b.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }

    @Override
    public String toString() {
        return "Book { title='" + title + "', pages=" + pages + ", year=" + year + " } ";
    }
}