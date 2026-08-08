package pt1.HomeworkN1;

public final class Course {

    private final String name;
    private final int durationWeeks;
    private final Schedule schedule;

    public Course(String name, int durationWeeks, Schedule schedule) {
        this.name = name;
        this.durationWeeks = durationWeeks;
        this.schedule = schedule.clone();
    }

    public String getName() {
        return name;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public Schedule getSchedule() {
        return schedule.clone();
    }
}
