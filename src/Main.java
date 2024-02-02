import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static class Task{
        private static int nextId = 1;
        private int id;
        private String title;
        private String description;
        public Task (String title, String description){
            this.id = nextId++;
            this.title = title;
            this.description = description;
        }
        public int getId(){
            return id;
        }
        public String getTitle(){
            return title;
        }
        public String getDescription(){
            return description;
        }
        @Override
        public String toString(){
            return "Task #" + id + ":" + title + ":" + description;
        }
    }

    public static class TaskManager{
        private List<Task> taskList;

        public TaskManager(){
            this.taskList = new ArrayList<>();
        }
        public void addTask(String title, String description){
            Task newTask = new Task (title, description);
            taskList.add(newTask);
            System.out.println("Task added successfully");
        }
        public void displayTasks(){
            if (taskList.isEmpty()){
                System.out.println("No tasks available");

            } else {
                System.out.println("Task List:");
                for (Task task: taskList){
                    System.out.println(task);
                }
            }
        }
        public void removeTask(int taskId){
            boolean removed = false;
            for (Task task : taskList) {
                if (task.getId() == taskId) {
                    taskList.remove(task);
                    removed = true;
                    System.out.println("Task removed");
                    break;
                }
            }
           if (!removed){
               System.out.println("Task not found with the ID: " + taskId);
           }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true){
            System.out.println("\n Menu: ");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");

            System.out.println("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(title, description);
                    break;
                case 2:
                    taskManager.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter the ID of the task to remove: ");
                    int taskIdToRemove = scanner.nextInt();
                    taskManager.removeTask(taskIdToRemove);
                    break;
                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

    }
}