package mini_projects.SmartDailyPlanner;

public class Main {
    public static void main(String[] args) {
        SmartQuoteGenerator.printTip();

        Planner planner = new Planner();
        TaskManager manager = new TaskManager(planner);
        manager.loadTasks("tasks.json");

        System.out.println("\nTasks sorted by name:");
        planner.printTasksSortedByName();

        System.out.println("\nTasks sorted by duration:");
        planner.printTasksSortedByDuration();

        System.out.println("\nTasks sorted by priority:");
        planner.printTasksSortedByPriority();

        planner.printSummaryReport();

        manager.saveTasks("tasks.json");
    }
}
