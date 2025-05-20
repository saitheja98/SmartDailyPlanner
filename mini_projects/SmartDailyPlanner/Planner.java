package mini_projects.SmartDailyPlanner;

import java.time.LocalDate;
import java.util.*;

public class Planner {
    private Map<LocalDate, List<Task>> tasksByDate;

    public Planner() {
        tasksByDate = new HashMap<>();
    }

    public void addTask(Task task) {
        LocalDate deadline = task.getDeadline();
        tasksByDate.computeIfAbsent(deadline, k -> new ArrayList<>()).add(task);
    }

    public void displayTasksSortedByName() {
        List<Task> allTasks = getAllTasks();
        allTasks.sort(Comparator.comparing(Task::getName));
        System.out.println("\nTasks sorted by name:");
        allTasks.forEach(System.out::println);
    }

    public void displayTasksSortedByDuration() {
        List<Task> allTasks = getAllTasks();
        allTasks.sort(Comparator.comparingInt(Task::getDuration));
        System.out.println("\nTasks sorted by duration:");
        allTasks.forEach(System.out::println);
    }

    public void displayTasksSortedByPriority() {
        List<Task> allTasks = getAllTasks();
        allTasks.sort(Comparator.comparing(Task::getPriority));
        System.out.println("\nTasks sorted by priority:");
        allTasks.forEach(System.out::println);
    }

    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();
        tasksByDate.values().forEach(allTasks::addAll);
        return allTasks;
    }

    public Map<LocalDate, List<Task>> getTasksByDate() {
        return tasksByDate;
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}
