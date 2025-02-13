package com.TodoAppSalinda.demo.repository;

import com.TodoAppSalinda.demo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findByCompletedAndTaskStatus(boolean completed, String taskStatus);
}
