package in.ashokit.service;

import java.util.List;

import in.ashokit.Entity.Task;
import in.ashokit.Entity.User;

public interface TaskService {
public void savetask(Task task,User user);
public List<Task>getTaskByUser(User user);

}
