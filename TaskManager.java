import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;

public class TaskManager {
    static class Task {
        String id;
        String title;
        String description;
        boolean done;
        LocalDateTime createdAt;
        Task(String title, String description) {
            this.id = UUID.randomUUID().toString();
            this.title = title;
            this.description = description;
            this.done = false;
            this.createdAt = LocalDateTime.now();
        }
    }

    static final String FILE = "tasks.txt";
    static List<Task> tasks = new ArrayList<>();

    static void load() {
        try {
            if (!Files.exists(Paths.get(FILE))) return;
            List<String> lines = Files.readAllLines(Paths.get(FILE));
            for (String line : lines) {
                String[] p = line.split("\\|");
                Task t = new Task(p[1], p[2]);
                t.id = p[0];
                t.done = Boolean.parseBoolean(p[3]);
                t.createdAt = LocalDateTime.parse(p[4]);
                tasks.add(t);
            }
        } catch (Exception ignored) {}
    }

    static void save() {
        try {
            List<String> out = new ArrayList<>();
            for (Task t : tasks)
                out.add(t.id + "|" + t.title + "|" + t.description + "|" + t.done + "|" + t.createdAt);
            Files.write(Paths.get(FILE), out);
        } catch (Exception ignored) {}
    }

    public static void main(String[] args) {
        load();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n1.List 2.Add 3.Remove 4.Done 5.Exit");
            String c = sc.nextLine();
            if (c.equals("1")) {
                if (tasks.isEmpty()) System.out.println("No tasks");
                else for (Task t : tasks)
                    System.out.println(t.id+" | "+t.title+" | "+(t.done?"DONE":"TODO")+" | "+t.createdAt);
            } else if (c.equals("2")) {
                System.out.print("Title: ");
                String t = sc.nextLine();
                System.out.print("Desc: ");
                String d = sc.nextLine();
                Task nt = new Task(t, d);
                tasks.add(nt);
                save();
                System.out.println("Added: " + nt.id);
            } else if (c.equals("3")) {
                System.out.print("ID: ");
                String id = sc.nextLine();
                tasks.removeIf(x -> x.id.equals(id));
                save();
                System.out.println("Removed");
            } else if (c.equals("4")) {
                System.out.print("ID: ");
                String id = sc.nextLine();
                for (Task t : tasks) if (t.id.equals(id)) t.done = true;
                save();
                System.out.println("Marked done");
            } else if (c.equals("5")) run = false;
        }
        sc.close();
    }
}
