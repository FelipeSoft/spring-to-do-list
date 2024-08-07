package net.felipe.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import net.felipe.app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> { }