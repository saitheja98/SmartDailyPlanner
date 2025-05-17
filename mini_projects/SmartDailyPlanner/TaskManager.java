package mini_projects.SmartDailyPlanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    public static void saveTasksToFile(List<Task> tasks, String filename) {
        JSONArray taskArray = new JSONArray();
        for (Task task : tasks) {
            JSONObject obj = new JSONObject();
            obj.put("name", task.getName());
            obj.put("duration", task.getDuration());
            obj.put("completed", task.isCompleted());
            obj.put("deadline", task.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            obj.put("priority", task.getPriority().toString());
            taskArray.put(obj);
        }

        try (FileWriter file = new FileWriter(filename)) {
            file.write(taskArray.toString(2));
            System.out.println("✅ Tasks saved to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Failed to save tasks: " + e.getMessage());
        }
    }

    public static void loadTasksFromFile(List<Task> tasks, String filename) {
        try (Scanner reader = new Scanner(new FileReader(filename))) {
            StringBuilder jsonStr = new StringBuilder();
            while (reader.hasNextLine()) {
                jsonStr.append(reader.nextLine());
            }

            JSONArray taskArray = new JSONArray(jsonStr.toString());
            for (int i = 0; i < taskArray.length(); i++) {
                JSONObject obj = taskArray.getJSONObject(i);
                Task task = new Task(
                    obj.getString("name"),
                    obj.getInt("duration"),
                    obj.getString("deadline"),
                    obj.getString("priority")
                );

                if (obj.getBoolean("completed")) {
                    task.markComplete();
                }

                tasks.add(task);
            }

            System.out.println("✅ Tasks loaded from " + filename);
        } catch (Exception e) {
            System.out.println("❌ Failed to load tasks: " + e.getMessage());
        }
    }
}
