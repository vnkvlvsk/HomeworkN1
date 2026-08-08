package pt1.HomeworkN1;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements Cloneable {
    private List<String> lessons;

    public Schedule(List<String> lessons) {
        this.lessons = lessons != null ? new ArrayList<>(lessons) : new ArrayList<>();
    }

    public List<String> getLessons() {
        return lessons;
    }

    @Override
    public Schedule clone() {
        return new Schedule(this.lessons);
    }

    public void addLesson(String lesson) {
        if (lesson == null) { return; }
        lessons.add(lesson);
    }

    public void removeLesson(String lesson) {
        if (lesson == null) { return; }
        lessons.remove(lesson);
    }
}
