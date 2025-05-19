package mini_projects.SmartDailyPlanner;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class Planner {
    private List<Task> tasks;
    private Map<LocalDate, List<Task>> tasksByDate;

    public Planner() {
        tasks = new ArrayList<>();
        tasksByDate = new TreeMap<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        tasksByDate.computeIfAbsent(task.getDeadline(), k -> new ArrayList<>()).add(task);
    }

    public void showTasksSortedByName() {
        tasks.stream()
             .sorted(Comparator.comparing(Task::getName))
             .forEach(System.out::println);
    }

    public void showTasksSortedByDuration() {
        tasks.stream()
             .sorted(Comparator.comparingInt(Task::getDuration))
             .forEach(System.out::println);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getTasksForDate(LocalDate date) {
        return tasksByDate.getOrDefault(date, new ArrayList<>());
    }

    public Map<LocalDate, List<Task>> getTasksByDate() {
        return tasksByDate;
    }

    public void showCalendarView() {
        YearMonth currentMonth = YearMonth.now();
        int daysInMonth = currentMonth.lengthOfMonth();
        LocalDate startOfMonth = currentMonth.atDay(1);
        int dayOfWeekStart = startOfMonth.getDayOfWeek().getValue();

        System.out.println("\n------- " + currentMonth.getMonth().toString() + " " + currentMonth.getYear() + " -------");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        String[][] calendarGrid = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                calendarGrid[i][j] = "   ";
            }
        }

        int currentRow = 0;
        int currentColumn = dayOfWeekStart - 1;

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate currentDate = LocalDate.of(currentMonth.getYear(), currentMonth.getMonthValue(), day);
            String dayStr = String.format("%2d", day);
            calendarGrid[currentRow][currentColumn] = dayStr;

            if (tasksByDate.containsKey(currentDate)) {
                List<Task> tasksForDay = tasksByDate.get(currentDate);
                for (Task task : tasksForDay) {
                    String priorityMarker = "";
                    switch (task.getPriority()) {
                        case HIGH:
                            priorityMarker = "H";
                            break;
                        case MEDIUM:
                            priorityMarker = "M";
                            break;
                        case LOW:
                            priorityMarker = "L";
                            break;
                    }
                    calendarGrid[currentRow][currentColumn] = priorityMarker;
                    break;
                }
            }

            currentColumn++;
            if (currentColumn > 6) {
                currentColumn = 0;
                currentRow++;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + calendarGrid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------");
        System.out.println("H - High Priority, M - Medium Priority, L - Low Priority");
    }
}