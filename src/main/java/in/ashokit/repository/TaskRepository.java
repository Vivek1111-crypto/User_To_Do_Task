package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Task;
import in.ashokit.Entity.User;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task>findByUser(User user);
}
