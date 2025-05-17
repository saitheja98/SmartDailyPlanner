package mini_projects.SmartDailyPlanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Task {
    private String name;
    private int duration; // in minutes
    private boolean isCompleted;
    private LocalDate deadline;
    private Priority priority;



    public Task(String name, int duration, String deadlineStr, String priorityStr) {
        this.name = name;
        this.duration = duration;
        this.isCompleted = false;
        this.deadline = LocalDate.parse(deadlineStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.priority = Priority.valueOf(priorityStr.toUpperCase()); // Converts string to enum
    }    
    

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markComplete() {
        this.isCompleted = true;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
    
    public Priority getPriority() {
        return priority;
    }
        
    @Override
    public String toString() {
    return name + " - " + duration + " min - Due: " + deadline + " - Priority: " + priority + (isCompleted ? " [✔]" : " [ ]");
    }


}


