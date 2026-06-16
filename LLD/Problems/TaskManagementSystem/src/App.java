import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.time.LocalDateTime;

import LLD.Problems.TaskManagementSystem.enums.PriorityLevel;
import LLD.Problems.TaskManagementSystem.enums.TaskStatus;
import LLD.Problems.TaskManagementSystem.models.Task;
import LLD.Problems.TaskManagementSystem.models.TaskManagementSystem;
import LLD.Problems.TaskManagementSystem.models.User;

public class App {
    public static void main(String[] args) throws Exception {
        TaskManagementSystem taskManagementSystem = TaskManagementSystem.getInstance();

        User user1 = taskManagementSystem.addUser("1", "person 1");
        User user2 = taskManagementSystem.addUser("2", "person 2");
        User user3 = taskManagementSystem.addUser("3", "person 3");

        Task task1 =  taskManagementSystem.createTask("1", "gym", "gym chale jaya kar aalsi insaan", "1", PriorityLevel.HIGH, LocalDateTime.now().plusHours(3));
        taskManagementSystem.startTaskById(task1.getTaskId());

        task1.setAssignedUser(user2);

        taskManagementSystem.markTaskAsCompleted(task1.getTaskId());

        task1.setAssignedUser(user3);
        taskManagementSystem.reOpenTask(task1.getTaskId());
    }
}
