package com.csc340.jpademo.student;


import com.csc340.jpademo.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "select s from tasks s where id > ?1", nativeQuery = true)
    public List<Task> getAllTask(int id);

    @Query(value = "SELECT t from Task t where t.goalID = ?1")
    List<Task> findByGoalID(int goalID);
}
