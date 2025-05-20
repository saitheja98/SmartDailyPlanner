package mini_projects.SmartDailyPlanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class TaskManager {
    private final Planner planner;

    public TaskManager(Planner planner) {
        this.planner = planner;
    }

    public void loadTasks(String filename) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            String content = new String(bytes);

            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Task task = new Task(
                    obj.getString("name"),
                    obj.getInt("duration"),
                    LocalDate.parse(obj.getString("deadline")),
                    Planner.Priority.valueOf(obj.getString("priority")),
                    obj.optBoolean("isDone", false)
                );
                planner.addTask(task);
            }
            System.out.println("✅ Tasks loaded from " + filename);
        } catch (IOException e) {
            System.out.println("⚠️ No existing task file found. Starting fresh.");
        }
    }

    public void saveTasks(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            JSONArray array = new JSONArray();
            for (Task task : planner.getAllTasks()) {
                JSONObject obj = new JSONObject();
                obj.put("name", task.getName());
                obj.put("duration", task.getDuration());
                obj.put("deadline", task.getDeadline().toString());
                obj.put("priority", task.getPriority().name());
                obj.put("isDone", task.isDone());
                array.put(obj);
            }
            writer.write(array.toString(4));
            System.out.println("✅ Tasks saved to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Failed to save tasks.");
        }
    }
}
