package mini_projects.SmartDailyPlanner;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Planner {
    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    private final List<Task> tasks;

    public Planner() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void printSummaryReport() {
        long completed = tasks.stream().filter(Task::isDone).count();
        long pending = tasks.size() - completed;

        Map<Priority, Long> byPriority = tasks.stream()
            .collect(Collectors.groupingBy(Task::getPriority, Collectors.counting()));

        System.out.println("📊 Task Summary Report:");
        System.out.println("--------------------------");
        System.out.println("Total tasks     : " + tasks.size());
        System.out.println("✅ Completed     : " + completed);
        System.out.println("⏳ Pending       : " + pending);
        System.out.println("🔢 By Priority:");
        for (Priority p : Priority.values()) {
            System.out.printf("   • %s: %d%n", p, byPriority.getOrDefault(p, 0L));
        }
        System.out.println("--------------------------\n");
    }

    public void printTasksSortedByName() {
        tasks.stream()
            .sorted(Comparator.comparing(Task::getName))
            .forEach(System.out::println);
    }

    public void printTasksSortedByDuration() {
        tasks.stream()
            .sorted(Comparator.comparingInt(Task::getDuration))
            .forEach(System.out::println);
    }

    public void printTasksSortedByPriority() {
        tasks.stream()
            .sorted(Comparator.comparing(Task::getPriority))
            .forEach(System.out::println);
    }
}
