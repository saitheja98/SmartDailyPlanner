package mini_projects.SmartDailyPlanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Here's a smart tip for today:");
        System.out.println(DailyTipFetcher.fetchTip());
        System.out.println();

        Planner planner = new Planner();

        // Load tasks from file if available
        TaskManager.loadTasksFromFile(planner.getTasks(), "tasks.json");

        // Add new tasks (you can modify this as needed)
        planner.addTask(new Task("Do homework", 30, "2025-05-20", "HIGH"));
        planner.addTask(new Task("Lunch", 20, "2025-05-18", "LOW"));
        planner.addTask(new Task("Play games", 45, "2025-05-22", "MEDIUM"));

        // Show tasks
        System.out.println("\nTasks sorted by name:");
        planner.showTasksSortedByName();

        System.out.println("\nTasks sorted by duration:");
        planner.showTasksSortedByDuration();

        // Save tasks to file
        TaskManager.saveTasksToFile(planner.getTasks(), "tasks.json");
    }
}
