package mini_projects.SmartDailyPlanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Planner planner = new Planner();
        Scanner scanner = new Scanner(System.in);

        System.out.println("📅 Welcome to SmartDailyPlanner!");
        System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
        String priority = scanner.nextLine();


        // Input loop
        while (true) {
            System.out.println("\nEnter a task name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter duration in minutes: ");
            int duration = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter deadline (YYYY-MM-DD): ");
            String deadline = scanner.nextLine();

            Task task = new Task(name, duration, deadline, priority);
            planner.addTask(task);
            System.out.println("✅ Task added.");
        }

        System.out.println("\nHere's a smart tip for today:");
        System.out.println(DailyTipFetcher.fetchTip());

        System.out.println("\n🗂️ Tasks sorted by name:");
        planner.showTasksSortedByName();

        System.out.println("\n⏱️ Tasks sorted by duration:");
        planner.showTasksSortedByDuration();

        scanner.close();
    }
}
