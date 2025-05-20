package mini_projects.SmartDailyPlanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Here's a smart tip for today:\nStay motivated and keep going!");

        Planner planner = new Planner();
        TaskManager manager = new TaskManager(planner);

        manager.loadTasks("tasks.json");

        planner.displayTasksSortedByName();
        planner.displayTasksSortedByDuration();
        planner.displayTasksSortedByPriority();

        manager.saveTasks("tasks.json");
    }
}
