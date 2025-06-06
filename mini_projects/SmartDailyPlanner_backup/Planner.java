package mini_projects.SmartDailyPlanner;

import java.util.*;

public class Planner {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void showTasksSortedByDuration() {
        tasks.stream()
            .sorted(Comparator.comparingInt(Task::getDuration))
            .forEach(System.out::println);
    }

    public void showTasksSortedByName() {
        tasks.stream()
            .sorted(Comparator.comparing(Task::getName))
            .forEach(System.out::println);
    }
}

