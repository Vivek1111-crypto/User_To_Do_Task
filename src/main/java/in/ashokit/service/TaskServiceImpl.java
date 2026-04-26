package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Task;
import in.ashokit.Entity.User;
import in.ashokit.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {
@Autowired
	private TaskRepository taskrepo;
	
	@Override
	public void savetask(Task task, User user) {
		// TODO Auto-generated method stub
task.setUser(user);
taskrepo.save(task);
	}

	@Override
	public List<Task> getTaskByUser(User user) {
		// TODO Auto-generated method stub
		return taskrepo.findByUser(user);
	}

}
