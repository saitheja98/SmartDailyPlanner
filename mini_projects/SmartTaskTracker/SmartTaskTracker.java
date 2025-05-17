
import java.util.*;
public class SmartTaskTracker {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. Mark Task as Done\n3. View Tasks\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    tasks.add(new Task(name));
                    break;
                case 2:
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ": " + tasks.get(i));
                    }
                    System.out.print("Which task number to mark done? ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).markDone();
                    }
                    break;
                case 3:
                    System.out.println("Your Tasks:");
                    tasks.forEach(System.out::println); // Lambda here!
                    break;
                case 4:
                    return;
            }
        }
    }
}
