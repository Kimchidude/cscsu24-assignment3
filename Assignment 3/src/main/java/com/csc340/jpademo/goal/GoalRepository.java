package com.csc340.jpademo.goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    @Query(value = "select s from goals s where id > ?1", nativeQuery = true)
    public List<Goal> getAllGoal(int id);
}
