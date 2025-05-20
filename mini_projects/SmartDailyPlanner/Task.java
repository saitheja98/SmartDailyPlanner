package mini_projects.SmartDailyPlanner;

import java.time.LocalDate;

public class Task {
    private String name;
    private int duration;
    private LocalDate deadline;
    private Planner.Priority priority;
    private boolean isDone;

    public Task(String name, int duration, LocalDate deadline, Planner.Priority priority, boolean isDone) {
        this.name = name;
        this.duration = duration;
        this.deadline = deadline;
        this.priority = priority;
        this.isDone = isDone;
    }

    public String getName() { return name; }
    public int getDuration() { return duration; }
    public LocalDate getDeadline() { return deadline; }
    public Planner.Priority getPriority() { return priority; }
    public boolean isDone() { return isDone; }

    @Override
    public String toString() {
        return name + " - " + duration + " min - Due: " + deadline + " - Priority: " + priority + (isDone ? " [✓]" : " [ ]");
    }
}
